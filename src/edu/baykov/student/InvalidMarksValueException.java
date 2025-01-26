package edu.baykov.student;
/**
 * <p>Класс, реализующий тип исключения {@code InvalidMarksValueException},
 * возникающего в случае добавления студенту {@code Srudent} оценки,
 * не соответствующей заявленному правилу {@code Rule}</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    23-01-2025
 * @see Rule
 * @see Student
 */
public class InvalidMarksValueException extends RuntimeException {
    /**
     * Конструктор без параметров
     */
    public InvalidMarksValueException() {
    }

    /**
     * Конструктор с пояснением исключения. Принимает в качестве аргумента сообщение.
     */
    public InvalidMarksValueException(String message) {
        super(message);
    }
}
