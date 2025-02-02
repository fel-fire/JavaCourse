package edu.baykov.geometry;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

/**
 * <p>Класс {@code Point3D} представляет реализацию точки
 * в трехмерной системе координат типа {x : y : z},
 * которая описывается следующим образом:
 * <p>•координата {@code x}: int</p>
 * <p>•координата {@code y}: int</p>
 * <p>•координата {@code z}: int</p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */

@Getter
@Setter
public final class Point3D extends Point {
    private int z;

    /**
     * Конструирует объект класса {@code Point3D}
     * @param x координата.
     * @param y координата.
     * @param z координата.
     */
    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    /**
     * Данный метод возвращает строковое представление объекта
     * @return строковое представление объекта {@code Point3D} вида {x; y; z}
     */
    @Override
    public String toString() {
        return "{" + super.getX() + "; " + super.getX() + "; " + z + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Point3D point3D = (Point3D) o;
        return z == point3D.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }
}
