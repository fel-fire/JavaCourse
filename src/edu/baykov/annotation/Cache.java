package edu.baykov.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
  8.2.6. Аннотация @Cache, со следующими характеристиками:
 •	Целью может быть ТИП
 •	Доступна во время исполнения программы
 •	Имеет необязательное свойство value, типа String[]
 •	Значение свойства по умолчанию: пустой массив

 * @author   Nikolay Baykov
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Cache {
    String[] value() default {};
}
