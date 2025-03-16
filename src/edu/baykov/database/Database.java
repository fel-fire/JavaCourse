package edu.baykov.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Database {
    private ArrayList<String> data = new ArrayList<>();
    public Map<Class, Function<String, ?>> extractors = new HashMap<>();
    public Map<Class, Function<?, String>> respresentstors = new HashMap<>();

    public <T> T get (int index, Class<T> tClass) {
        return (T)  extractors.get(tClass).apply(data.get(index));
    }

    public <T> void push(T obj) {
        Function<T, String> func = (Function<T, String>) respresentstors.get(obj.getClass());
        data.add(func.apply(obj));
    }

    @Override
    public String toString() {
        return "Database{" +
                "data=" + data +
                '}';
    }
}
