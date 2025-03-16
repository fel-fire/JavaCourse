package edu.baykov.database;

import java.util.function.Function;

public class StringRepresentation<T> {

    private Function<String, T> extractor;

    private String representation;
    private Class<T> tClass;

    public StringRepresentation(T obj, Function<T, String> representator, Function<String, T> extractor) {
        tClass = (Class<T>) obj.getClass();
        this.extractor = extractor;
        representation = representator.apply(obj);
    }

    public T extract(Class<?> c) {
        if (c == String.class) return (T) representation;
        if (c == tClass) return extractor.apply(representation);
        else throw new IllegalArgumentException("Invalid class type");
    }
}

