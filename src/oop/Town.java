package oop;


import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <p>Класс <b>Town</b> представляет реализацию города,
 * который описывается следующим образом:
 * <p>•Название города: строка</p>
 * <p>•Множество путей, ведущих из этого города в другие города: Way</p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    04-01-2025
 * @see Way
 */
public class Town {
    /**
     * Название города.
     */
    @Getter
    private final String name;
    /**
     * Набор путей в другие города.
     */
    private ArrayList<Way> ways;

    /**
     * Конструирует город из названия и набора путей.
     * @param name название города.
     * @param ways набор путей в другие города.
     */
    public Town(@NonNull String name, @NonNull Way... ways) {
        this.name = name;
        this.ways = new ArrayList<>(Arrays.asList(ways));
    }

    /**
     * Метод, добавляющий в набор путей путь way. В случае если такой путь существует в наборе,
     * то он заменяется на way.
     * @param way путь к городу.
     */
    public void addWay(@NonNull Way way) {
        if (!ways.contains(way)) ways.add(way);
        else {
            int index = ways.indexOf(way);
            ways.set(index, way);
        }
    }

    /**
     * Метод, удаляющий из набора путей путь с направлением townTo.
     * @param townTo направление удаляемого пути.
     */
    public void removeWay(@NonNull Town townTo) {
        for (Way way : ways) {
            if (way.getTownTo().equals(townTo)) ways.remove(way);
        }

    }
    /**
     *Метод, возвращающий строковое представление объекта.
     * @return строковое представление объекта Town в виде: "Название города [список путей]".
     */
    @Override
    public String toString() {
        return name + " " + ways;
    }
    /**
     * Метод сопоставляющий текущий объект с объектом Town по названию города.
     * @param o объект Town для сравнения
     * @return true, если названия городов одинаковые, false, если разные.
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return name.equals(town.name);
    }
}


