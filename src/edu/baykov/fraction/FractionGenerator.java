package edu.baykov.fraction;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс {@code FractionGenerator} представляет реализацию генератора обыкновенной дроби. Может генерировать
 * дроби. Может иметь только один экземпляр класса.
 *
 * @author   Nikolay Baykov
 */

public class FractionGenerator {
    private static FractionGenerator instance;


    private FractionGenerator() {
    }

    public static FractionGenerator getGenerator() {
        if (instance == null) instance = new FractionGenerator();
        return instance;
    }

    public Fraction generate(int numerator, int denominator) {
        return Fraction.of(numerator, denominator);
    }
}
