package oop;

import lombok.Getter;

@Getter
public class Triangle extends Figure{
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC) {
        if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideC + sideB <= sideA)
            throw new IllegalArgumentException("Invalid side length");
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getArea() {
        double halfP = (double) (sideA + sideB + sideC) /2;
        return Math.sqrt(halfP*(halfP - sideA)*(halfP - sideB)*(halfP - sideC));
    }
}
