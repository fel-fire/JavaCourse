package edu.baykov.database;

public interface Extractable<T> {
    public T extract(Class<?> c);
}
