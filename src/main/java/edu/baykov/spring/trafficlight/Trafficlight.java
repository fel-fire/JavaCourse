package edu.baykov.spring.trafficlight;

import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * 9.2.7 Настройка светофора. Необходимо разработать и настроить группу бинов, позволяющих реализовать
 * функционал Светофора из задачи 7.3.9. На основе этих бинов реализуйте трехцветный светофор
 * (красный, желтый, зеленый цвета)
 */

@Service
@Scope("prototype")
public class Trafficlight {
    @Getter
    State currentState;
    TrafficlightMode mode;

    public Trafficlight(TrafficlightMode mode) {
        this.mode = mode;
        this.currentState = mode.setOFF_STATE();
    }

    public void next() {
        currentState = mode.changeState();
        currentState.info();
    }

    public void off() {
        currentState = mode.setOFF_STATE();
        currentState.info();
    }

    public void on() {
        next();
    }



}
