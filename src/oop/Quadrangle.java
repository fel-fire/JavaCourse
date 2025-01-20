package oop;

import lombok.Getter;

@Getter
public abstract class Quadrangle extends Figure{
    private int sideA;
    private int sideB;
    private int sideC;
    private int sideD;

    public Quadrangle(int sideA, int sideB, int sideC, int sideD) {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0 || sideD <= 0)
            throw new IllegalArgumentException("Invalid side length");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.sideD = sideD;
    }
}
