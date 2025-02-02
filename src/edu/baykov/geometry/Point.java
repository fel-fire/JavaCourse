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
public sealed class Point implements Cloneable permits Point3D  {

    private int x, y;

    Point(@NonNull Point point) {
        x = point.x;
        y = point.y;
    }

    @Override
    public String toString() {
        return "{" + x + "; " + y + "}";
    }

    @Override
    public Point clone() throws CloneNotSupportedException {
        return (Point) super.clone();
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
}
