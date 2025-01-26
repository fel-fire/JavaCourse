package edu.baykov.network;

import lombok.Getter;
import lombok.NonNull;

import java.util.Random;

/**
 * <p>Класс {@code Connection}, реализующий сущность "Подключение", которая описывает
 * связь с удаленным компьютером следующим образом:</p>
 * <p>•	Имеет адрес для связи {@code url} (строка)</p>
 * <p>•	Имеет состояние подключения {@code isOpen} (логическое значение)</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    24-01-2025
 */
@Getter
public class Connection {
    /**
     * Адрес для подключения.
     */
    String url;
    /**
     * Состояние подключения.
     */
    boolean isOpen;

    /**
     * Конструктор, принимающий в качестве аргумента адрес подключения и переводящий подключение в состояниие "открыто".
     * @param url адрес.
     */
    public Connection(@NonNull String url) {
        this.url = url;
        isOpen = true;
    }

    /**
     * Метод, закрывающий подключение.
     * @throws AlreadyClosedException при попытке вызова метода у закрытого подключения.
     */
    public void close() {
        if (!isOpen) throw new AlreadyClosedException();
        isOpen = false;
    }

    /**
     * Метод, получающий данные подключения. При каждом запросе, случайным образом, либо возвращайте текст
     * “test connection”, либо выбрасывается исключение {@code LostConnectionException}
     * Если подключение было закрыто, то при попытке запросить данные – бросается {@code AlreadyClosedException}
     * @return “test connection”
     */
    public String getData() throws LostConnectionException {
        if (!isOpen) throw new AlreadyClosedException();
        if(new Random().nextInt(10) == 0)
            throw new LostConnectionException("lost connection");
        return "test connection";
    }
}
