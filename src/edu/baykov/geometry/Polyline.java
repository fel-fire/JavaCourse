package edu.baykov.geometry;

import lombok.NonNull;

import java.util.*;

/**
 * <p>Класс <b>Polyline</b> представляет реализацию ломаной линии
 * на двумерной системе координат типа {x : y},
 * которая описывается следующим образом:
 * <p>•Множество точек с координатами {x : y}: Point</p>
 * <p>К ломаной линии можно добавить точку, получить общее количество точек и длину ломаной линии,
 * изменить значение точки по индексу</p>
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    04-01-2025
 * @see Point
 * @see Line
 */

public class Polyline implements Measurable, TransformableToPolyline {

    ArrayList<Point> points;

    public Polyline(@NonNull Point... points) {
        if (points.length < 3) throw new IllegalArgumentException("A points should not be less than 3");
        this.points = new ArrayList<>(Arrays.asList(points));
    }

    public void addPoint(@NonNull Point... points) {
        for (Point point : points) {
            this.points.add(new Point(point));
        }
    }
    public int length() {
        int result = 0;
        for (int i = 0; i < points.size() - 1; i++) {
            Line line = new Line(points.get(i), points.get(i+1));
            result += line.length();
        }
        return result;
    }

    public int pointQuantity() {
        return points.size();
    }

    public void setPointValue(int x, int y, int index) {
        if (index > pointQuantity())
            throw new IndexOutOfBoundsException("The index is more than point quantity");
        points.get(index-1).setX(x);
        points.get(index-1).setY(y);
    }

    public ArrayList<Point> getPoints() {
        return new ArrayList<>(points);
    }

    @Override
    public Polyline getPolyline() {
        Point[] tmp = points.toArray(new Point[0]);
        return new Polyline(tmp);
    }

    @Override
    public String toString() {
        return "Polyline{" +
                "points=" + points +
                '}';
    }

    /**
     * В данном конкретном случае метод предусматривает сравнение ломаных линий, в том числе замкнутых,
     * независимо от того, относятся ли они к конкретному классу {@code ClosedPolyline}. При этом равными будут считаться
     * ломаные линии, которые состоят из одинаковых отрезков. Направление линии значения не имеет.
     * В случае с замкнутыми линиями также не имеет значения из какой точки они начинаются.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Polyline polyline)) return false;

        ArrayList<Point> pointsOfObj = polyline.getPoints();
        ArrayList<Point> pointsOfThis = getPoints();

        // Из-за того, что в ClosedPolyline не предусмотрено наличие конечной точки, совпадающей с начальной, необходимо
        // добавлять ее вручную в следующих двух строках. Вероятнее всего, эти строчки целесообразно оставить здесь
        // и не переопределить в подклассе данный метод.
        if (obj.getClass() == ClosedPolyline.class) pointsOfObj.add(pointsOfObj.getFirst());
        if (getClass() == ClosedPolyline.class) pointsOfThis.add(pointsOfThis.getFirst());

        ArrayList<Line> linesOfThis = asUniqueLinesList(pointsOfThis);
        ArrayList<Line> linesOfObj = asUniqueLinesList(pointsOfObj);

        if (linesOfThis.size() != linesOfObj.size()) return false;

        for (Line line : linesOfThis) {
            if (!linesOfObj.contains(line)) return false;
        }

        return true;
    }

    /**
     * Хэш-код линии является суммой хэш-кодов всех ее отрезков.
     */
    @Override
    public int hashCode() {
        int result = 0;
        ArrayList<Line> lines = asUniqueLinesList(points);
        for (Line line : lines) {
            result += line.hashCode();
        }
        return result;
    }

    /**
     * Метод, возвращающий список уникальных отрезков из которых состоит ломаная линия
     */
    private ArrayList<Line> asUniqueLinesList(ArrayList<Point> points) {
        ArrayList<Line> lines = new ArrayList<>();
        for (int i = 0; i < points.size() - 1; i++) {
            Point startPoint = points.get(i);
            Point endPoint = points.get(i+1);
            Line addedLine = new Line(startPoint, endPoint);
            if ((startPoint.equals(endPoint)) || lines.contains(addedLine)) continue;
            lines.add(addedLine);
        }
        return lines;
    }


}
