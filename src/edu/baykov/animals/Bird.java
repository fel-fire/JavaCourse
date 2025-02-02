package edu.baykov.animals;

import lombok.Getter;
import lombok.NonNull;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Bird bird = (Bird) o;
        return Objects.equals(textOfSong, bird.textOfSong);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(textOfSong);
    }

    /**
     * Метод, заставляющий птицу петь.
     */
    public abstract void sing();
}
