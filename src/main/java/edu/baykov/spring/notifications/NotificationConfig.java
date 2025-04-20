package edu.baykov.spring.notifications;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;
import java.util.function.Predicate;

@Configuration
@ComponentScan(basePackages = "edu.baykov.spring.notifications")
public class NotificationConfig {

    @Bean
    @Value("70")
    public Predicate<Stock> lessThan(int min) {
        return s -> s.getPrice() < min;
    }

    @Bean
    @Value("850")
    public  Predicate<Stock> moreThan(int max) {
        return s -> s.getPrice() > max;
    }

    @Bean
    public Consumer<Stock> needToBuy(@Qualifier("lessThan") Predicate<Stock> predicate) {
        return  (s) -> {if (predicate.test(s)) System.out.println("Срочно покупаем " + s.getName());};
    }
    @Bean
    public Consumer<Stock> needToSell(@Qualifier("moreThan") Predicate<Stock> predicate) {
        return  (s) -> {if (predicate.test(s)) System.out.println("Срочно продаем " + s.getName());};
    }
}
