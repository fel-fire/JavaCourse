package edu.baykov.student;

/**
 * 6.1.3 Сравнимое. Интерфейс {@code Comparable} гарантирующий наличие по данной ссылке метода {@code toCompare}
 */
public interface Comparable<T> {
    int toCompare(T obj);
}
