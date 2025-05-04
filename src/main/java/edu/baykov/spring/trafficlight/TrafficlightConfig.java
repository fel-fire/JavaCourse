package edu.baykov.spring.trafficlight;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.awt.*;

/**
 * Конфигурационный файл для светофора
 */

@Configuration
public class TrafficlightConfig {

    @Bean
    @Qualifier("RYG")
    @Order(1)
    public State red() {
        return new ConcreteState(EColor.RED_STATE);
    }

    @Bean
    @Qualifier("RYG")
    @Order(2)
    public State yellow() {
        return new ConcreteState(EColor.YELLOW_STATE);
    }

    @Bean
    @Qualifier("RYG")
    @Order(3)
    public State green() {
        return new ConcreteState(EColor.GREEN_STATE);
    }

    @Bean
    @Qualifier("RYG")
    @Order(4)
    public State yellowAgain() {
        return new ConcreteState(EColor.YELLOW_STATE);
    }

    @Bean
    public State off() {
        return new ConcreteState(EColor.OFF_STATE);
    }
}
