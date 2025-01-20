package oop;

import lombok.NonNull;

import java.util.List;

/**
 * <p>Класс {@code ClosedPolyline} представляет реализацию замкнутой ломаной линии
 * на двумерной системе координат типа {x : y},
 * которая описывается следующим образом:
 * <p>•Множество точек с координатами {@code x} : {@code y}: {@code Point}</p>
 * <p>К ломаной линии можно добавить точку, получить общее количество точек и длину ломаной линии.</p>
 * <p>Класс наследуется от {@code Polyline} </p>
 *
 * @author Nikolay Baykov
 * @version 1.0
 * @see Point
 * @see Line
 * @see Polyline
 * @since 16-01-2025
 */
public class ClosedPolyline extends Polyline {
    /**
     * Конструирует ломаную линию из множества точек, переданных в качестве аргумента.
     * @param points множество точек с координатами {{@code x} : {@code y}}: {@code Point}
     */
    public ClosedPolyline(@NonNull Point... points) {
        super(points);
    }
    /**
     * Метод, высчитывающий длину замкнутой ломаной линии.
     * @return длину линии в виде суммы длин отдельных ее отрезков, округленных в меньшую сторону до целого числа.
     */
    @Override
    public int length() {
        int result = super.length();
        List<Point> tmp = super.getPoints();
        Line lastLine = new Line(tmp.getLast(), tmp.getFirst());
        return result + lastLine.length();
    }



}
