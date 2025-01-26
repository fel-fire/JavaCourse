package edu.baykov.animals;

/**
 * <p>Класс {@code Sparrow}, реализующий сущность "Воробей", которая описывается следующим образом:</p>
 * <p>•	Имеет произносимый текст {@code textOfSong} (строка)</p>
 * <p>•	Имеет метод петь - {@code sing}, выводящий на экран произносимый текст</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
public class Sparrow extends Bird{
    /**
     * Конструирует объект класса "Воробей" с произносимым текстом "чирик".
     */
    public Sparrow() {
        super("чирик");
    }
    /**
     * Метод, выводящий на экран произносимый текст {@code textOfSong}
     */
    @Override
    public void sing() {
        System.out.println(getTextOfSong());
    }
}
