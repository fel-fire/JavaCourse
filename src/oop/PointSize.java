package oop;

/**
 * <p>Класс {@code PointSize} представляет характеристику точки - размер (целое число)
 * ></p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
public class PointSize implements PointCharacteristic {
    private int size;

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
