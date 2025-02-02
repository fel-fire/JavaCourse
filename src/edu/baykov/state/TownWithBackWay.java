package edu.baykov.state;

import lombok.NonNull;

import java.util.List;

/**
 * <p>Класс {@code TownWithBackWay} представляет реализацию города,
 * который описывается следующим образом:
 * <p>•Название города: строка</p>
 * <p>•Множество путей, ведущих из этого города в другие города: Way</p></p>
 * <p>Класс расширяет класс {@code Town}, добавляя следующую функциональность: при добавлении дороги из одного
 * города в другой, одновременно добавляется и обратная дорога </p>
 * @author Nikolay Baykov
 * @see Way
 * @see Town
 */
public class TownWithBackWay extends Town {
    public TownWithBackWay(String name, Way... ways) {
        super(name, ways);
        for (Way way : ways) {
            addBackWay(way);
        }
    }

    private void addBackWay(Way way) {
        Town townTo = way.getTownTo();
        List<Way> tmp = townTo.getWays();
        Way backWay = new Way(this, way.getCosts());
        int index = tmp.indexOf(backWay);
        if (index >= 0 && tmp.get(index).getCosts() == backWay.getCosts()) return;
        townTo.addWay(backWay);
    }

    @Override
    public void addWay(@NonNull Way... wayArgs) {
        for (Way way : wayArgs) {
            super.addWay(way);
            addBackWay(way);
        }

    }
}
