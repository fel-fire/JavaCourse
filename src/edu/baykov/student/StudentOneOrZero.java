package edu.baykov.student;
/**
 * <p>Класс, реализующий тип Правила {@code Rule},
 * проверяющего соответствие оценок студента числам 1 или 0</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    23-01-2025
 * @see Rule
 * @see Student
 */
public class StudentOneOrZero implements Rule {
    /**
     * Метод, проверяющий, является ли значение 1 или 0.
     * @param value значение
     * @return true/false - да/нет
     */
    @Override
    public boolean check(int value) {
        return value == 1 || value == 0;
    }
}
