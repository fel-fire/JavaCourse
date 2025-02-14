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
public class Line<T extends AbstractPoint> implements Measurable, Cloneable {

    private T start;
    private T end;


    private Line(T startPoint, T endPoint) {
        this.start = (T) startPoint.clone();
        this.end = (T) endPoint.clone();
    }
    public static <V extends AbstractPoint> Line<V> of(@NonNull V startPoint, @NonNull V endPoint) {
        return new Line<>(startPoint, endPoint);
    }

    public static Line<Point> of(int startX, int startY, int endX, int endY) {
        return new Line<>(new Point(startX, startY), new Point(endX, endY));
    }

    public T getStart() {
        return start;
    }

    public void setStart(@NonNull T start) {
        this.start = start;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(@NonNull T end) {
        this.end = end;
    }

    public int length() {
        return start.distanceTo(end);

    }

    public Line<T> clone() {
        try {
            Line<T> line = (Line<T>) super.clone();
            line.start = (T) this.start.clone();
            line.end = (T) this.end.clone();
            return line;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public String toString() {
        return "Line from " + start + " to " + end;
    }
    /**
     * Метод, сравнивающий 2 прямые линии вне зависимости от того, какая из точек линии
     * указана в качестве начальной {@code startPoint}
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line<T> line = (Line<T>) o;
        return (Objects.equals(start, line.start) && Objects.equals(end, line.end)) ||
               (Objects.equals(start, line.end) && Objects.equals(end, line.start));
    }
    @Override
    public int hashCode() {
        return start.hashCode() + end.hashCode();
    }
}





