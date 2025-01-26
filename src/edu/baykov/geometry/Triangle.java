package edu.baykov.geometry;

import lombok.Getter;
/**
 * <p>Класс {@code Triangle} представляет реализацию Треугольника
 * который описывается тремя сторонами.
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    25-01-2025
 * @see Figure
 */
@Getter
public class Triangle extends Figure {
    /**
     * Сторона A
     */
    private int sideA;
    /**
     * Сторона B
     */
    private int sideB;
    /**
     * Сторона C
     */
    private int sideC;

    /**
     * Конструирует Треугольник по трем сторонам
     */
    public Triangle(int sideA, int sideB, int sideC) {
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideC + sideB <= sideA)
            throw new IllegalArgumentException("Invalid side length");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    /**
     * Метод, вычисляющий площадь треугольника
     * @return площадь треугольника.
     */
    @Override
    public double getArea() {
        double halfP = (double) (sideA + sideB + sideC) /2;
        return Math.sqrt(halfP*(halfP - sideA)*(halfP - sideB)*(halfP - sideC));
    }
}
