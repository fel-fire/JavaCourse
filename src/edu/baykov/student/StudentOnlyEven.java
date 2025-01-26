package edu.baykov.student;
/**
 * <p>Класс, реализующий тип Правила {@code Rule},
 * проверяющего соответствие оценок студента только четным числам</p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    23-01-2025
 * @see Rule
 * @see Student
 */
public class StudentOnlyEven implements Rule {
    /**
     * Метод, проверяющий, является ли значение четным.
     * @param value значение
     * @return true/false - да/нет
     */
    @Override
    public boolean check(int value) {
        return value%2 == 0;
    }
}
