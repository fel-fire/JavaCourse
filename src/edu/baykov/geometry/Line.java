package edu.baykov.geometry;

import lombok.NonNull;

import java.util.Objects;

/**
 * <p>Класс {@code Line} представляет реализацию линии
 * на двумерной системе координат типа {x : y},
 * которая описывается следующим образом:
 * <p>•Точка начала линии с координатами {x : y}: {@code Point}</p>
 * <p>•Конечная точка линии с координатами {x : y}: {@code Point}</p></p>
 * @author   Nikolay Baykov
 * @see Point
 */
public class Line implements Measurable, Cloneable {

    private Point startPoint;
    private Point endPoint;

    public Line(@NonNull Point startPoint, @NonNull Point endPoint) {
        this(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
    }

    public Line(int startX, int startY, int endX, int endY) {
        startPoint = new Point(startX, startY);
        endPoint = new Point(endX, endY);
    }

    public Point getStartPoint() {
        return new Point(startPoint);
    }

    public void setStartPoint(@NonNull Point startPoint) {
        this.startPoint = new Point(startPoint);
    }

    public Point getEndPoint() {
        return new Point(endPoint);
    }

    public void setEndPoint(@NonNull Point endPoint) {
        this.endPoint = new Point(endPoint);
    }

    public int length() {
        return (int) Math.sqrt(Math.pow(endPoint.getX() - startPoint.getX(), 2) + Math.pow(endPoint.getY() - startPoint.getY(), 2));
    }

    public Line clone() throws CloneNotSupportedException {
        Line line = (Line) super.clone();
        line.startPoint = this.startPoint.clone();
        line.endPoint = this.endPoint.clone();
        return line;
    }

    @Override
    public String toString() {
        return "Line from " + startPoint + " to " + endPoint;
    }

    /**
     * Метод, сравнивающий 2 прямые линии вне зависимости от того, какая из точек линии
     * указана в качестве начальной {@code startPoint}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return (Objects.equals(startPoint, line.startPoint) && Objects.equals(endPoint, line.endPoint)) ||
               (Objects.equals(startPoint, line.endPoint) && Objects.equals(endPoint, line.startPoint));
    }
    @Override
    public int hashCode() {
        return startPoint.hashCode() + endPoint.hashCode();
    }
}





