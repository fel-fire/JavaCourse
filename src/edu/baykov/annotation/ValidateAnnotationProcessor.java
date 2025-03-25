package edu.baykov.annotation;

import java.lang.annotation.Annotation;
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

public class ValidateAnnotationProcessor {

    public static void validate(Object... objects) {
        for (Object obj : objects) {
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
                    Class<?> annotationClass = a.getClass();
                    if (!annotationClass.isAnnotationPresent(Validate.class)) continue;
                    testsArray = annotationClass.getAnnotation(Validate.class).value();
                }
            }
            if (testsArray == null) continue;

            /**
             * Тестируем...
             */
            for (Class<?> c : testsArray) {
                Method[] methods = c.getDeclaredMethods();
                for (Method m : methods) {
                    try {
                        m.invoke(null, obj); // предполагается, что все методы должны быть статическими
                    } catch (Exception e) {
                        throw new RuntimeException(e.getCause());
                    }
                }
            }
        }
    }
}
