package edu.baykov.spring.processor;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * 9.3.1 Контроль имен контейнером. Создайте постобработчик, который проверяет объекты на наличие поля с именем name.
 * Если такое поле есть, имеет строковый тип, а его значение равно null, то необходимо присвоить туда значение “vasia”.
 */

@Component
public class NameControlBeanPostProcessor<T> implements BeanPostProcessor {
    @Value("name")
    private String fieldName;
    @Value("Vasya")
    private T defaultValue;
    @Value("java.lang.String")
    private Class<T> type;

    @Override
    @SneakyThrows
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Class<?> clz = bean.getClass();

        if (!hasField(clz)) return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);

        String setterName = "set" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);

        if (hasSetter(clz, setterName)) {
            Method m = clz.getDeclaredMethod(setterName, type);
            m.invoke(bean, defaultValue);
        } else {
            Field f = clz.getDeclaredField(fieldName);
            f.setAccessible(true);
            f.set(bean, defaultValue);
        }
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    private boolean hasField(Class<?> clz) {
        long count = Arrays.stream(clz.getDeclaredFields())
                .filter(f -> f.getType() == type)
                .filter(f -> fieldName.equals(f.getName()))
                .count();
        return count > 0;
    }

    private boolean hasSetter(Class<?> clz, String setterName) {
        long count = Arrays.stream(clz.getDeclaredMethods())
                .filter(f -> setterName.equals(f.getName()))
                .filter(f -> f.getParameterCount() == 1)
                .filter(f-> Arrays.asList(f.getParameterTypes()).contains(type))
                .count();
        return count > 0;
    }
}
