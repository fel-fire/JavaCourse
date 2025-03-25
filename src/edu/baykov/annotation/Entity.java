package edu.baykov.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static edu.baykov.annotation.YesOrNo.*;

/**
 8.3.3. Абстрактный класс {@code @Entity}, со следующими характеристиками:
 •	имеет метод {@code toString}, который обрабатывает аннотации {@code @toString}
 Метод приведения к строке реализован таким образом, что бы в строковую форму попадали только те поля,
 которые не помечены аннотацией @ToString со значением NO. Поле помеченное как @ToString(YES) или же
 не помеченное не попадает в строковое представление. В случае если с помощью  @ToString(NO) проаннотирован
 весь класс, то ни одно из его полей не попадает в строковое представление, кроме тех,
 которые явно помечены как @ToString(YES)
 * @author   Nikolay Baykov
 */

public abstract class Entity {

    @Override
    public String toString() {
        Class<?> clazz = this.getClass();
        String result = clazz.getSimpleName() + "{";
        ArrayList<String> fieldsAndValues = new ArrayList<>();
        while (clazz != null) {

            ToString clazzAnnotation = clazz.getAnnotation(ToString.class);
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                try {
                    ToString fieldAnnotation = field.getAnnotation(ToString.class);
                    if (clazzAnnotation != null && clazzAnnotation.value() == NO && fieldAnnotation != null && fieldAnnotation.value() == YES ||
                            (clazzAnnotation == null || clazzAnnotation.value() == YES) && (fieldAnnotation == null || fieldAnnotation.value() != NO)) {
                        fieldsAndValues.add(field.getName() + "=" + field.get(this));
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return result + String.join(", ", fieldsAndValues) + "}";
    }
}
