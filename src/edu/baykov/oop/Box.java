package edu.baykov.oop;
/**
 * <p>Класс {@code Box} представляет реализацию коробки для хранения 1 произвольного объекта {@code obj}
 * в зависимости от параметра типа класса
 * @author Nikolay Baykov
 */
public class Box<T> {
    T obj;

    public T getObj() {
        T tmp = obj;
        obj = null;
        return tmp;
    }

    public void setObj(T obj) {
        if (this.obj != null) throw new IllegalArgumentException("The box isn't empty");
        this.obj = obj;
    }

    public boolean isEmpty() {
        return obj == null;
    }
}
