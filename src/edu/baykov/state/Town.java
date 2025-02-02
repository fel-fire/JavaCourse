package edu.baykov.state;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * Класс {@code Town} представляет реализацию города,
 * который описывается следующим образом:
 * <p>•Название города: строка</p>
 * <p>•Множество путей, ведущих из этого города в другие города: {@code Way}</p>
 *
 * @author Nikolay Baykov
 * @see Way
 * @see TownWithBackWay
 */
public class Town {
    @Getter
    final String name;
    ArrayList<Way> ways;

    public Town(@NonNull String name, @NonNull Way... wayArgs) {
        this.name = name;
        this.ways = new ArrayList<>();
        addWayWithCheck(wayArgs);
    }

    /**
     * Метод, гарантирующий, что в список путей не добавятся города с одинаковыми именами.
     * При наличии такого города в списке, обновится его значение стоимости
     */
    private void addWayWithCheck(Way... wayArgs) {
        for (Way way : wayArgs) {
            if (!ways.contains(way)) ways.add(way);
            else {
                int index = ways.indexOf(way);
                ways.set(index, way);
            }
        }
    }

    public void addWay(@NonNull Way... wayArgs) {
        addWayWithCheck(wayArgs);
    }

    public void removeWay(@NonNull Town townTo) {
        for (Way way : ways) {
            if (way.townTo.equals(townTo)) ways.remove(way);
        }
    }

    public ArrayList<Way> getWays() {
        return new ArrayList<>(ways);
    }

    @Override
    public String toString() {
        return name + " " + ways;
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Town town)) return false;
        if (ways.size() != town.ways.size()) return false;
        for (Way way : town.ways) {
            if (!ways.contains(way)) return false;
        }
        return true;
    }

        @Override
        public int hashCode () {
        int result = 0;
        for (Way way : ways) {
            result += way.hashCode();
        }
            return result;
        }
    }


