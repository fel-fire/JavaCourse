package edu.baykov.spring;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.core.annotation.AliasFor;

import java.util.Date;
import java.util.function.Predicate;

@Configuration
public class Config {

    @Bean
    public String hello() {
        return "Hello World!";
    }

    @Bean
    @Scope("prototype")
    public int randomInt() {
        return (int) (Math.random()*100);
    }

    @Bean
    @Lazy
    public Date date() {
        return new Date();
    }

    @Bean(name ="2to5" )
    public Predicate<Integer> fromTwoToFive() {
        return (x) -> x >= 2 &&  x <= 5;
    }

    @Bean(name = {"max", "maximum"})
    public int max() {
        return Integer.MAX_VALUE;
    }

    @Bean(name = {"min", "minimum"})
    public int min() {
        return Integer.MIN_VALUE;
    }
}
