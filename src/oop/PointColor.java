package oop;

/**
 * <p>Класс {@code PointColor} представляет характеристику точки - цвет (строка)
 * ></p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */

public class PointColor implements PointCharacteristic {
    private String color;

    public PointColor(String color) {
        this.color = color;
    }
    /**
     * Метод, возвращающий строковое представление объекта
     * @return строковое описание {@code PointColor} с координатами
     */
    @Override
    public String getDescription() {
        return "color = " + color;
    }
}
