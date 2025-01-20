package oop;

public class Round extends Figure{
    int radius;

    public Round(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2)*Math.PI;
    }
}
