package edu.baykov.geometry;

import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>Класс {@code CompositePoint} представляет реализацию точки
 * в одно-, двух- или трехмерной системе координат {@code PointCoordinates}
 * с набором характеристик {@code PointCharacteristic}
 * ></p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */

public class CompositePoint {
    /**
     * Координаты точки в в одно-, двух- или трехмерной системе координат
     */
    private PointCoordinates coordinates;
    /**
     * Список с характеристиками точки
     */
    private ArrayList<PointCharacteristic> characteristic;

    /**
     * Конструирует {@code CompositePoint}
     * @param coordinates координаты {x}, {x : y} или {x : y : z}.
     * @param characteristic набор характеристик.
     */
    public CompositePoint(@NonNull PointCoordinates coordinates, @NonNull PointCharacteristic... characteristic) {
        this.coordinates = coordinates;
        this.characteristic = new ArrayList<>(Arrays.asList(characteristic));
    }

    /**
     * Метод, возвращающий строковое представление объекта
     * @return строковое описание {@code CompositePoint} с координатами и набором характеристик
     */
    @Override
    public String toString() {
        String text = "";
        for (PointCharacteristic c : characteristic) {
            text += c.getDescription() + ", ";
        }
        text = text.substring(0, text.length() -2);
        return "CompositePoint{" +
                "coordinates = " + coordinates +
                ", " + text + '}';
    }
}





