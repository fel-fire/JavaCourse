package edu.baykov.oop;

import java.util.*;
import java.util.function.*;

public class DataStream<T> {

    private List<T> data;
    private List<Action> actions = new ArrayList<>();

    private interface Action<V, P> {
        Optional<V> doAction(P element);
    }

    private DataStream(List<T> data) {
        this.data = data;
    }

    public static <T> DataStream<T> of(T... obj) {
        return new DataStream<>(new ArrayList<>(Arrays.asList(obj)));
    }

    public static <T> DataStream<T> of(List<T> list) {
        return new DataStream<>(new ArrayList<>(list));
    }

    public <P> DataStream<P> map(Function<T, P> applier) {
        Action<P, T> action = x -> Optional.ofNullable(applier.apply(x));
        actions.add(action);
        return (DataStream<P>) this;
    }


    public DataStream<T> filter(Predicate<T> tester) {
        Action<T, T> action = x -> {
            if (tester.test(x)) return Optional.ofNullable(x);
            else return null;
        };
        actions.add(action);
        return this;
    }

    public T reduce(T identity, BinaryOperator<T> reducer) {
        T result = identity;
        T value;
        for (T element : data) {
            Optional check = actionsFlush(element);
            if (check == null) continue;
            value = (T) check.orElse(null);
            result = reducer.apply(result, value);
        }
        clearResources();
        return result;
    }

    public <P> P collect(Supplier<P> creator, BiConsumer<T, P> collector) {
        P collection = creator.get();
        T value;
        for (T element : data) {
            Optional check = actionsFlush(element);
            if (check == null) continue;
            value = (T) check.orElse(null);
            collector.accept(value, collection);
        }
        clearResources();
        return collection;
    }

    private Optional<?> actionsFlush(T element) {
        Optional result = Optional.ofNullable(element);
        for (Action act : actions) {
            if (result == null) break;
            result = act.doAction(result.orElse(null));
        }
        return result;
    }

    private void clearResources() {
        data.clear();
        actions.clear();
    }
}

