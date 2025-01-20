package oop;

public class Rectangle extends Quadrangle {

    public Rectangle(int height, int width) {
        super(height, width, height, width);

    }

    @Override
    public double getArea() {
        return getSideA()*getSideB();
    }
}
