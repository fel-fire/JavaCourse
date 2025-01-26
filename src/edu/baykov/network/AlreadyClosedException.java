package edu.baykov.network;
/**
 * <p>Класс, реализующий тип исключения {@code AlreadyClosedException} (unchecked),
 * описывающее ситуацию попытки использования закрытого ресурса</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    23-01-2025
 */
public class AlreadyClosedException extends RuntimeException {
    /**
     * Конструктор без параметров
     */
    public AlreadyClosedException() {
        super("Попытка использования закрытого ресурса");
    }
}
