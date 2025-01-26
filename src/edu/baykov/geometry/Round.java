package edu.baykov.geometry;
/**
 * <p>Класс {@code Round} представляет реализацию круга
 * который описывается радиусом.
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    25-01-2025
 * @see Figure
 */
public class Round extends Figure{
    /**
     * Радиус
     */
    int radius;

    /**
     * Конструирует круг по радиусу
     * @param radius
     */
    public Round(int radius) {
        this.radius = radius;
    }

    /**
     * Метод, вычисляющий площадь круга
     * @return
     */
    @Override
    public double getArea() {
        return Math.pow(radius, 2)*Math.PI;
    }
}
