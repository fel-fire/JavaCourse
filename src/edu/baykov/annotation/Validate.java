package edu.baykov.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 8.2.4. Аннотация @Validate, со следующими характеристиками:
 •	Целью может быть ТИП или АННОТАЦИЯ
 •	Доступна во время исполнения программы
 •	Имеет обязательное свойство value, типа Class[]
 * @author   Nikolay Baykov
 */

@Target({ANNOTATION_TYPE, TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Validate {
    Class[] value();
}
