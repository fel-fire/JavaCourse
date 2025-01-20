package oop;

import lombok.Getter;

/**
 * <p>Класс {@code Cat} представляет животного - кота, который может помяукать
 * один или несколько раз. Реализует интерфейс {@code Meowable}</p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    17-01-2025
 */


@Getter
public class Cat implements Meowable{
    /**
     * Имя кота
     */
    private final String name;

    /**
     * Конструирует объект класса Cat. В качестве параметра принимает строку name.
     * @param name имя кота.
     * @throws IllegalArgumentException если имя пустое или является null.
     */
    public Cat(String name) {
        if (name == null || name.isEmpty())
            throw new IllegalArgumentException("Имя не может быть пустым или null");
        this.name = name;
    }

    /**
     * Метод возвращает строковое представление объекта
     * @return строковое представление объекта класса Cat в виде "Кот: @name"
     */
    @Override
    public String toString() {
        return "Кот: " + name;
    }

    /**
     * <p>Метод заставляет кота мяукнуть один раз.
     * О том, что кот мяукнул, выводится на экран</p>
     */
    @Override
    public void meow() {
        System.out.println(name + ": мяу!");
    }

    /**
     * <p>Перегруженный метод meow() заставляет кота мяукнуть количество раз, переданное в качестве параметра.
     * О том, что кот мяукнул, выводится на экран. </p>
     * @param numOfRepeat не может быть меньше 1, иначе кот будет молчать.
     */
    public void meow(int numOfRepeat) {
        if (numOfRepeat < 1) {
            System.out.println("Барсик молчит");
            return;
        }
        String result = "-мяу".repeat(numOfRepeat);
        result = result.replaceFirst("-", "");
        System.out.println(name + ": " + result + "!");
    }
}
