package edu.baykov.spring.processor;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.*;

import static edu.baykov.annotation.YesOrNo.NO;

/**
 * 9.3.3 Прострочить контейнером. Создайте постобработчик на основе логики создания метода toString из задачи 8.3.3,
 * однако теперь нет необходимости наследоваться от класса Entity.
 * Необходимость генерировать строковую форму определяется самим наличием аннотации ToString.
 * Если постобработчик обнаруживает такую аннотацию то он должен добавить соответствующий метод в объект.
 */

@Component
public class ToStringAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (isAnnotationPresent(bean)) {
            map.put(beanName, bean);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private static boolean isAnnotationPresent(Object bean) {
        long fieldsAnnotation = Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(ToString.class))
                .count();
        return bean.getClass().isAnnotationPresent(ToString.class) || fieldsAnnotation > 0;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) {
            return Enhancer.create(map.get(beanName).getClass(),
                    (MethodInterceptor) (b, m, args, mProxy) -> {
                        if ("toString".equals(m.getName())) return toString(b);
                        return mProxy.invokeSuper(b, args);
                    });
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @SneakyThrows
    private static String toString(Object obj) {
        Class<?> clazz = obj.getClass();
        String result = clazz.getSimpleName() + "{";
        ArrayList<String> fieldsAndValues = new ArrayList<>();

        List<Field> fields = getAllFields(clazz);
        for (Field field : fields) {
            ToString clazzAnnotation = field.getDeclaringClass().getAnnotation(ToString.class);
            ToString fieldAnnotation = field.getAnnotation(ToString.class);
            if (fieldAnnotation == null) fieldAnnotation = clazzAnnotation;
            if (fieldAnnotation == null) continue;
            if (fieldAnnotation.value() == NO) continue;
            fieldsAndValues.add(field.getName() + "=" + field.get(obj));
        }
        return result + String.join(", ", fieldsAndValues) + "}";
    }

    private static ArrayList<Field> getAllFields(Class<?> clz) {
        if (clz == null) return new ArrayList<>();
        ArrayList<Field> result = getAllFields(clz.getSuperclass());
        result.addAll(Arrays.stream(clz.getDeclaredFields()).toList());
        return result;
    }
}
