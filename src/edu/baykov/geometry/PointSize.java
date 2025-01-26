package edu.baykov.geometry;

/**
 * <p>Класс {@code PointSize} представляет характеристику точки - размер (целое число)
 * </p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
public class PointSize implements PointCharacteristic {
    /**
     * Размер точки
     */
    private int size;

    /**
     * Конструктор объект с размером {@code size}
     * @param size размер
     */
    public PointSize(int size) {
        this.size = size;
    }
    /**
     * Метод, возвращающий строковое представление объекта
     * @return строковое описание {@code PointSize} с координатами
     */
    @Override
    public String getDescription() {
        return "size = " + size;
    }
}
