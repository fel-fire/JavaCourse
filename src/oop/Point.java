package oop;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

/**
 * <p>Класс <b>Point</b> представляет реализацию точки
 * на двумерной системе координат типа {x : y},
 * которая описывается следующим образом:
 * <p>•координата Х: int</p>
 * <p>•координата Y: int</p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    01-01-2025
 */


@AllArgsConstructor
@Getter
@Setter
public class Point {
    /**
     * Координата X и Y.
     */
    private int x, y;

    /**
     * Конструирует копию переданного объекта класса Point
     * @param point
     */
    Point(@NonNull Point point) {
        x = point.x;
        y = point.y;
    }

    /**
     * Данный метод возвращает строковое представление объекта
     * @return строковое представление объекта класса Point
     */
    @Override
    public String toString() {
        return "{" + x + "; " + y + "}";
    }
}
