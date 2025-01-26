package edu.baykov.network;

/**
 * <p>Класс, реализующий тип исключения {@code LostConnectionException} (checked),
 * описывающего ситуацию потери сетевой связи</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    23-01-2025
 */
public class LostConnectionException extends Exception{
    /**
     * Пустой конструктор
     */
    public LostConnectionException() {
    }

    /**
     * Конструктор со строкой.
     * @param message сообщение об исключении.
     */
    public LostConnectionException(String message) {
        super(message);
    }

    /**
     * Конструктор со строкой и причиной
     * @param message сообщение об исключении.
     * @param cause причина.
     */
    public LostConnectionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Конструктор с причиной.
     * @param cause причина.
     */
    public LostConnectionException(Throwable cause) {
        super(cause);
    }
}
