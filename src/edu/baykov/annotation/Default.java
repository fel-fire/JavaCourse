package edu.baykov.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

/**
 8.2.2. Разработайте аннотацию @Default, со следующими характеристиками:
 •	Целью может быть ТИП или ПОЛЕ
 •	Доступна во время исполнения программы
 •	Имеет обязательное свойство value типа Class


 * @author   Nikolay Baykov
 */

@Target({TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    Class<?> value();
}
