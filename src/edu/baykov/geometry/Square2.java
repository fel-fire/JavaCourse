package edu.baykov.geometry;
/**
 * <p>Класс {@code Square2} представляет реализацию Квадрата
 * который описывается четырьмя сторонами.
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    25-01-2025
 * @see Quadrangle
 * @see Rectangle
 * @see Figure
 */
public class Square2 extends Rectangle{
    /**
     * Конструктор, принимающий сторону.
     * @param side сторона квадрата
     */
    public Square2(int side) {
        super(side, side);
    }
}
