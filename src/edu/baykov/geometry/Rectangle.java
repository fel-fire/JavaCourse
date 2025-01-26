package edu.baykov.geometry;
/**
 * <p>Класс {@code Rectangle} представляет реализацию прямоугольника
 * который описывается четырьмя сторонами.
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    25-01-2025
 * @see Quadrangle
 * @see Figure
 */
public class Rectangle extends Quadrangle {
    /**
     * Конструирует четырехугольник по длине и ширине
     * @param height длина
     * @param width ширина
     */
    public Rectangle(int height, int width) {
        super(height, width, height, width);

    }

    /**
     * Метод, вычисляющий площадь
     * @return
     */
    @Override
    public double getArea() {
        return getSideA()*getSideB();
    }
}
