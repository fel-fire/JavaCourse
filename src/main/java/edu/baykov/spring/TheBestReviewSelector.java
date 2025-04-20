package edu.baykov.spring;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 9.2.3 Лучший отзыв. Создайте бин типа Отзыв, который будет возвращать тот из бинов,
 * созданных в задаче 9.2.2, который имеет самую высокую оценку на момент запроса бина.
 */
@Component("theBest")
public class TheBestReviewSelector implements ReviewSelector {
    @Override
    public Review select(Review... reviews) {
        return  Arrays.stream(reviews).max(Comparator.comparingInt(Review::getRating)).orElseThrow();
    }
}
