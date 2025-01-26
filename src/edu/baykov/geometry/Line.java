package edu.baykov.geometry;

import lombok.NonNull;

/**
 * <p>Класс <b>Line</b> представляет реализацию линии
 * на двумерной системе координат типа {x : y},
 * которая описывается следующим образом:
 * <p>•Точка начала линии с координатами {x : y}: Point</p>
 * <p>•Конечная точка линии с координатами {x : y}: Point</p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    04-01-2025
 * @see Point
 */

public class Line implements Measurable {
    /**
     * Точка начала линии
     */
    private Point startPoint;
    /**
     * Конечная точка
     */
    private Point endPoint;

    /**
     * Конструирует объект класса Line из начальной и конечной точки, переданных в качестве аргумента.
     * @param startPoint начальная точка.
     * @param endPoint конечная точка.
     */
    public Line(@NonNull Point startPoint, @NonNull Point endPoint) {
        this(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());
    }

    /**
     * Конструирует объект класса Line из координат X и Y начальной и конечной точки, переданных в качестве аргумента.
     * @param x1 координата X начальной точки.
     * @param y1 координата Y начальной точки.
     * @param x2 координата X конечной точки.
     * @param y2 координата Y конечной точки.
     */
    public Line(int x1, int y1, int x2, int y2) {
        startPoint = new Point(x1, y1);
        endPoint = new Point(x2, y2);
    }

    /**
     * Возвращает стартовую точку в качестве нового объекта Point
     * @return startPoint.
     */
    public Point getStartPoint() {
        return new Point(startPoint);
    }

    /**
     * Заменяет startPoint новой точкой.
     * @param startPoint новая точка типа Point.
     */
    public void setStartPoint(@NonNull Point startPoint) {
        this.startPoint = new Point(startPoint);
    }

    /**
     * Возвращает конечную точку в качестве нового объекта Point
     * @return endPoint.
     */
    public Point getEndPoint() {
        return new Point(endPoint);
    }

    /**
     * Заменяет endPoint новой точкой.
     * @param endPoint новая точка типа Point.
     */
    public void setEndPoint(@NonNull Point endPoint) {
        this.endPoint = new Point(endPoint);
    }

    /**
     * Метод, возвращающий строковое представление объекта
     * @return строковое представление объекта Line в виде "Line from 'startPoint' to 'endPoint'"
     */
    @Override
    public String toString() {
        return "Line from " + startPoint + " to " + endPoint;
    }

    /**
     * Метод, вычисляющий длину линии, исходя из координат начальной и конечных точек, по формуле c*c = a*a + b*b
     * @return длина линии в виде целого числа без дробной части.
     */
    public int length() {
        return (int) Math.sqrt(Math.pow(endPoint.getX() - startPoint.getX(), 2) + Math.pow(endPoint.getY() - startPoint.getY(), 2));
    }
}


