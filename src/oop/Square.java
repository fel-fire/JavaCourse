package oop;

import lombok.Getter;
import lombok.NonNull;

/**
 * <p>Класс <b>Square</b> представляет реализацию квадрата
 * на двумерной системе координат типа {x : y},
 * который описывается следующим образом:
 * <p>•Точка начала - левый верхний угол квадрата с координатами {x : y}: Point</p>
 * <p>•Длина стороны: целое число</p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    04-01-2025
 * @see Point
 */
@Getter
public class Square {
    /**
     * Точка начала - левый верхний угол квадрата
     */
    private Point startPoint;
    /**
     * Длина стороны
     */

    private int sideLength;

    /**
     * Конструирует квадрат из начальной точки и длины стороны
     * @param startPoint точка начала Point с координатами X:Y
     * @param sideLength длина стороны
     */
    public Square(@NonNull Point startPoint, int sideLength) {
        this.startPoint = startPoint;
        setValidSideLength(sideLength);
    }
    /**
     * Конструирует квадрат из координат X и Y начальной точки и длины стороны.
     * @param x координата X начальной точки.
     * @param y координата Y начальной точки.
     * @param sideLength длина стороны.
     */
    public Square(int x, int y, int sideLength) {
        this(new Point(x, y), sideLength);
    }

    /**
     * Метод, изменяющий длину стороны квадрата на новую.
     * @param sideLength новая сторона квадрата
     */
    public void setSideLength(int sideLength) {
       setValidSideLength(sideLength);
    }

    /**
     * Служебный метод, устанавливающий допустимую длину стороны квадрата.
     * @param sideLength длина стороны квадрата.
     * @throws IllegalArgumentException если сторона квадрата 0 или меньше.
     */
    private void setValidSideLength(int sideLength) {
        if (sideLength <= 0)
            throw new IllegalArgumentException("SideLength must be bigger than 0");
        this.sideLength = sideLength;
    }

    /**
     * Метод, представляющий квадрат как объект ломаной линии Polyline. При этом точки ломаной линии задаются
     * как новые объекты Point и не связаны с точками квадрата.
     * @return новый объект Polyline.
     */
    public Polyline asPolyline() {
        return new Polyline(new Point(startPoint.getX(), startPoint.getY()),
                            new Point(startPoint.getX() + sideLength, startPoint.getY()),
                            new Point(startPoint.getX() + sideLength, startPoint.getY() - sideLength),
                            new Point(startPoint.getX(), startPoint.getY()-sideLength),
                            new Point(startPoint.getX(), startPoint.getY()));
    }

    /**
     * Метод, возвращающий строковое представление объекта
     * @return строковое представление объекта Square в виде: "Квадрат в точке 'startPoint' со стороной 'sideLength'"
     */
    @Override
    public String toString() {
        return "Квадрат в точке " + startPoint +
                " со стороной " + sideLength;
    }
}
