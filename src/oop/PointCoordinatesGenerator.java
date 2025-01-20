package oop;

import lombok.NonNull;
/**
 * <p> Генератор одно-, двух- или трехмерных точек с координатами.
 * Тип точки определяется по количеству значений, переданных в метод,
 * в качестве координат
 * ></p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */

public class PointCoordinatesGenerator {
    /**
     * Метод, генерирующий точку с переданными координатами. Если передано более 3-х координат,
     * будет сгенерирована точка из первых трех координат
     * @param coordinates координаты точки
     * @return точку с координатами, соответствующего типа.
     * @throws IllegalArgumentException если не переданы координаты.
     */
    public static PointCoordinates generate(@NonNull int... coordinates) {
        if (coordinates.length == 0) throw new IllegalArgumentException("You must set coordinates");
        switch (coordinates.length) {
            case 1:
                return new CoordinateTypeX(coordinates[0]);
            case 2:
                return new CoordinateTypeXY(coordinates[0], coordinates[1]);
            default:
                return new CoordinateTypeXYZ(coordinates[0], coordinates[1], coordinates[2]);
        }
    }
}
