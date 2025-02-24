package edu.baykov.main;

import edu.baykov.oop.MyStream;
import edu.baykov.converter.Converter;
import edu.baykov.converter.StringConverter;
import edu.baykov.database.Database;
import edu.baykov.geometry.Line;
import edu.baykov.geometry.Point;
import edu.baykov.geometry.Point3D;
import edu.baykov.network.Connection;
import edu.baykov.network.LostConnectionException;
import edu.baykov.oop.*;
import edu.baykov.student.InvalidMarksValueException;
import edu.baykov.student.Student;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
//import edu.baykov.geometry.Point;

/**
 * В указанном классе {@code Main} располагаются решения задач из разделов задачника, которые необходимо было выполнить
 * в виде разработки нового метода.
 *
 * @author Nikolay Baykov
 */



public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {

    }

    public static LazyStorage<Integer> sum(Integer... ints) {


        if (ints == null) return LazyStorage.of(null);

        Supplier<Integer> sum = () -> {
            ArrayList<Integer> list = new ArrayList<>(List.of(ints));
            int result = 0;
            for (int i : list) {
                result += i;
                System.out.println("counting");
            }
            return result;
        };

        return LazyStorage.of(sum);
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

/*    6.2.1 Сдвинуть линию. Создайте метод, принимающий Линию из задачи 6.1.5 (с любой допустимой параметризацией)
    сдвигающей точку начала на 10 единиц по оси X. Например, если X был 5,
    то должен стать 15, если X был -7 то должен стать -17.*/

    public static void move(Line<? extends Point3D> line) {
        int startPointX = line.getStart().getX();
        startPointX = startPointX < 0 ? startPointX - 10 : startPointX + 10;
        line.getStart().setX(startPointX);
    }

/*    6.2.2 Поиск максимума. Создайте метод, принимающий набор Коробок из задачи 6.1.1 и возвращающий максимальное
    из их значений в формате double. Принимаемые методом Коробки могут быть параметризованы любыми видами чисел.
    */

    public static double maximum(Box<? extends Number>... boxes) {
        double maxValue = 0;
        for (Box<? extends Number> box : boxes) {
            double value = box.getObj().doubleValue();
            maxValue = Math.max(value, maxValue);
        }
        return maxValue;
    }
/*    6.2.3 Начало отсчета. Создайте метод, принимающий Коробку из задачи 6.1.1, и кладет в неё трехмерную точку
    координат (из задачи 2.1.5) с произвольными значениями. Метод должен позволять передавать
    Коробку с более чем одним видом параметризации.*/

    public static void putPointInBox(Box<? super Point3D> box) {
        if (box.isEmpty()) box.setObj(new Point3D(1, 2, 3));
    }

    /*6.2.4 Заполнение списка. Создайте метод, который принимает список чисел и заполняет его значениями
    от 1 до 100. Метод должен принимать список с более чем одной параметризацией.*/

    public static void fill(ArrayList<? super Integer> list) {
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
    }

/*    6.3.1 Функция. Разработайте такой метод, который будет принимать список значений типа T, и объект имеющий
    единственный метод apply. Данный метод надо применить к каждому элементу списка, и вернуть новый список
    значений типа P, при этом типы T и P могут совпадать, а могут не совпадать.*/


    public static <T, P> List<P> process(List<T> list, Function<T, P> applier) {
        List<P> result = new ArrayList<>();
        for (T element : list) {
            result.add(applier.apply(element));
        }
        return result;
    }

/*    6.3.2 Фильтр. Разработайте такой метод, который будет принимать список значений типа T и объект имеющий
    единственный метод test (принимает T и возвращает boolean). Верните новый список типа T, из которого удалены
    все значения не прошедшие проверку условием.*/

    public static <T> List<T> filter(List<T> list, Predicate<T> tester) {
        ArrayList<T> result = new ArrayList<>();
        for (T element : list) {
            if (tester.test(element)) result.add(element);
        }
        return result;
    }

/*    6.3.3 Сокращение. Разработайте такой метод, который будет принимать список значений типа T и способ с помощью
    которого список значений можно свести к одному значению типа T, которое и возвращается из метода.*/

    public static <T> T reduce(List<T> list, T identity, BinaryOperator<T> reducer) {
        T result = identity;
        for (T element : list) {
            result = reducer.apply(result, element);
        }
        return result;
    }

/*    6.3.4 Коллекционирование. Разработайте такой метод, который будет возвращать коллекцию типа P со значениями типа T. Данный метод будет принимать:
        1.	Список исходных значений
        2.	Способ создания результирующей коллекции
        3.	Способ передачи значений исходного списка в результирующую коллекцию.*/

    public static <T, P extends Collection<?>> P collect(List<T> list, Supplier<P> creator, BiConsumer<T, P> collector) {
        P collection = creator.get();
        for (T element : list)
            collector.accept(element, collection);
        return collection;
    }

}