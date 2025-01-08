package oop;

import java.util.ArrayList;

/**
 * <p>Класс <b>Polyline</b> представляет реализацию ломаной линии
 * на двумерной системе координат типа {x : y},
 * которая описывается следующим образом:
 * <p>•Множество точек с координатами {x : y}: Point</p>
 * <p>К ломаной линии можно добавить точку, получить общее количество точек и длину ломаной линии.</p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    04-01-2025
 * @see Point
 * @see Line
 */

public class Polyline {
    /**
     * Список точек, из которых состоит ломаная линия
     */
    private ArrayList<Point> points = new ArrayList<>();

    /**
     * Конструирует ломаную линию из множества точек, переданных в качестве аргумента.
     * @param points множество точек с координатами {x : y}: Point
     */
    public Polyline(Point... points) {
        if (points == null || points.length < 2)
            throw new IllegalArgumentException("A points should not be less than 2 or NULL.");
        this.addPoint(points);
    }

    /**
     * Метод добавляющий одну или несколько точек к ломаной линии.
     * @param points множество точек с координатами {x : y}: Point.
     */
    public void addPoint(Point... points) {
        for (Point point : points) {
            this.points.add(new Point(point.getX(), point.getY()));
        }
    }

    /**
     * Метод, вычисляющий длину ломаной линии путем сложения длин ее звеньев,
     * преобразованных в объекты класса Line.
     * @return длина ломаной линии в виде целого числа без дробной части.
     */
    public int length() {
        int result = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Line line = new Line(points.get(i), points.get(i+1));
            result += line.length();
        }
        return result;
    }

    /**
     * Метод, возвращающий общее количество точек в ломаной линии.
     * @return количество точек.
     */
    public int pointQuantity() {
        return points.size();
    }

    /**
     * Метод, изменяющий значение координат X и Y у точки с индексом index.
     * @param x новое значение X
     * @param y новое значение Y
     * @param index индекс точки, координаты которой необходимо изменить.
     * @throws IndexOutOfBoundsException если переданный индекс больше общего количества точек.
     */
    public void setPointValue(int x, int y, int index) {
        if (index > pointQuantity())
            throw new IndexOutOfBoundsException("The index is more than point quantity");

        points.get(index-1).setX(x);
        points.get(index-1).setY(y);
    }

    /**
     * Метод, возвращающий строковое представление объекта.
     * @return стандартное строковое представление объекта Polyline.
     */
    @Override
    public String toString() {
        return "Polyline{" +
                "points=" + points +
                '}';
    }
}
