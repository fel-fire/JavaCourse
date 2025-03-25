package edu.baykov.annotation;

import lombok.SneakyThrows;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 8.3.1. Обработчик аннотации {@code @Invoke}, со следующими характеристиками:
 •	имеет метод {@code collect}
 Получает все описываемые полученными классами методы, и вызвает их, если они удовлетворяют следующим условиям:
 •1.	Не имеют входных параметров
 •2.	Возвращают какое-либо значение
 •3.	Могут быть как статическими так и объектными
 •4.	Помечены аннотацией @Invoke

 * @author   Nikolay Baykov
 */
public class InvokeAnnotationProcessor {
    static Map<String, Object> result = new HashMap<>();
    @SneakyThrows
    public static Map<String, Object> collect(Class... classes) {

        for (Class<?> c : classes) {

            Method[] methods = c.getDeclaredMethods();
            Constructor<?> constructor = c.getDeclaredConstructor();

            Object obj = null;
            for (Method m : methods) {
                if (m.isAnnotationPresent(Invoke.class) &&
                        m.getReturnType() != void.class &&
                        m.getParameterCount() == 0) {
                    if (obj == null) obj = constructor.newInstance();
                    result.put(m.getName(), m.invoke(obj));
                }

            }
        }
        return result;
    }
}
