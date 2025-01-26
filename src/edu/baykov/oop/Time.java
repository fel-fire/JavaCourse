package edu.baykov.oop;

/**
 * Класс Time описывает текущее время суток в 24-х часовом формате.
 * Время описывается числом часов, минут и секунд, прошедшим с начала суток.
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    03-01-2025
 */
public class Time {
    /**
     * Общее количество часов без учета минут и секунд.
     */
    int hours;
    /**
     * Остаток минут без учета секунд.
     */
    int minutes;
    /**
     * Остаток секунд.
     */
    int seconds;

    /**
     * <p>Конструирует объект Time. Принимает значение в секундах, которое переводится в общее количество часов,
     * остаток минут и остаток секунд</p>
     * <p></p>
     * @param seconds количество секунд прошедшее с начала суток.
     * @throws IllegalArgumentException если seconds меньше 0.
     */
    public Time(long seconds) {
        if (seconds < 0) throw new IllegalArgumentException();
        this.seconds = (int)seconds%60;
        this.minutes = (int)seconds/60%60;
        this.hours = (int)seconds/3600;
    }

    /**
     * Метод приводит объект Time к текстовой форме следующего формата: “ЧЧ:ММ:СС”.
     * @return строковое представление “ЧЧ:ММ:СС” с начала последних суток
     */
    @Override
    public String toString() {
        return String.format("%d:%d:%d", hours%24, minutes, seconds);
    }

}
