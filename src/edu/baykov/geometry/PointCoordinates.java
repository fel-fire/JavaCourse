package edu.baykov.geometry;
/**
 * <p>Абстрактный класс {@code PointCoordinates} c абстрактным методом {@code getCoordinates()}, который в наследниках
 * класса был реализован в учебных целях. В тестах не используется.
 * Вся цепочка наследования в данном примере является замкнутой.
 * ></p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
public abstract sealed class PointCoordinates permits CoordinateTypeX {
    /**
     * Метод, возвращающий координаты в виде массива.
     * @return массив координат
     */
    public abstract int[] getCoordinates();
}

sealed class CoordinateTypeX  extends PointCoordinates permits CoordinateTypeXY{
    /**
     * Координата X
     */
    final int x;

    CoordinateTypeX(int x) {
        this.x = x;
    }
    /**
     * Метод, возвращающий координаты в виде массива.
     * @return массив координат x
     */
    @Override
    public int[] getCoordinates() {
        return new int[] {x};
    }
    /**
     * Метод, возвращающий строковое представление объекта
     * @return строковое описание {@code Poin1d} с координатами
     */
    @Override
    public String toString() {
        return "Point1d{" +
                "x=" + x +
                '}';
    }
}

sealed class CoordinateTypeXY extends CoordinateTypeX permits CoordinateTypeXYZ{
    /**
     * Координата Y
     */
    final int y;

    CoordinateTypeXY(int x, int y) {
        super(x);
        this.y = y;
    }
    /**
     * Метод, возвращающий координаты в виде массива.
     * @return массив координат x, y
     */
    @Override
    public int[] getCoordinates() {
        return new int[] {x, y};
    }
    /**
     * Метод, возвращающий строковое представление объекта
     * @return строковое описание {@code Poin2d} с координатами
     */
    @Override
    public String toString() {
        return "Point2d{" + "x=" + x + ", y=" + y + '}';
    }
}

final class CoordinateTypeXYZ extends CoordinateTypeXY {
    /**
     * Координата Z
     */
    final int z;

    CoordinateTypeXYZ(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }
    /**
     * Метод, возвращающий координаты в виде массива.
     * @return массив координат x, y, z
     */
    @Override
    public int[] getCoordinates() {
        return new int[] {x, y, z};
    }
    /**
     * Метод, возвращающий строковое представление объекта
     * @return строковое описание {@code Poin3d} с координатами
     */
    @Override
    public String toString() {
        return "Point3d{" + "x=" + x + ", y=" + y +  ", z=" + z +'}';
    }
}
