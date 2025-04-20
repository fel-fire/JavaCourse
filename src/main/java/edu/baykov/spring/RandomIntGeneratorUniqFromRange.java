package edu.baykov.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 9.2.1 random. Класс генератора случайных целых чисел. Хранит в себе все значения в заданном диапазоне
 * Возвращает случайное из хранящихся значений и удаляет его из хранилища. В случае, когда все значения
 * из диапазона были удалены, заполняет хранилище всеми значениями диапазона заново.
 */
@Component
public class RandomIntGeneratorUniqFromRange implements IntGenerator {
    private int min, max;
    private ArrayList<Integer> values;
    private Random random = new Random();

    public RandomIntGeneratorUniqFromRange(@Qualifier("min") int min, @Qualifier("max") int max) {
        if (min > max) throw new IllegalArgumentException("the lower limit of range is greater than the upper limit");
        this.min = min;
        this.max = max;
        values = new ArrayList<>(max+1 - min);
    }

    @PostConstruct
    private void init() {
        IntStream.range(min, max+1).forEach((x) -> values.add(x));
    }

    @Override
    public Integer generateInt() {
        if (values.isEmpty()) init();
        return values.remove(random.nextInt(values.size()));
    }
}
