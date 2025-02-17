package edu.baykov.fraction;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Класс {@code Fraction} представляет реализацию обыкновенной дроби со следующими особенностями:
 * <p>•	Имеет числитель: {@code int}</p>
 * <p>•	Имеет знаменатель:  {@code int}</p>
 * <p>•	Выполнет операции сложения, вычитания, умножения и деления с другой дробью - объектом класса Fraction
 * или целым числом. Класс имеет {@code fractionPool}, который содержит все сгенерированные дроби. В случе если генерируемая дробь
 *  *  содержится в пуле, то вместо создания новой дроби возвращается ссылка на дробь из пула.</p>
 * @author   Nikolay Baykov
 */
@Getter
public final class Fraction extends Number implements Cloneable {
    private static final List<Fraction> fractionPool = new ArrayList<>();
    private final int numerator;
    private final int denominator;

    /** Конструирует обыкновенную дробь из целого числа, переданного в качестве параметра:
     * ПЕРЕСТАЛ БЫТЬ НУЖЕН ИЗЗА МЕТОДА OF
     * @param numerator
     **/
/*    Fraction(int numerator) {
        this(numerator, 1);
    }*/

    Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("В знаменателе не должен быть 0");
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Добавлен метод of, чтобы исключить возможность создания новых объектов дроби без проверки в fractionPool
     */

    public static Fraction of(int numerator, int denominator) {
        Fraction newFraction = new Fraction(numerator, denominator);
        if (!fractionPool.contains(newFraction)) fractionPool.add(newFraction);
        else return fractionPool.get(fractionPool.indexOf(newFraction));
        return newFraction;
    }
    public static Fraction of(int numerator) {
        return Fraction.of(numerator, 1);
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    public Fraction sum(Fraction f) {
        int newDenominator = findNOK(this.denominator, f.denominator);
        int newNumerator = this.numerator*(newDenominator/this.denominator) + f.numerator*(newDenominator/f.denominator);
        return Fraction.of(newNumerator, newDenominator);
    }
    /**
     * Перегруженный метод sum() осуществляет сложение текущего объекта - дроби с целым числом,
     * переданным в качестве параметра.
     */
    public Fraction sum(int i) {
        return this.sum(Fraction.of(i));
    }

    public Fraction substract(Fraction f) {
        int newDenominator = findNOK(this.denominator, f.denominator);
        int newNumerator = this.numerator*(newDenominator/this.denominator) - f.numerator*(newDenominator/ f.denominator);
        return Fraction.of(newNumerator, newDenominator);
    }
    /**
     * Перегруженный метод substract() осуществляет вычитание из текущего объекта - дроби целого числа,
     * переданного в качестве параметра.
     */
    public Fraction substract(int i) {
        return this.substract(Fraction.of(i));
    }

    public Fraction multiple(Fraction f) {
        int newDenominator = this.denominator * f.denominator;
        int newNumerator = this.numerator*f.numerator;
        int nod = findNOD(newNumerator, newDenominator);
        return Fraction.of(newNumerator/nod, newDenominator/nod);
    }
    /**
     * Перегруженный метод multiple() осуществляет умножение текущего объекта - дроби на целое число,
     * переданное в качестве параметра.
     */
    public Fraction multiple(int i) {
        return this.multiple(Fraction.of(i));
    }

    public Fraction divide(Fraction f) {
        int newDenominator = this.denominator * f.numerator;
        int newNumerator = this.numerator*f.denominator;
        int nod = findNOD(newNumerator, newDenominator);
        return Fraction.of(newNumerator/nod, newDenominator/nod);
    }
    /**
     * Перегруженный метод divide() осуществляет деление текущего объекта - дроби на целое число,
     * переданное в качестве параметра.
     */
    public Fraction divide(int i) {
        return this.divide(Fraction.of(i));
    }

    /**
     * Метод для нахождения наибольшего общего делителя чисел a и b.
     */
    private static int findNOD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }
    /**
     * Метод для нахождения наименьшего общего кратного чисел a и b.
     */
    private static int findNOK(int a, int b) {
        return a*b/findNOD(a,b);
    }

    @Override
    public int intValue() {
        return numerator/denominator;
    }

    @Override
    public long longValue() {
        return numerator/denominator;
    }

    @Override
    public float floatValue() {
        return (float) numerator/denominator;
    }

    @Override
    public double doubleValue() {
        return (double) numerator/denominator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numerator, denominator);
    }

    /**
     *Метод изменен, чтобы не допустить создания копии дроби, не содержащейся в fractionPool
     */
    @Override
    public Fraction clone() {
        return Fraction.of(numerator, denominator);
    }
}
