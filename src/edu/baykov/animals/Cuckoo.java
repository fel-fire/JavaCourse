package edu.baykov.animals;

import java.util.Random;
/**
 * <p>Класс {@code Cuckoo}, реализующий сущность "Кукушка", которая описывается следующим образом:</p>
 * <p>•	Имеет произносимый текст {@code textOfSong} (строка)</p>
 * <p>•	Имеет метод петь - {@code sing}, выводящий на экран произносимый текст случайное количество раз от 1 до 10</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
public class Cuckoo extends Bird {
    /**
     * Конструирует объект класса "Кукушка" с произносимым текстом "ку-ку".
     */
    public Cuckoo() {
        super("ку-ку");
    }

    /**
     * Метод, вывлдящий на экран произносимый текст {@code textOfSong} случайное количество раз от 1 до 10
     */
    @Override
    public void sing() {
        Random random = new Random();
        int times = 1 + random.nextInt(10);
        for (int i = 0; i < times; i++)
            System.out.println(getTextOfSong());
    }
}
