package edu.baykov.spring;

/**
 * 9.2.3 Лучший отзыв. Создайте бин типа Отзыв, который будет возвращать тот из бинов,
 * созданных в задаче 9.2.2, который имеет самую высокую оценку на момент запроса бина.
 */
public interface ReviewSelector {
    Review select(Review... reviews);
}
