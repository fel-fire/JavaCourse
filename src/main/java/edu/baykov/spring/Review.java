package edu.baykov.spring;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 9.2.2 Отзывы. Создайте класс Отзыв
 * состоящий из текста отзыва в виде строки и целочисленной оценки.
 */
@Getter
@Setter
@ToString
public class Review {

    private String text;
    private int rating;

    public Review(String text, int rating) {
        this.text = text;
        this.rating = rating;
    }
}
