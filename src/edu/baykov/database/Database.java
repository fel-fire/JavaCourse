package edu.baykov.database;

import java.util.ArrayList;
import java.util.function.Function;

public class Database {
    private ArrayList<Extractable<?>> data = new ArrayList<>();

    public <T> T get (int value, Class<T> tClass) {
        return (T) data.get(value).extract(tClass);
    }

    public <T> void push(T obj, Function<T, String> representator, Function<String, T> extractor) {
        data.add(new StringRepresentation<>(obj, representator, extractor));
    }

    @Override
    public String toString() {
        return "Database{" +
                "data=" + data +
                '}';
    }
}
