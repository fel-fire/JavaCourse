package edu.baykov.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;


/**
 8.2.3. Аннотация @ToString, со следующими характеристиками:
 •	Целью может быть ТИП или ПОЛЕ
 •	Доступна во время исполнения программы
 •	Имеет необязательное свойство value c двумя вариантами значений: YES или NO
 •	Значение свойства по умолчанию: YES
 * @author   Nikolay Baykov
 */
@Target({TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ToString {
    YesOrNo value() default YesOrNo.YES;
}
