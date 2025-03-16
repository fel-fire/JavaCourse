package edu.baykov.geometry;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Objects;

/**
 * <p>Класс {@code Point} представляет реализацию точки
 * на двумерной системе координат типа {x : y},
 * которая описывается следующим образом:
 * <p>•координата Х: int</p>
 * <p>•координата Y: int</p></p>
 * @author   Nikolay Baykov
 */


@AllArgsConstructor
@Getter
@Setter
public  class Point extends AbstractPoint {

    private int x, y;

    public Point(@NonNull Point point) {
        x = point.x;
        y = point.y;
    }

    @Override
    public String toString() {
        return "{" + x + "; " + y + "}";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    int distanceTo(AbstractPoint end) {
        double res;
        if (end instanceof Point point)
            res = Math.sqrt(Math.pow(point.getX() - getX(), 2) + Math.pow(point.getY() - getY(), 2));
        else throw new IllegalArgumentException("This point is not instance of Point.class");
        return (int) res;
    }

}
