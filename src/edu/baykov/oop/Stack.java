package edu.baykov.oop;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>Класс {@code Stack} представляет реализацию структуру данных типа стек.
 * В классе реализованы методы: {@code push()} (положить элемент сверху), {@code pop()} (забрать элемент сверху),
 * {@code peek()} (просмотреть верхний элемент, не забирая его), {@code size()} (узнать размер стека)
 * @author Nikolay Baykov
 */
public class Stack<T> {
    private List<T> stackList = new ArrayList<>();

    public void push(T element) {
        stackList.add(element);
    }
    public final T peek() {
        if (stackList.isEmpty()) throw new RuntimeException("There are no elements available for pop in the stack");
        return stackList.getLast();
    }
    public T pop() {
        T tmp = peek();
        stackList.removeLast();
        return tmp;
    }

    public final int size() {
        return stackList.size();
    }

    @Override
    public String toString() {
        return "Stack "+ stackList;
    }
}
