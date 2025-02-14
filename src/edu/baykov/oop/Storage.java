package edu.baykov.oop;

/**
 * <p>Класс {@code Storage} представляет сущность хранилище, которое может хранить один произвольный
 * объект в один момент времени, неизменяемо. Объект кладется в Хранилище при его создании и задается альтернативное значение.
 * В качестве объекта может быть сохранено также и значение null.
 * Хранилище может вернуть ссылку на Объект. Если вместо объекта хранится null,
 * вернется его альтернативное значение.
 * @author Nikolay Baykov
 */
public class Storage<T> {
    private final T obj;

    public Storage(T obj) {
        this.obj = obj;
    }

    public T getObj(T alternativeValue) {
        return obj == null? alternativeValue : obj;
    }

}
