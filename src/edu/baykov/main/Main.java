package edu.baykov.main;

import edu.baykov.network.Connection;
import edu.baykov.network.LostConnectionException;
import edu.baykov.student.InvalidMarksValueException;
import edu.baykov.student.Student;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import edu.baykov.geometry.Point;

/**
 * В указанном классе {@code Main} располагаются решения задач из разделов задачника, которые необходимо было выполнить
 * в виде разработки нового метода.
 * @author Nikolay Baykov
 */

public class Main {
    public static void main(String[] args) {

    }


    /* 3.1.3 Сложение. Разработайте метод, который принимает набор числовых значений и возвращает их
    сумму в вещественной форме. С использованием данного метода выполните следующие сложения:*/
    private static double method_3_1_3(Number... numbers) {
        if (numbers == null || numbers.length == 0)
            throw new IllegalArgumentException("Invalid input values");
        double res = 0;
        for (Number number : numbers) res += number.doubleValue();
        return res;
    }

    /*3.1.4 Возведение в степень. Создайте метод принимающий две строки, в которых будут записаны числа X и Y.
    Возвращает метод результат возведения X в степень Y.
    Для преобразования строки в число следует использовать метод Integer.parseInt,
    а для возведения в степень метод Math.pow.*/
    private static int method_3_1_4(String number, String power) {
        int n, p;
        try {
            n = parseInt(number);
            p = parseInt(power);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Please insert numbers");
        }
        return (int) pow(n, p);
    }

    /*
    4.2.1 Читаем данные. Разработайте метод, который ничего не принимает и не возвращает, при этом выполняет следующие действия:
        Шаг 1. Создаем подключение по адресу ermakov.edu
        Шаг 2. Считываем и выводим на экран десять строк.
                Шаг 3. Закрываем соединение.
        Гарантируйте, что третий шаг будет выполнен вне зависимости от того, были ли брошены какие-либо исключения на втором шаге.
    */
    private static void method_4_2_1() {
        Connection c = new Connection("ermakov.edu");
        try {
            for (int i = 0; i < 10; i++)
                System.out.println(c.getData());
        } catch (LostConnectionException e) {
            System.out.println(e.getMessage());
        } finally {
            c.close();
        }
    }

    /*4.2.2 Складываем строки. Разработайте метод, который принимает набор строк. Все числа в списке необходимо преобразовать
       к числу, и поделить первое число в списке на остальные числа в списке. Любую строку, не являющуюся числом, следует
       игнорировать. Результат деления верните из метода.*/
    private static int method_4_2_2(String... strings) {
        List<Integer> digits = new ArrayList<>();
        int divisor = 0;
        for (String str : strings) {
            try {
                int value = Integer.parseInt(str);
                digits.add(value);
                divisor += value;
            } catch (NumberFormatException e) {
                System.out.println(str + " не является целым числом");
            }
        }
        return digits.getFirst() / (divisor - digits.getFirst());
    }

    /*4.2.3 Добавляем оценки. Разработайте метод, который принимает список Студентов (из задачи 4.1.1) и
     добавляет каждому из них случайную оценку в диапазоне от 1 до 10. В случае, если кому-то из студентов
     нельзя добавить оценку - она не добавляется никому, а метод возвращает информацию об этой ситуации.*/

    private static void method_4_2_3(List<Student> students) {

        int[] randomMarks = new int[students.size()];
        Random random = new Random();
        try {
            for (int i = 0; i < students.size(); i++) {
                Student testStudent = new Student(students.get(i));
                int value = random.nextInt(9) + 1;
                testStudent.addMark(value);
                randomMarks[i] = value;
            }
            for (int i = 0; i < students.size(); i++) {
                students.get(i).addMark(randomMarks[i]);
            }
        } catch (InvalidMarksValueException e) {
            System.out.println(e.getMessage());
        }
    }

    /* 4.2.4. convert метод */
    public static List<Student> convert(List<String> constructorArgs, List<String> addArgs)
            throws InvalidMarksValueException {
        return new ArrayList<>();
    }

}



