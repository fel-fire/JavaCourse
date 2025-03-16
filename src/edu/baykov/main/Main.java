package edu.baykov.main;

import edu.baykov.geometry.Line;
import edu.baykov.geometry.Point;
import edu.baykov.geometry.Point3D;
import edu.baykov.geometry.Polyline;
import edu.baykov.network.Connection;
import edu.baykov.network.LostConnectionException;
import edu.baykov.oop.*;
import edu.baykov.student.InvalidMarksValueException;
import edu.baykov.student.Student;


import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * В указанном классе {@code Main} располагаются решения задач из разделов задачника, которые необходимо было выполнить
 * в виде разработки нового метода.
 *
 * @author Nikolay Baykov
 */


public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        //Задачи из раздела 6.3 для тех, кому домашнего задания показалось мало
        //6.3.1 map()
        List<Integer> result6_3_1_1 = Stream.of("qwerty", "asdfg", "zx")
                .map(String::length)
                .toList();
        System.out.println("values length: " + result6_3_1_1);

        List<Integer> result6_3_1_2 = Stream.of(1, -3, 7)
                .map(x -> x < 0? x*(-1) : x)
                .toList();
        System.out.println("values to positive: " + result6_3_1_2);

        List<Integer> result6_3_1_3 = Stream.of(new int[] {1, 2, 3}, new int[] {4, 5, 6}, new int[] {7, 8, 3})
                .map(x -> Arrays.stream(x).max().orElse(0))
                .toList();
        System.out.println("maximum from subarrays: " + result6_3_1_3);

        //6.3.2 filter()
        List<String> result6_3_2_1 = Stream.of("qwerty", "asdfg", "zx")
                .filter(x -> x.length() < 3)
                .toList();
        System.out.println("values with length < 3: " + result6_3_2_1);

        List<Integer> result6_3_2_2 = Stream.of(1, -3, 7)
                .filter(x -> x < 0)
                .toList();
        System.out.println("only negatives: " + result6_3_2_2);

        List<Integer[]> result6_3_2_3 = Stream.of(new Integer[] {1, 2, 3}, new Integer[] {-4, -5, -6}, new Integer[] {7, -8, 3})
                .filter(x -> Arrays.stream(x).allMatch(y -> y <= 0))
                .toList();
        System.out.print("arrays without negative values: ");
        result6_3_2_3.forEach((x) -> System.out.print(Arrays.toString(x) + " ") );
        System.out.println();

        //6.3.3 reduce
        String result6_3_3_1 = Stream.of("qwerty", "asdfg", "zx").reduce("", (x, y) -> x + y);
        System.out.println("values concatenation: " + result6_3_3_1);

        Integer result6_3_3_2 = Stream.of(1, -3, 7)
                .reduce(0, Integer::sum);
        System.out.println("sum of values: " + result6_3_3_2);

        int result6_3_3_3 = Stream.of(List.of(1, 2, 3), List.of(1, 2, 3), List.of(1, 2, 3))
                .flatMap(List::stream)
                .reduce(0, (x, y) -> x + 1);
        System.out.println("count of values: " + result6_3_3_3);

        //6.3.4 collect
        Map<Boolean, List<Integer>> result6_3_4_1 = Stream.of(1, -3, 7)
                .collect(Collectors.partitioningBy(x -> x >= 0));
        List<Integer> positive = result6_3_4_1.get(true);
        List<Integer> negative = result6_3_4_1.get(false);
        System.out.print("list with positive values: " + positive + " ");
        System.out.println("list with negative values: " + negative);

        Map<Integer, List<String>> result6_3_4_2 = Stream.of("qwerty", "asdfg", "zx", "qw")
                .collect(Collectors.toMap(String::length, x -> new ArrayList<>(List.of(x)), (x, y) -> {x.addAll(y); return x;}));
        System.out.println("sublists with same length words : " + result6_3_4_2);

        Set<String> result6_3_4_3 = Stream.of("qwerty", "asdfg", "zx", "qwerty")
                .collect(Collectors.toSet());
        System.out.println("set with unique words : " + result6_3_4_3);

        // и все равно мало...
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

    /* Stream API Задание 1 (тест находится в MainTest):
    Написать следующую стриму: дан набор объектов типа Point,
    необходимо взять все Point в разных координатах, (убрать с
    одинаковыми X,Y),отсортировать по X, отрицательные Y сделать
    положительными и собрать это все в ломаную (объект типа Polyline)*/

    public static Polyline streamMethodTask1(List<Point> points) {

        return Optional.ofNullable(points).orElse(Collections.emptyList()).stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparingInt(Point::getX))
                .peek(x -> x.setY(Math.abs(x.getY())))
                .distinct()
                .collect(Polyline::new, Polyline::addPoint, (l1, l2) -> l1.addPoint(l2.getPoints().toArray(new Point[0])));
    }

   /* Stream API Задание 2 (тест находится в MainTest):
    Дан текстовый файл с строками содержащими имя человека и его номер в следующей форме:
    Вася:5
    Петя:3
    Аня:5
    Номера людей могут повторяться.
    У каких-то людей может не быть номера. Необходимо написать стриму выполняющую следующее:
    читаются все люди из файла, все имена приводится к нижнему регистру, но с первой буквой в верхнем регистре,
    убираем из перечня всех людей без номеров, а имена оставшихся группируются по их номеру:
            [5:[Вася, Аня], 3:[Петя]]*/

    public static Map<String, List<String>> streamMethodTask2(String filename) throws FileNotFoundException {

        return new BufferedReader(new FileReader(filename)).lines()
                .map(x -> (x.substring(0, 1).toUpperCase() + x.substring(1).toLowerCase()).split(":"))
                .filter(x -> x.length == 2)
                .collect(Collectors.toMap(x -> x[1], x -> new ArrayList<>(List.of(x[0])), (x, y) -> {x.addAll(y); return x;}));

                // как вариант можно попробовать сделать вот так
                //.collect(Collectors.groupingBy(x -> x[1], Collectors.mapping(x -> x[0], Collectors.toList())));
    }

}