package edu.baykov.oop;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.*;

public class MyStream<V> {

    public interface Action<V> {
        V doAction(V element);
    }

    @Getter
    private List<V> data;
    private List<Action> actions = new ArrayList<>();

    public MyStream(List<V> data) {
        this.data = new ArrayList<>(data);
    }

    public <P> MyStream<P> process(Function<V, P> applier) {
        Action<V> action = x -> (V) applier.apply(x);
        actions.add(action);
        return (MyStream<P>) this;
    }

    /**
     * Так я и не понял, как сделать так, чтобы метод фильтр не возвращал значение в случае если предикат не отработал
     */
    public  MyStream<V> filter(Predicate<V> tester) {
        Action<V> action = x -> {
            if (tester.test(x)) return x;
            else return null;
        };
        actions.add(action);
        return this;
    }

    public V reduce(V identity, BinaryOperator<V> reducer) {
        V result = identity;
        for (V element : data) {
            element = actionsFlush(element);
            result = reducer.apply(result, element);
        }
        return result;
    }

    public <P extends Collection<?>> P collect(Supplier<P> creator, BiConsumer<V, P> collector) {
        P collection = creator.get();
        for (V element : data) {
            element = actionsFlush(element);
            collector.accept(element, collection);
        }
        return collection;
    }

    private V actionsFlush(V element) {
        for (Action<V> act : actions) element = act.doAction(element);
        return element;
    }
}
