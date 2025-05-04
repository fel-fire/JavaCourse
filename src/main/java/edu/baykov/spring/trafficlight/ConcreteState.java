package edu.baykov.spring.trafficlight;

/**
 * /**
 *  * 9.2.7 Настройка светофора. Реализация интерфейса текущего состояния
 *  *  * светофора
 *  */


public class ConcreteState implements State {
    private EColor color;

    public ConcreteState(EColor color) {
        this.color = color;
    }

    @Override
    public void info() {
        System.out.println(color);
    }
}
