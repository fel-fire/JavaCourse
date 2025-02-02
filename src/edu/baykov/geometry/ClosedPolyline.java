package edu.baykov.geometry;

import lombok.NonNull;

import java.util.List;

/**
 * <p>Класс {@code ClosedPolyline} представляет реализацию замкнутой ломаной линии
 * на двумерной системе координат типа {x : y},
 * которая описывается следующим образом:
 * <p>•Множество точек с координатами {@code x} : {@code y}: {@code Point} В случае если при конструировании или
 * добавлении точек последняя точка совпадает с первой, то она в общее множество точек не попадает.</p>
 * <p>К ломаной линии можно добавить точку, получить общее количество точек и длину ломаной линии.</p>
 * @author Nikolay Baykov
 * @see Point
 * @see Line
 * @see Polyline
 */
public class ClosedPolyline extends Polyline {
    public ClosedPolyline(@NonNull Point... points) {
        super(points);
        if (this.points.getFirst().equals(this.points.getLast())) this.points.removeLast();
    }


    @Override
    public void addPoint(@NonNull Point... points) {
        super.addPoint(points);
        if (this.points.getFirst().equals(this.points.getLast())) this.points.removeLast();
    }

    /**
     * Метод, высчитывающий длину замкнутой ломаной линии, путем добавления к длине ломаной линии по этим
     * же точкам длины линии от конечной точки к начальной
     */
    @Override
    public int length() {
        int result = super.length();
        List<Point> tmp = super.getPoints();
        if (tmp.size() <= 2) return result;
        Line lastLine = new Line(tmp.getLast(), tmp.getFirst());
        return result + lastLine.length();
    }

    @Override
    public int hashCode() {
        return super.hashCode() + new Line(points.getLast(), points.getFirst()).hashCode();
    }
}
