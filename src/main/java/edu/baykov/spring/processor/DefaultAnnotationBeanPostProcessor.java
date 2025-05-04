package edu.baykov.spring.processor;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 9.3.2 Умолчания контейнера. Создайте постобработчик на основе метода reset из задачи 8.3.2. Необходимо:
 * 1.	Поменять тип свойства аннотации @Default (из задачи 8.2.2) на строковый.
 * Под строкой подразумевается имя бина содержащего значение по умолчанию:
 * a.	Если проаннотировано поле – то бин и есть значение по умолчанию
 * b.	Если проаннотирован класс – то у него есть методы получения значения по умолчанию.
 * 2.	Реализовать логику выполнения метода reset для каждого бина в контейнере.
 */

@Component
public class DefaultAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Autowired
    private ApplicationContext context;
    private Map<String, Object> map = new HashMap<>();

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (isAnnotationPresent(bean)) {
            map.put(beanName, bean);
        }
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    private static boolean isAnnotationPresent(Object bean) {
        long fieldsAnnotation = Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(f -> f.isAnnotationPresent(Default.class))
                .count();
        return bean.getClass().isAnnotationPresent(Default.class) || fieldsAnnotation > 0;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (map.containsKey(beanName)) reset(map.get(beanName));
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @SneakyThrows
    private void reset(Object obj) {
        Class<?> clz = obj.getClass();

        if (clz.isAnnotationPresent(Default.class)) {
            String beanName = clz.getAnnotation(Default.class).beanName();
            Object bean = context.getBean(beanName);
            for (Method declaredMethod : bean.getClass().getDeclaredMethods()) {
                declaredMethod.invoke(bean);
            }
        }

        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            Default annotation;
            if ((annotation = field.getAnnotation(Default.class)) == null)
                continue;
            String beanName = annotation.beanName();
            field.setAccessible(true);
            field.set(obj, context.getBean(beanName));
        }
    }
}
