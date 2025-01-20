package oop;
/**
 * <p>Класс {@code Lion} представляет животного - льва, который реализует интерфейс {@code Meowable}</p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    17-01-2025
 */
public class Lion implements Meowable{
    /**
     * Метод, выводящий на экран фразу, что лев мяукает.
     */
    @Override
    public void meow() {
        System.out.println("Lion is meowing");
    }
}
