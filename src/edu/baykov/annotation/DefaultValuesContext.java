package edu.baykov.annotation;

import lombok.SneakyThrows;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 8.3.2. Контекст значений по умолчанию {@code @DefaultValuesContext}, является Синглтоном.
 Хранит в себе дефолтные значения для каждого из классов. Значения задаются через конфигурационный класс
 {@code @DefaultValuesContextConfig}. Для классов - примитивов содержит значения их классов - оберток.
 * @author   Nikolay Baykov
 */

public class DefaultValuesContext {

    private static DefaultValuesContext projectValuesContext;
    private final Map<Class, Object> defaultValues = new HashMap<>();

    /**
     * Конструктор, осуществляет заполнение контекста в соответствии с конфиг-классом.
     */
    @SneakyThrows
    private DefaultValuesContext() {
        DefaultValuesContextConfig config = new DefaultValuesContextConfig();
        Class<?> configClass = config.getClass();
        for (Method m : configClass.getDeclaredMethods()) {
            /**
             * И снова упаковка примитивных классов. Наверное, должна быть идея получше...
             */
            Class type = PrimitivesBoxer.box(m.getReturnType());
            defaultValues.put(type, m.invoke(config));
        }
    }

    public static DefaultValuesContext getContext() {
        if (projectValuesContext == null) projectValuesContext = new DefaultValuesContext();
        return projectValuesContext;
    }

    @Override
    public String toString() {
        return "DefaultValuesContext{" +
                "defaultValues=" + defaultValues +
                '}';
    }

    /**
     * Метод получения значения с автоматическим приведением типа
     */
    public <T> T getDefaultValue(Class<T> tClass) {
        return tClass.cast(defaultValues.get(tClass));
    }

    public boolean containsClass(Class<?> tClass) {
        return defaultValues.containsKey(tClass);
    }

}
