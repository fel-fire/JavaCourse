package edu.baykov.spring.trafficlight;


/**
 * 9.2.7 Настройка светофора. Интерфейс режима работы светофора
 */
public interface TrafficlightMode {
    State changeState();
    State setOffState();
}
