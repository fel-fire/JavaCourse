package edu.baykov.spring;

import edu.baykov.spring.IntGenerator;
import edu.baykov.spring.Review;
import edu.baykov.spring.ReviewSelector;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;


@Configuration
@ComponentScan(basePackages = {"com.apress.prospring5.ch2.Tasks"})
public class TaskConfig {

    @Bean
    public Integer min() {
        return 1;
    }
    @Bean
    public Integer max() {
        return 10;
    }

    /**
     * 9.2.1 random. Измените бин random из задачи 9.1.2 таким образом, что бы
     * 	Минимальное и максимальное значения задавались бинами из задачи 9.1.5
     * Возвращаемые им числа не повторялись до тех пор, пока не использованы
     * все значения в диапазоне от минимального до максимального.
     */
    @Bean
    @Scope("prototype")
    public Integer random(@Qualifier("randomIntGeneratorUniqFromRange") IntGenerator generator) {
        return generator.generateInt();
    }

    /**
     * 9.2.2 Отзывы. Далее создайте три бина типа Отзыв
     */
    @Bean
    public Review review1() {
        return new Review("Very Well", 4);
    }
    /**
     * 9.2.2 Отзывы. Далее создайте три бина типа Отзыв
     */
    @Bean
    public Review review2() {
        return new Review("Done", 3);
    }
    /**
     * 9.2.2 Отзывы. Далее создайте три бина типа Отзыв
     */
    @Bean
    public Review review3(@Qualifier("random") Integer rate) {
        return new Review("Hard to say", rate);
    }

    /**
     * 9.2.3 Лучший отзыв. Создайте бин типа Отзыв, который будет возвращать тот из бинов,
     * созданных в задаче 9.2.2, который имеет самую высокую оценку на момент запроса бина.
     */
    @Bean("theBestReview")
    @Lazy
    @Scope("prototype")
    public Review theBestRatingReview(@Qualifier("theBest") ReviewSelector selector, Review... reviews) {
        return selector.select(reviews);
    }



}
