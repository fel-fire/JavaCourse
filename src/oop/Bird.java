package oop;

import lombok.Getter;
import lombok.NonNull;

/**
 * <p>Абстрактный класс {@code Bird}, являющийся корнем иерархии для всех, кто является подвидом птицы:</p>
 * <p>•	Имеет произносимый текст {@code textOfSong} (строка)</p>
 * <p>•	Имеет абстрактный метод {@code sing}</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
public abstract class Bird {
    /**
     * Произносимый текст.
     */
    @Getter
    private final String textOfSong;

    /**
     * Конструктор, инициализирующий поле {@code text}
     * @param text произносимы птицей текст
     */
    public Bird(@NonNull String text) {
        this.textOfSong = text;
    }

    /**
     * Метод, заставляющий птицу петь.
     */
    public abstract void sing();
}
