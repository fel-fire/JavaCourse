package edu.baykov.converter;

/**
 * Функциональный интерфейс {@code Convertable} для определения способа преобразования объекта {@code T}
 */

public interface Convertable<T> {
    T convert(T t);
}
