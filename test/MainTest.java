import edu.baykov.geometry.AbstractPoint;
import edu.baykov.geometry.Line;
import edu.baykov.geometry.Point;
import edu.baykov.geometry.Point3D;
import edu.baykov.main.Main;
import edu.baykov.oop.Box;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import static edu.baykov.main.Main.collect;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MainTest {

    @Test
        //6.2.1 Сдвинуть линию.
    void move() {
        Line<Point3D> line1 = Line.of(new Point3D(5, 2, 2), new Point3D(3, 3, 3));
        Line<Point3D> line2 = Line.of(new Point3D(-7, 2, 2), new Point3D(3, 3, 3));

        Main.move(line1);
        Main.move(line2);

        assertEquals(15, line1.getStart().getX());
        assertEquals(-17, line2.getStart().getX());
    }

    @Test
        //6.2.2 Поиск максимума.
    void maximum() {
        Box<Integer> integerBox = new Box<>();
        integerBox.setObj(15);
        Box<Double> doubleBox = new Box<>();
        doubleBox.setObj(17d);

        assertEquals(17, Main.maximum(integerBox, doubleBox));
    }

    @Test
        //6.2.3 Начало отсчета.
    void putPointInBox() {
        Box<Point3D> point3DBox = new Box<>();
        Box<AbstractPoint> abstractPointBox = new Box<>();
        Box<Object> objecttBox = new Box<>();

        Main.putPointInBox(point3DBox);
        Main.putPointInBox(abstractPointBox);
        Main.putPointInBox(objecttBox);

        assertFalse(point3DBox.isEmpty());
        assertFalse(abstractPointBox.isEmpty());
        assertFalse(objecttBox.isEmpty());
    }

    @Test
        //6.2.4 Заполнение списка.
    void fill() {
        ArrayList<Integer> ints = new ArrayList<>();
        ArrayList<Number> numbers = new ArrayList<>();
        ArrayList<Object> objects = new ArrayList<>();

        Main.fill(ints);
        Main.fill(numbers);
        Main.fill(objects);

        assertEquals(100, ints.size());
        assertEquals(100, numbers.size());
        assertEquals(100, objects.size());
    }

    @Test
        //6.3.1 Функция. - (1)
    void processFromStringToInteger() {
        List<String> str = new ArrayList<>(List.of("qwerty", "asdf", "zx"));

        List<Integer> result = Main.process(str, String::length);

        assertEquals(6, result.get(0));
        assertEquals(4, result.get(1));
        assertEquals(2, result.get(2));
    }

    @Test
        //6.3.1 Функция. - (2)
    void processFromNegativeIntToPositiveInt() {
        List<Integer> ints = new ArrayList<>(List.of(1, -3, 7));

        List<Integer> result = Main.process(ints, Math::abs);

        assertEquals(1, result.get(0));
        assertEquals(3, result.get(1));
        assertEquals(7, result.get(2));
    }

    @Test
        //6.3.1 Функция. - (3)
    void processFromArraysToMaximumValuesOfArrays() {
        List<Integer[]> intArrays = new ArrayList<>();
        intArrays.add(new Integer[]{1, 2, 30, 4, 5});
        intArrays.add(new Integer[]{10, 200, 30, 40, 50});
        intArrays.add(new Integer[]{1000, 200, 300, 400, 500});

        List<Integer> result = Main.process(intArrays, element -> Collections.max(Arrays.asList(element)));

        assertEquals(30, result.get(0));
        assertEquals(200, result.get(1));
        assertEquals(1000, result.get(2));
    }

    @Test
        //6.3.2 Фильтр. - (1)
    void filterToStringsWhichHaveLengthLessThan3() {
        List<String> str = new ArrayList<>(List.of("qwerty", "asdf", "zx"));

        List<String> result = Main.filter(str, element -> element.length() >= 3);

        assertEquals(6, result.get(0).length());
        assertEquals(4, result.get(1).length());
        assertEquals(2, result.size());

    }

    @Test
        //6.3.2 Фильтр. - (2)
    void filterToPositiveNumbers() {
        List<Integer> ints = new ArrayList<>(List.of(1, -3, 7));

        List<Integer> result = Main.filter(ints, element -> element > 0);

        assertEquals(1, result.get(0));
        assertEquals(7, result.get(1));
        assertEquals(2, result.size());

    }

    @Test
        //6.3.2 Фильтр. - (3)
    void filterToArraysWithoutNegativeNumbers() {
        List<Integer[]> intArrays = new ArrayList<>();
        intArrays.add(new Integer[]{1, 2, 30, 4, 5});
        intArrays.add(new Integer[]{10, -200, 30, 40, 50});
        intArrays.add(new Integer[]{1000, 200, 300, -400, 500});

        List<Integer[]> result = Main.filter(intArrays, element -> Collections.min(Arrays.asList(element)) >= 0);

        assertEquals(1, result.size());

    }

    @Test
        //6.3.3. Сокращение - (1)
    void reduceStrings() {
        List<String> str = new ArrayList<>(List.of("qwerty", "asdf", "zx"));

        String text = Main.reduce(str, "", String::concat);

        assertEquals("qwertyasdfzx", text);
    }

    @Test
        //6.3.3. Сокращение - (2)
    void reduceIntegers() {
        List<Integer> ints = new ArrayList<>(List.of(1, -3, 7));

        Integer sum = Main.reduce(ints, 0, Integer::sum);

        assertEquals(5, sum);
    }

    @Test
        //6.3.3. Сокращение - (3)
    void reduceListOfLists() {

        List<Integer> subList1 = new ArrayList<>(List.of(1, 2, 30, 4, 5));
        List<Integer> subList2 = new ArrayList<>(List.of(10, -200, 56, 30, 40, 50));
        List<Integer> subList3 = new ArrayList<>(List.of(1000, 200, 300, -400, 500));
        List<List<Integer>> superList = new ArrayList<>(List.of(subList1, subList2, subList3));

        //Вариант 1
        Integer quantityOfElements1 = Main.reduce(Main.process(superList, List::size), 0, Integer::sum);


        //Вариант 2
        Integer quantityOfElements2 = Main.reduce(superList, new ArrayList<>(List.of(0)),
                (result, element) -> {
                    result.set(0, result.getFirst() + element.size());
                    return result;
                }).getFirst();


        assertEquals(16, quantityOfElements1);
        assertEquals(16, quantityOfElements2);
    }

    @Test
        //6.3.4. Коллекционирование - (1)
    void collectFromIntegerListToNegativeListAndPositiveList() {

        List<Integer> integers =  new ArrayList<>(List.of(1, -3, 7));

        List<List<Integer>> superList = collect(integers, (Supplier<List<List<Integer>>>) ArrayList::new, MainTest::addPositiveOrNegativeInSublist);

        System.out.println(superList);

        assertEquals(2, superList.size());
    }

    private static void addPositiveOrNegativeInSublist(Integer value, List<List<Integer>> dest) {
        if (dest.isEmpty()) {
            List<Integer> positiveAndZeroIntsList = new ArrayList<>();
            List<Integer> negativeIntsList = new ArrayList<>();
            dest.add(0, positiveAndZeroIntsList);
            dest.add(1, negativeIntsList);
        }
        int index = value < 0 ? 1 : 0;
        dest.get(index).add(value);
    }

    @Test
        //6.3.4 Коллекционирование - 2
    void collectFromStringListToEqualLinesLengthList() {

        ArrayList<String> str1 = new ArrayList<>(List.of("qwerty", "asdfg", "zx", "qw"));

        List<List<String>> superList = collect(str1, ArrayList::new, MainTest::addWithSameLengthToSublist);

        System.out.println(superList);

        assertEquals(3, superList.size());
    }

    private static void addWithSameLengthToSublist(String value, List<List<String>> dest) {
        List<String> stringListBuffer = new ArrayList<>();
        stringListBuffer.add(value);

        if (dest.isEmpty()) {
            dest.add(stringListBuffer);
            return;
        }

        for (List<String> sublist : dest) {
            if (sublist.isEmpty() || sublist.getFirst().length() == value.length()) {
                sublist.add(value);
                stringListBuffer.clear();
            }
        }
        if (!stringListBuffer.isEmpty()) {
            dest.add(stringListBuffer);
        }
    }

    @Test
        //6.3.4 Коллекционирование - 3
    void collectFromStringListToUniqueStringList() {

        List<String> str = new ArrayList<>(List.of("qwerty", "asdfg", "qwerty", "qw"));

        Set<String> set = collect(str, HashSet::new, (BiConsumer<String, Set<String>>) (src, dest) -> dest.add(src));

        assertEquals(3, set.size());
    }

}
