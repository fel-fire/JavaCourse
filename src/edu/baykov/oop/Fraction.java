package edu.baykov.oop;

/**
 * Класс представляет реализацию обыкновенной дроби со следующими особенностями:
 * <p>•	Имеет числитель: целое число</p>
 * <p>•	Имеет знаменатель: целое число</p>
 * <p>•	Создается с указанием числителя и знаменателя </p>
 * <p>•	Возвращает строковое представление вида “числитель/знаменатель”</p>
 * <p>•	Выполнет операции сложения, вычитания, умножения и деления с другой дробью - объектом класса Fraction
 * или целым числом. </p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.1
 * @since    03-01-2025
 */

public final class Fraction extends Number {
    /**
     * Числитель дроби
     */
    private final int numerator;
    /**
     * Знаменатель дроби
     */
    private final int denominator;

    /**
     * Конструирует обыкновенную дробь из целого числа, переданного в качестве параметра:
     * @param numerator целое число.
     */
    public Fraction(int numerator) {
        this(numerator, 1);
    }

    /**
     * Конструирует обыкновенную дробь из переданных значений числителя и знаменателя.
     * @param numerator числитель.
     * @param denominator знаменатель.
     * @throws IllegalArgumentException если в знаменатель передано значение 0.
     */
    public Fraction(int numerator, int denominator) {
        if (denominator == 0) throw new IllegalArgumentException("В знаменателе не должен быть 0");
        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Возвращает текстовое представление обыкновенной дроби.
     * @return строковое представление в виде "numerator/denominator".
     */
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    /**
     * Метод осуществляет сложение текущего объекта - дроби с обыкновенной дробью, переданной в качестве параметра.
     * @param f объект класса Fraction
     * @return новый объект класс Fraction - результат сложения дробей
     */
    public Fraction sum(Fraction f) {
        int newDenominator = findNOK(this.denominator, f.denominator);
        int newNumerator = this.numerator*(newDenominator/this.denominator) + f.numerator*(newDenominator/f.denominator);
        return new Fraction(newNumerator, newDenominator);
    }
    /**
     * Перегруженный метод sum() осуществляет сложение текущего объекта - дроби с целым числом,
     * переданным в качестве параметра.
     * @param i целое число.
     * @return вызов метода sum(Fraction f).
     */
    public Fraction sum(int i) {
        return this.sum(new Fraction(i));
    }
    /**
     * Метод осуществляет вычитание из текущего объекта - дроби обыкновенной дроби, переданной в качестве параметра.
     * @param f объект класса Fraction
     * @return новый объект класс Fraction - результат вычитания дробей
     */
    public Fraction substract(Fraction f) {
        int newDenominator = findNOK(this.denominator, f.denominator);
        int newNumerator = this.numerator*(newDenominator/this.denominator) - f.numerator*(newDenominator/ f.denominator);
        return new Fraction(newNumerator, newDenominator);
    }
    /**
     * Перегруженный метод substract() осуществляет вычитание из текущего объекта - дроби целого числа,
     * переданного в качестве параметра.
     * @param i целое число.
     * @return вызов метода substract(Fraction f).
     */
    public Fraction substract(int i) {
        return this.substract(new Fraction(i));
    }
    /**
     * Метод осуществляет умножение текущего объекта - дроби на обыкновенную дробь, переданную в качестве параметра.
     * @param f объект класса Fraction
     * @return новый объект класс Fraction - результат умножения дробей
     */
    public Fraction multiple(Fraction f) {
        int newDenominator = this.denominator * f.denominator;
        int newNumerator = this.numerator*f.numerator;
        int nod = findNOD(newNumerator, newDenominator);
        return new Fraction(newNumerator/nod, newDenominator/nod);
    }
    /**
     * Перегруженный метод multiple() осуществляет умножение текущего объекта - дроби на целое число,
     * переданное в качестве параметра.
     * @param i целое число.
     * @return вызов метода multiple(Fraction f).
     */
    public Fraction multiple(int i) {
        return this.multiple(new Fraction(i));
    }
    /**
     * Метод осуществляет деление текущего объекта - дроби на обыкновенную дробь, переданную в качестве параметра.
     * @param f объект класса Fraction
     * @return новый объект класс Fraction - результат деления дробей
     */
    public Fraction divide(Fraction f) {
        int newDenominator = this.denominator * f.numerator;
        int newNumerator = this.numerator*f.denominator;
        int nod = findNOD(newNumerator, newDenominator);
        return new Fraction(newNumerator/nod, newDenominator/nod);
    }
    /**
     * Перегруженный метод divide() осуществляет деление текущего объекта - дроби на целое число,
     * переданное в качестве параметра.
     * @param i целое число.
     * @return вызов метода divide(Fraction f).
     */
    public Fraction divide(int i) {
        return this.divide(new Fraction(i));
    }

    /**
     * Служебный метод для нахождения наибольшего общего делителя чисел a и b.
     * @param a целое число.
     * @param b целое число.
     * @return целое число - НОД чисел a и b
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
     * Служебный метод для нахождения наименьшего общего кратного чисел a и b.
     * @param a целое число.
     * @param b целое число.
     * @return целое число - НОК чисел a и b
     */
    private static int findNOK(int a, int b) {
        return a*b/findNOD(a,b);
    }

    /**
     * Возвращает представление в виде {@code int} числа, округленного до полного целого числа.
     */
    @Override
    public int intValue() {
        return numerator/denominator;
    }
    /**
     * Возвращает представление в виде {@code long} числа, округленного до полного целого числа.
     */
    @Override
    public long longValue() {
        return numerator/denominator;
    }
    /**
     * Возвращает представление в виде {@code float} числа.
     */
    @Override
    public float floatValue() {
        return (float) numerator/denominator;
    }
    /**
     * Возвращает представление в виде {@code double} числа.
     */
    @Override
    public double doubleValue() {
        return (double) numerator/denominator;
    }
}
