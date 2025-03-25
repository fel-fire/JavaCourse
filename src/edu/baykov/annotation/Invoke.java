package edu.baykov.annotation;

import java.lang.annotation.*;

/**
 8.2.1. Аннотация @Invoke, со следующими характеристиками:
 •	Целью может быть только МЕТОД
 •	Доступна во время исполнения программы
 •	Не имеет свойств
 * @author   Nikolay Baykov
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Invoke {
}
