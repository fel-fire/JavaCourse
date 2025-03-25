package edu.baykov.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 8.2.5. Аннотация @Two, со следующими характеристиками:
 •	Целью может быть ТИП
 •	Доступна во время исполнения программы
 •	Имеет два обязательных свойства: first типа String и second типа int
 * @author   Nikolay Baykov
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Two {
    String first();
    int second();
}
