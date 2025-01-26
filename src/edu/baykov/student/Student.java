package edu.baykov.student;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;

/**
 * <p>Класс <b>Student</b> представляет реализацию студента,
 * который описывается следующим образом:
 * <p>•Имя: строка</p>
 * <p>•Множество оценок: целые числа</p>
 * <p>•Правило, определения корректности оценок студента</p></p>
 * <p>
 *
 * @author Nikolay Baykov
 * @version 1.0
 * @since 04-01-2025
 */
public class Student {
    /**
     * Имя.
     */
    @Getter
    private String name;
    /**
     * Список оценок.
     */
    private ArrayList<Integer> marks;
    /**
     * Правило
     */
    @Getter
    private Rule rule;


    /**
     * Конструирует объект студент из имени и множества оценок в диапазоне, соответствующем заданному правилу {@code rule}
     *
     * @param name  имя.
     * @param rule правило соответствия оценок.
     * @param marks множество оценок.
     * @throws IllegalArgumentException если какая-либо из оценок не входи в диапазон от 2 до 5.
     */
    public Student(@NonNull String name, Rule rule, @NonNull int... marks) {
        this.name = name;
        this.rule = rule;
        this.marks = new ArrayList<>(marks.length);
        addValidMark(marks);

    }

    /**
     * Конструирует объект студента и множества оценок. При этом правило соответствия оценок {@code Rule}
     * не используется и принимает значение {@code null}
     * @param name имя.
     * @param marks множество
     */
    public Student(@NonNull String name, @NonNull int... marks) {
        this(name, null, marks);
    }

    public Student(Student student) {
        this(student.name, student.rule);
        this.marks = new ArrayList<>(student.getMarks());
    }

    /**
     * Служебный метод, проверяющий соответствие добавляемых оценок правилу {@code Rule}
     * @param marks добавляемые оценки.
     */
    private void addValidMark  (int[] marks) {
        for (int mark : marks) {
            if (rule != null && !rule.check(mark))
                throw new InvalidMarksValueException(name);
            this.marks.add(mark);
        }
    }

    /**
     * Метод, добавляющий оценки студенту.
     * @param marks множество оценок.
     */
    public void addMark(@NonNull int... marks){
        addValidMark(marks);
    }

    /**
     * Геттер - возвращает список оценок
     *
     * @return список оценок ученика.
     */
    public ArrayList<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    /**
     * Метод, возвращающий строковое представление объекта.
     *
     * @return строковое представление объекта Square в виде: "Имя: оценки..."
     */
    @Override
    public String toString() {
        return name + ": " + marks;
    }

    /**
     * Метод, вычисляющий среднюю оценку студента.
     *
     * @return среднее значение (double)
     */
    public double avgMark() {
        if (marks.isEmpty()) return 0;
        int sum = 0;
        for (int mark : marks) sum += mark;
        return (double) sum / marks.size();
    }

    /**
     * Метод, проверяющий, является ли студент отличником.
     *
     * @return true, если средняя оценка студента равна 5.0, в противном случае false.
     */
    public boolean isExcellent() {
        return avgMark() == 5.0;
    }


}
