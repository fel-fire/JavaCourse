package edu.baykov.annotation;


import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 8.3.2. Обработчик аннотации {@code @Default}, со следующими характеристиками:
 •	имеет метод {@code reset}
 Данный метод принимает набор объектов типа Object и просматривает их классы и поля (в том числе унаследованные)
 на наличие аннотации @Default. Значения по умолчанию получаются из контекста {@code DefaultValuesContext}. Если значение
 в контексте отсутствует, применяется значение стандартное для языка программирования.
 * @author   Nikolay Baykov
 */
public class DefaultAnnotationProcessor {

    @SneakyThrows
    public static void reset(Object... objects) {
        for (Object obj : objects) {
            Class clazz = obj.getClass();
            while (clazz != null) {
                Field[] fields = clazz.getDeclaredFields();

                for (Field field : fields) {
                    /**
                     * Если аннотации нет ни на поле, ни на классе, пропускаем поле.
                     */
                    if (!clazz.isAnnotationPresent(Default.class) && !field.isAnnotationPresent(Default.class))
                        continue;
                    /**
                     * Получаем контекст со значениями по умолчанию.
                     */
                    DefaultValuesContext context = DefaultValuesContext.getContext();

                    field.setAccessible(true);

                    /**
                     * Получаем ключ для извлечения значения из контекста. Если было аннотировано поле, получаем
                     * объект .class из значения установленного в аннотации {@code @Default}. Если полученный класс
                     * не будет соответствовать типу поля выбросится IllegalArgumentException.
                     * В случае если аннотирован класс, то ключи получаются из типов полей класса.
                     */
                    Class<?> key;
                    if (field.isAnnotationPresent(Default.class))
                        key = field.getAnnotation(Default.class).value();
                    else key = field.getType();

                    /**
                     * Упаковка примитивных типов с помощью кастомного обработчика
                     */
                    key = PrimitivesBoxer.box(key);
                    if (context.containsClass(key)) field.set(obj, context.getDefaultValue(key));

                }
                /**
                 * Поднимаемся на класс вверх по иерархии наследования
                 */
                clazz = clazz.getSuperclass();
            }
        }
    }
}
