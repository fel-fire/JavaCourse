package edu.baykov.student;

import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.Objects;

/**
 * <p>Класс <b>Student</b> представляет реализацию студента,
 * который описывается следующим образом:
 * <p>•Имя: строка</p>
 * <p>•Множество оценок: целые числа</p>
 * <p>•Правило, определения корректности оценок студента</p></p>
 * @author Nikolay Baykov
 */
public class Student {
    @Getter
    private String name;
    private ArrayList<Integer> marks;
    @Getter
    private Rule rule;

    public Student(@NonNull String name, Rule rule, @NonNull int... marks) {
        this.name = name;
        this.rule = rule;
        this.marks = new ArrayList<>(marks.length);
        addValidMark(marks);
    }

    public Student(@NonNull String name, @NonNull int... marks) {
        this(name, null, marks);
    }

    public Student(Student student) {
        this(student.name, student.rule);
        this.marks = new ArrayList<>(student.getMarks());
    }

    private void addValidMark  (int[] marks) {
        for (int mark : marks) {
            if (rule != null && !rule.check(mark))
                throw new InvalidMarksValueException(name);
            this.marks.add(mark);
        }
    }

    public void addMark(@NonNull int... marks){
        addValidMark(marks);
    }

    public ArrayList<Integer> getMarks() {
        return new ArrayList<>(marks);
    }

    @Override
    public String toString() {
        return name + ": " + marks;
    }

    public double averageMark() {
        int sum = 0;
        if (marks.isEmpty()) return sum;
        for (int mark : marks) sum += mark;
        int result = (int) (((double) sum / marks.size())*100);
        return (double) result /100;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(averageMark(), student.averageMark()) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return (int) (averageMark()*100) + Objects.hashCode(name);
    }

    //    /** ПОКА НЕ АКТУАЛЕН ВВИДУ РАЗНООБРАЗИЯ Rule
//     * Метод, проверяющий, является ли студент отличником.
//     *
//     * @return true, если средняя оценка студента равна 5.0, в противном случае false.
//     */

//    public boolean isExcellent() {
//        return avgMark() == 5.0;
//    }


}
