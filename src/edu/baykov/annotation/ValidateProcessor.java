package edu.baykov.annotation;

import lombok.SneakyThrows;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 8.3.4. - 8.3.5 Обработчик аннотации {@code @Validate}, со следующими характеристиками:
 •	имеет метод {@code validate}:
 1.	Аннотация описывает набор тестов, которые должен пройти входной объект.
 2.	Если тест пройден успешно – метод заканчивает работу без дополнительной информации.
 3.	Если объект не прошел тест – выбрасывается Exception с информацией о проблеме.
 4. Обнаруживает аннотации {@code @Validate}, которыми в свою очередь проаннотированы аннотации класса
 и такая аннотация считается её псевдонимом и используется полностью аналогично
 * @author   Nikolay Baykov
 */

public class ValidateProcessor {

    @SneakyThrows
    public static void validate(Object... objects) {
        for (Object obj : objects) {
            Class<?>[] testsArray = getTestsArray(obj);
            if (testsArray == null) continue;

            /**
             * Тестируем...
             */

            for (Class<?> c : testsArray) {
                Constructor<?> constructor = c.getDeclaredConstructor();
                constructor.setAccessible(true);
                Method[] methods = c.getDeclaredMethods();

                Object tmpObject = constructor.newInstance();
                for (Method m : methods) {
                    m.setAccessible(true);
                    try {
                        m.invoke(tmpObject, obj);
                    } catch (InvocationTargetException e) {
                        throw e.getCause();
                    } catch (IllegalAccessException e) {
                        throw e;
                    }

                }
            }
        }
    }

    private static Class<?>[] getTestsArray(Object obj) {
        Class<?> clazz = obj.getClass();

        /**
         * Массив классов, содержащих тестирующие методы
         */
        Class<?>[] testsArray = null;

        /**
         * Получаем значения для массива из аннотации {@code @Validate} класса, но если ее нет, получаем список
         * всех аннотаций класса и ищем {@code @Validate} среди их аннотаций. Если находим, получаем значение оттуда.
         */
        if (clazz.isAnnotationPresent(Validate.class)) {
            testsArray = clazz.getAnnotation(Validate.class).value();
        } else  {
            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a : annotations) {
                Class<?> annotationClass = a.annotationType();
                if (!annotationClass.isAnnotationPresent(Validate.class)) continue;
                testsArray = annotationClass.getAnnotation(Validate.class).value();
            }
        }
        return testsArray;
    }
}
