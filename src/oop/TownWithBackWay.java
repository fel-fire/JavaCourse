package oop;

import lombok.NonNull;

import java.util.List;

/**
 * <p>Класс {@code TownWithBackWay} представляет реализацию города,
 * который описывается следующим образом:
 * <p>•Название города: строка</p>
 * <p>•Множество путей, ведущих из этого города в другие города: Way</p></p>
 * <p>Класс расширяет класс {@code Town}, добавляя следующую функциональность: при добавлении дороги из одного
 * города в другой, одновременно добавляется и обратная дорога </p>
 *
 * @author Nikolay Baykov
 * @version 1.0
 * @see Way
 * @see Town
 * @since 16-01-2025
 */
public class TownWithBackWay extends Town {
    /**
     * Конструирует город из названия и набора путей.
     *
     * @param name название города.
     * @param ways набор путей в другие города.
     */
    public TownWithBackWay(String name, Way... ways) {
        super(name, ways);
        for (Way way : ways) {
            addBackWay(way);
        }
    }
    /**
     * Служебный метод, добавляющий путь {@code Way} из города назначения {@code Way.townTo} в {@code this}
     * в список города назначения
     *
     * @param way путь в город назначения
     */
    private void addBackWay(Way way) {

        Town townTo = way.getTownTo();
        List<Way> tmp = townTo.getWays();
        Way backWay = new Way(this, way.getCosts());
        int index = tmp.indexOf(backWay);
        if (index >= 0 && tmp.get(index).getCosts() == backWay.getCosts()) return;
        townTo.addWay(backWay);
    }

    /**
     * Метод, добавляющий в набор путей путь {@code Way}. В случае если такой путь существует в наборе,
     * то он заменяется на {@code Way}
     *
     * @param way путь к городу.
     */
    @Override
    public void addWay(@NonNull Way way) {
        super.addWay(way);
        addBackWay(way);
    }
}
