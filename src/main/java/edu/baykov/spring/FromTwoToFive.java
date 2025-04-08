package edu.baykov.spring;

import java.util.function.Predicate;

public class FromTwoToFive implements Predicate<Integer> {
    @Override
    public boolean test(Integer integer) {
        return integer >= 2 && integer <=5;
    }
}
