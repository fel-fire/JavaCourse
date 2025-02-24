package edu.baykov.converter;

/**
 * <p>Абстрактный класс {@code Converter} представляет реализацию простого преобразователя строки в строку,
 * с возможностями чтения из файла и записи в файл, которые необходимо реализовать в классе-наследнике.
 * @author   Nikolay Baykov
 * @see Convertable
 */

public abstract class Converter<T> {
    /**
     * Здесь хранится способ преобразования
     */
    private final Convertable<T> conv;

    /**
     * С помощью такого конструктора определяем способ преобразования посредством
     * функционального интерфейса {@code Convertable}
     */
    public Converter(Convertable<T> conv) {
        this.conv = conv;
    }

    public final void convert(String inputFileName, String outputFileName) {
        save(conv.convert(open(inputFileName)), outputFileName);
    }

    abstract void save(T data, String filename);
    abstract T open(String fileName);

}


