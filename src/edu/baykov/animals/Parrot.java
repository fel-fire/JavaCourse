package edu.baykov.animals;

import java.util.Random;
/**
 * <p>Класс {@code Parrot}, реализующий сущность "Попугай", которая описывается следующим образом:</p>
 * <p>•	Имеет произносимый текст {@code textOfSong} (строка), который задается при создании объекта</p>
 * <p>•	Имеет метод петь - {@code sing}, выводящий на экран первые случайные N символов произносимого текста </p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
public class Parrot extends Bird {
    /**
     * Конструирует объект класса "Попугай" с произносимым текстом.
     */
    public Parrot(String textOfSong) {
        super(textOfSong);
    }

    /**
     * Метод, выводящий на экран первые случайные N символов произносимого текста {@code textOfSong}
     */
    @Override
    public void sing() {
        Random random = new Random();
        int endIndex = random.nextInt(getTextOfSong().length()) + 1;
        System.out.println(getTextOfSong().substring(0, endIndex));
    }
}
