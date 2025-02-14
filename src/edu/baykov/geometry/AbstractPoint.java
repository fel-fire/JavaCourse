package edu.baykov.geometry;

import lombok.Getter;

public abstract class AbstractPoint implements Cloneable{
    @Override
    public AbstractPoint clone() {
        try {
            return (AbstractPoint) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    abstract int distanceTo(AbstractPoint end);

}
