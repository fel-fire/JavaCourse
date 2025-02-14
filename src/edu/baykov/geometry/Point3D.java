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
public final class Point3D extends AbstractPoint {
    private int x, y, z;

    /**
     * Конструирует объект класса {@code Point3D}
     * @param x координата.
     * @param y координата.
     * @param z координата.
     */
    public Point3D(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Point3D{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
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
        return Objects.hash(x, y, z);
    }

    @Override
    public int distanceTo(AbstractPoint end) {
            double res;
            if (end instanceof Point3D point)
                res = Math.sqrt(Math.pow(point.getX() - getX(), 2) + Math.pow(point.getY() - getY(), 2) + Math.pow(point.getZ() - getZ(), 2));
            else throw new IllegalArgumentException("This point is not instance of Point3D.class");
            return (int) res;
    }

}
