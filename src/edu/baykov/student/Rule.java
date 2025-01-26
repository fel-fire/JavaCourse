package edu.baykov.student;
/**
 * <p>Интерфейс {@code Rule} с методом {@code check();}
 * </p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    25-01-2025
 */
public interface Rule {
    /**
     * Метод, проверяющий соответствие {@code value} заданному правилу
     * @return true/false соответствует/не соответствует
     */
    boolean check(int value);
}
