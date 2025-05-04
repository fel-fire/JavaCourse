package edu.baykov.spring.processor;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;

/**
 9.3.2. Aннотация @Default к задаче:
 * @author   Nikolay Baykov
 */

@Target({TYPE, FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Default {
    String beanName();
}
