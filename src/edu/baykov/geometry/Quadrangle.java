package edu.baykov.geometry;

import lombok.Getter;
/**
 * <p>Абстрактный класс {@code Quadrangle} представляет реализацию четырехугольника
 * с полями, обозначающими значение длины каждой стороны
 * </p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
@Getter
public abstract class Quadrangle extends Figure {
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
     * Сторона D
     */
    private int sideD;

    /**
     * Конструирует объект четырехугольника по 4 сторонам
     */
    public Quadrangle(int sideA, int sideB, int sideC, int sideD) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 || sideD <= 0)
            throw new IllegalArgumentException("Invalid side length");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
    }
}
