package edu.baykov.main;

import edu.baykov.network.Connection;
import edu.baykov.network.LostConnectionException;
import edu.baykov.oop.Fraction;
import edu.baykov.student.InvalidMarksValueException;
import edu.baykov.student.Student;
import edu.baykov.student.StudentOneOrZero;
import edu.baykov.student.StudentOnlyEven;

import java.math.BigDecimal;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
//import edu.baykov.geometry.Point;

public class Main {
    public static void main(String[] args) {

        //3.1.3 Сложение из пакетов. С использованием метода из задачи 2.3.1 выполните следующее сложение
        System.out.println(method_3_1_3(7, new Fraction(11, 3), new BigDecimal("12345678912345678912")));

        //3.1.4
        System.out.println(method_3_1_4(args[0], args[1]));

        // 3.1.5 Простые имена. Создайте и вывести на экран экземпляры двух классов: Точки координат из пакета
        // ru.baykov.geometry (задача 2.1.5), и точки координат из пакета java.awt.Point.
        // Напишите код так, чтобы как минимум один из классов был доступен по простому имени.
        System.out.println(new edu.baykov.geometry.Point(1, 2));
        System.out.println(new Point(5, 6));

        test_4_1_1();

        test_4_1_4();

        method_4_2_1();

        System.out.println(method_4_2_2("qwe", "10", "asd", "2", "ghj", "3", "zxc"));


        //4.2.3
        List<Student> list = List.of(
                new Student("Vasiliy", new StudentOnlyEven(), 2, 4, 6, 8, 10, 10, 2),
                new Student("Petr", 10, 20, 13, 41, 51, 60, 70),
                new Student("Sidor", new StudentOnlyEven(), 2, 4, 6, 8, 10, 10, 2)
        );
        method_4_2_3(list);
        System.out.println(list);

    /*
            4.2.2. Восстановление студентов. Реализуйте вызов этого метода и обработку результатов его выполнения следующим образом:
    •	В качестве параметров передайте списки случайно выбранных строк.
    •	Если преобразование прошло без ошибок, то на экран выводятся все студенты из списка
    •	Если ошибка произошла в конструкторе – на экран выводится текст “студента Х создать невозможно”,
    где вместо Х указывается имя студента, для которого произошла ошибка.
    •	Если ошибка произошла в методе добавления оценок студенту – необходимо вызывать метод convert еще раз, передав
    в качестве второго параметра пустой список.  Полученный после этого список студентов необходимо вывести на экран.
    */
        //Вариант 1 - с обработкой других ошибок
        List<String> constructorArgs = new ArrayList<>();
        List<String> addArgs = new ArrayList<>();
        List<Student> result;
        try {
            try {
                result = convert(constructorArgs, addArgs);
            } catch (InvalidMarksValueException e) {
                try {
                    result = convert(constructorArgs, new ArrayList<>());
                } catch (InvalidMarksValueException ex) {
                    throw new RuntimeException("Студента " + ex.getMessage() + " создать невозможно", ex);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println("4.2.4: " + result);


        //4.2.2. Восстановление студентов. Вариант 2 - только с обработкой InvalidMarksValueException
        List<String> constructorArgs2 = new ArrayList<>();
        List<String> addArgs2 = new ArrayList<>();
        List<Student> result2;
        try {
            result2 = convert(constructorArgs, addArgs2);
            System.out.println(result2);
        } catch (InvalidMarksValueException e) {
            try {
                result2 = convert(constructorArgs, new ArrayList<>());
                System.out.println(result2);
            } catch (InvalidMarksValueException ex) {
                System.out.println("Студента " + ex.getMessage() + " создать невозможно");
            }
        }

    }


// В указанном блоке располагаются решения задач из разделов 3 и 4, которые необходимо было выполнить
// в виде разработки нового метода

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

    private static void test_4_1_1() {
        Student vasya = new Student("Vasya", new StudentOneOrZero(), 1, 1, 1, 0, 0, 0);
        Student petya = new Student("Petya", new StudentOnlyEven(), 2, 4, 6, 8);
        Student sidor = new Student("Sidor", 1, 10, 20, 30, 40);
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println(sidor);
    }

    private static void test_4_1_4() {
        Connection c = new Connection("www.google.com");
        System.out.println(c.isOpen());
        System.out.println(c.getUrl());
        try {
            System.out.println(c.getData());
        } catch (LostConnectionException e) {
            System.out.println(e.getMessage());
        }
        c.close();
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
                ;
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
    public static List<Student> convert(List<String> constructorArgs, List<String> addArgs) throws InvalidMarksValueException {
        return new ArrayList<>();
    }

}



