package edu.baykov.oop;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

public class MyStream<T> {

    private List<Optional<T>> data;
    private List<Action> actions = new ArrayList<>();

    interface Action<V, P> {
        V doAction(P element);
    }
    public MyStream(List<T> data) {
        this.data = new ArrayList<>();
        for (T element : data) this.data.add(Optional.of(element));
    }

    public <P> MyStream<P> map(Function<T, P> applier) {
        Action<P, T> action = x -> applier.apply(x);
        actions.add(action);
        return (MyStream<P>) this;
    }


    public  MyStream<T> filter(Predicate<T> tester) {
        Action<T, T> action = x -> {
            if (tester.test(x)) return x;
            else return null;
        };
        actions.add(action);
        return this;
    }

    public <R> R reduce(R identity, BinaryOperator<R> reducer) {
        R result = identity;
        R value;
        for (Optional<T> element : data) {
            Optional check = actionsFlush(element);
            if (check.isEmpty()) continue;
            value = (R) check.get();
            result = reducer.apply(result, value);
        }
        clearResources();
        return result;
    }

    public <P extends Collection<?>> P collect(Supplier<P> creator, BiConsumer<T, P> collector) {
        P collection = creator.get();
        T value;
        for (Optional<T> element : data) {
            Optional check = actionsFlush(element);
            if (check.isEmpty()) continue;
            value = (T) check.get();
            collector.accept(value, collection);
        }
        clearResources();
        return collection;
    }

    private Optional<?> actionsFlush(Optional<?> element) {
        Optional result = Optional.of(element.get());
        for (Action act : actions) {
            if (result.isPresent())  {

                result = Optional.ofNullable(act.doAction(element.get()));
            }

        }
        return result;
    }

    private void clearResources() {
        data.clear();
        actions.clear();
    }
}

