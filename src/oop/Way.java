package oop;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

/**
 * <p>Класс <b>Way</b> представляет реализацию пути
 * который описывается следующим образом:
 * <p>•Точка назначения: Town </p>
 * <p>•Стоимость поездки в точку назначения: целое число</p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    04-01-2025
 * @see Town
 */
@AllArgsConstructor
public class Way {
    /**
     * Точка назначения.
     */
    @Getter
    private Town townTo;
    /**
     * Стоимость поездки в точку назначения
     */
    private int costs;

    /**
     * Метод, возвращающий строковое представление объекта.
     * @return строковое представление объекта Way в виде: "Точка 'назначения':'стоимость'"/
     */
    @Override
    public String toString() {
        return townTo.getName() + ":" + costs;
    }

    /**
     * Метод, сравнивающий текущий объект с объектом o по соответствию точки назначения.
     * @param o
     * @return точки назначения одинаковые - true, разные - false.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Way way = (Way) o;
        return Objects.equals(townTo, way.townTo);
    }
}
