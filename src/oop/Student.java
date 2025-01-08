package oop;

import lombok.Getter;
import java.util.ArrayList;

/**
 * <p>Класс <b>Student</b> представляет реализацию студента,
 * который описывается следующим образом:
 * <p>•Имя: строка</p>
 * <p>•Множество оценок: целые числа</p></p>
 * <p>
 * @author   Nikolay Baykov
 * @version  1.0
 * @since    04-01-2025
 */
public class Student {
    /**
     * Имя.
     */
    private String name;
    /**
     * Список оценок.
     */
    @Getter
    private ArrayList<Integer> marks;

    /**
     * Конструирует объект студент из имени и множества оценок в диапазоне от 2 до 5.
     * @param name имя.
     * @param marks множество оценок.
     * @throws IllegalArgumentException если какая-либо из оценок не входи в диапазон от 2 до 5.
     */
    public Student(String name, int... marks) {
        this.marks = new ArrayList<>(marks.length);
        for (int mark : marks) {
            if (mark < 2 || mark > 5) throw new IllegalArgumentException("Оценки должны быть от 2 до 5");
            this.marks.add(mark);
        }
        this.name = name;

    }

    /**
     * Метод, возвращающий строковое представление объекта.
     * @return строковое представление объекта Square в виде: "Имя: оценки..."
     */
    @Override
    public String toString() {
        return name + ": " + marks;
    }

    /**
     * Метод, вычисляющий среднюю оценку студента.
     * @return среднее значение (double)
     */
    public double avgMark() {
        if (marks.isEmpty()) return 0;
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum /marks.size();
    }

    /**
     * Метод, проверяющий, является ли студент отличником.
     * @return true, если средняя оценка студента равна 5.0, в противном случае false.
     */
    public boolean isExcellent() {
        return avgMark() == 5.0;
    }


}
