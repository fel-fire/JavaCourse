package edu.baykov.oop;

import java.util.function.Supplier;

public class LazyStorage<T> {
    Supplier<T> f;
    T obj;

    private LazyStorage(Supplier<T> supplier) {
        this.f = supplier;
    }

    public static <T> LazyStorage<T> of(Supplier<T> supplier) {
        return new LazyStorage<>(supplier);
    }

    public T getObject(T defaultValue) {
        if (f != null) obj = f.get();
        return obj == null ? defaultValue : obj;
    }
}
