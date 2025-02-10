import edu.baykov.geometry.Line;
import edu.baykov.geometry.Point;
import edu.baykov.geometry.Point3D;
import edu.baykov.main.Main;
import edu.baykov.oop.Box;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static edu.baykov.main.Main.collect;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class MainTest {

    @Test
        //6.2.1 Сдвинуть линию.
    void move() {
        Line<Point3D> line1 = new Line<>(new Point3D(5, 2, 2), new Point3D(3, 3, 3));
        Main.move(line1);
        Line<Point3D> line2 = new Line<>(new Point3D(-7, 2, 2), new Point3D(3, 3, 3));
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
        Main.putPointInBox(point3DBox);
        Box<Point> pointBox = new Box<>();
        Main.putPointInBox(pointBox);
        Box<Object> objecttBox = new Box<>();
        Main.putPointInBox(objecttBox);

        assertFalse(point3DBox.isEmpty());
        assertFalse(pointBox.isEmpty());
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
        ArrayList<String> str = new ArrayList<>();
        str.add("qwerty");
        str.add("asdf");
        str.add("zx");

        ArrayList<?> result = Main.process(str, new Main.Applier<String, Integer>() {

                    @Override
                    public Integer apply(String element) {
                        return element.length();
                    }
                }
        );
        assertEquals(6, result.get(0));
        assertEquals(4, result.get(1));
        assertEquals(2, result.get(2));
    }

    @Test
        //6.3.1 Функция. - (2)
    void processFromNegativeIntToPositiveInt() {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(-3);
        ints.add(7);
        ArrayList<?> result = Main.process(ints, new Main.Applier<Integer, Integer>() {

                    @Override
                    public Integer apply(Integer element) {
                        return Math.abs(element);
                    }
                }
        );
        assertEquals(1, result.get(0));
        assertEquals(3, result.get(1));
        assertEquals(7, result.get(2));
    }

    @Test
        //6.3.1 Функция. - (3)
    void processFromArraysToMaximumValuesOfArrays() {
        ArrayList<Integer[]> intArrays = new ArrayList<>();
        intArrays.add(new Integer[]{1, 2, 30, 4, 5});
        intArrays.add(new Integer[]{10, 200, 30, 40, 50});
        intArrays.add(new Integer[]{1000, 200, 300, 400, 500});
        ArrayList<?> result = Main.process(intArrays, new Main.Applier<Integer[], Integer>() {

                    @Override
                    public Integer apply(Integer[] element) {
                        int maxValue = 0;
                        for (int e : element) {
                            maxValue = Math.max(e, maxValue);
                        }
                        return maxValue;
                    }
                }
        );
        assertEquals(30, result.get(0));
        assertEquals(200, result.get(1));
        assertEquals(1000, result.get(2));
    }

    @Test //6.3.2 Фильтр. - (1)
    void filterToStringsWhichHaveLengthLessThan3() {
        ArrayList<String> str = new ArrayList<>();
        str.add("qwerty");
        str.add("asdf");
        str.add("zx");

        ArrayList<String> result = Main.filter(str, element -> element.length() >= 3);

        assertEquals(6, result.get(0).length());
        assertEquals(4, result.get(1).length());
        assertEquals(2, result.size());

    }

    @Test //6.3.2 Фильтр. - (2)
    void filterToPositiveNumbers() {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(-3);
        ints.add(7);

        ArrayList<Integer> result = Main.filter(ints, element -> element > 0);

        assertEquals(1, result.get(0));
        assertEquals(7, result.get(1));
        assertEquals(2, result.size());

    }

    @Test //6.3.2 Фильтр. - (3)
    void filterToArraysWithoutNegativeNumbers() {
        ArrayList<Integer[]> intArrays = new ArrayList<>();
        intArrays.add(new Integer[]{1, 2, 30, 4, 5});
        intArrays.add(new Integer[]{10, -200, 30, 40, 50});
        intArrays.add(new Integer[]{1000, 200, 300, -400, 500});

        ArrayList<Integer[]> result = Main.filter(intArrays, element -> {
            for (int e : element) {
                if (e < 0) return false;
            }
            return true;
        });

        assertEquals(1, result.size());

    }

    @Test //6.3.3. Сокращение - (1)
    void reduceStrings() {
        ArrayList<String> str = new ArrayList<>();
        str.add("qwerty");
        str.add("asdf");
        str.add("zx");
        String text = Main.reduce(str, "", (result, element) -> result + element);

        assertEquals("qwertyasdfzx", text);
    }

    @Test //6.3.3. Сокращение - (2)
    void reduceIntegers() {
        ArrayList<Integer> ints = new ArrayList<>();
        ints.add(1);
        ints.add(-3);
        ints.add(7);
        Integer sum = Main.reduce(ints, 0, (result, element) -> result + element);

        assertEquals(5, sum);
    }

    @Test //6.3.3. Сокращение - (3)
    void reduceListOfLists() {
        ArrayList<ArrayList<Integer>> superList = new ArrayList<>();
        ArrayList<Integer> subList1 = new ArrayList<>(List.of(1, 2, 30, 4, 5));
        ArrayList<Integer> subList2 = new ArrayList<>(List.of(10, -200, 56, 30, 40, 50));
        ArrayList<Integer> subList3 = new ArrayList<>(List.of(1000, 200, 300, -400, 500));
        superList.add(subList1);
        superList.add(subList2);
        superList.add(subList3);


        //Вариант 1
        Integer quantityOfElements1 = 0;
        for (ArrayList<Integer> list : superList) {
            quantityOfElements1 += Main.reduce(list, 0, (result, element) -> result+1);
        }
        //Вариант 2
        Integer quantityOfElements2 = Main.reduce(superList, new ArrayList<>(List.of(0)),
                (result, element) -> {
                    result.set(0, result.get(0) + element.size());
                    return result;
                }).getFirst();


        assertEquals(16, quantityOfElements1);
        assertEquals(16, quantityOfElements2);
    }

    @Test //6.3.4. Коллекционирование - (1)
    void collectFromIntegerListToNegativeListAndPositiveList() {

        ArrayList<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(-3);
        integers.add(7);

        ArrayList<ArrayList<Integer>> superList = collect(integers, new Main.Creator<ArrayList<ArrayList<Integer>>>() {
            @Override
            public ArrayList<ArrayList<Integer>> create() {
                return new ArrayList<>();
            }
        }, new Main.Collector<List<Integer>, ArrayList<ArrayList<Integer>>>() {
            @Override
            public void make(List<Integer> src, ArrayList<ArrayList<Integer>> dest) {
                ArrayList<Integer> positiveAndZeroIntsList = new ArrayList<>();
                ArrayList<Integer> negativeIntsList = new ArrayList<>();
                for (int i : src) {
                    if (i < 0) negativeIntsList.add(i);
                    else positiveAndZeroIntsList.add(i);
                }
                dest.add(positiveAndZeroIntsList);
                dest.add(negativeIntsList);
            }
        });

        System.out.println(superList);

        assertEquals(2, superList.size());
    }

    @Test //6.3.4 Коллекционирование - 2
    void collectFromStringListToEqualLinesLengthList() {

        ArrayList<String> str1 = new ArrayList<>();
        str1.add("qwerty");
        str1.add("asdfg");
        str1.add("zx");
        str1.add("qw");

        ArrayList<ArrayList<String>> superList = collect(str1, () -> new ArrayList<>(), new Main.Collector<List<String>, ArrayList<ArrayList<String>>>() {
            @Override
            public void make(List<String> src, ArrayList<ArrayList<String>> dest) {
                for (String s : src) {
                    ArrayList<String> stringListBuffer = new ArrayList<>();
                    stringListBuffer.add(s);

                    if (dest.isEmpty()) {
                        dest.add(stringListBuffer);
                        continue;
                    }

                    for (ArrayList<String> sublist : dest) {
                        if (sublist.isEmpty() || sublist.getFirst().length() == s.length()) {
                            sublist.add(s);
                            stringListBuffer.clear();
                            break;
                        }
                    }
                    if (!stringListBuffer.isEmpty()) {
                        dest.add(stringListBuffer);
                    }
                }
            }
        });
        System.out.println(superList);

        assertEquals(3, superList.size());
    }

    @Test //6.3.4 Коллекционирование - 3
    void collectFromStringListToUniqueStringList() {

        ArrayList<String> str = new ArrayList<>();
        str.add("qwerty");
        str.add("asdfg");
        str.add("qwerty");
        str.add("qw");

        Set<String> set = collect(str, () -> new HashSet<>(), (Main.Collector<List<String>, Set<String>>) (src, dest) -> dest.addAll(src));

        System.out.println(set);

        assertEquals(3, set.size());
    }

}
