package edu.baykov.state;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

/**
 * <p>Класс {@code Way} представляет реализацию пути
 * который описывается следующим образом:
 * <p>•Точка назначения: {@code Town} </p>
 * <p>•Стоимость поездки в точку назначения: {@code int}</p>
 * @author   Nikolay Baykov
 * @see Town
 */
@AllArgsConstructor
@Getter
public class Way {
    @NonNull
    Town townTo;
    int costs;

    @Override
    public String toString() {
        return townTo.name + ":" + costs;
    }

    public void setCosts(int costs) {
        if (costs < 0) throw new IllegalArgumentException();
        this.costs = costs;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Way way = (Way) o;
        return townTo.name.equals(way.townTo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(townTo.name);
    }
}
