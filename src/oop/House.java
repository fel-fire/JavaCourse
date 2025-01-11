package oop;

import lombok.Getter;

/**
 * <p>Класс <b>House</b> представляет реализацию здания, имеющего один или несколько этажей floors. </p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    03-01-2025
 */
@Getter
public class House {
    /**
     * Количество этажей.
     */
    final int floors;

    /**
     * Конструирует объект класса House, принимая в качестве параметра количество этажей.
     * @param floors количество этажей (целое число).
     * @throws IllegalArgumentException если количество этажей отрицательное или 0.
     */
    public House(int floors) {
        if (floors < 1) throw new IllegalArgumentException("Floors must be 1 or more");
        this.floors = floors;
    }

    /**
     * Метод, возвращающий строковое представление объекта.
     * @return строковое представление в виде "Дом с 'floors' этажом(этажами)".
     */
    @Override
    public String toString() {
        String outputPhrase = String.format("Дом с %d этаж", floors);
        return floors%10 == 1 ? outputPhrase + "ом" : outputPhrase + "ами";
    }

}
