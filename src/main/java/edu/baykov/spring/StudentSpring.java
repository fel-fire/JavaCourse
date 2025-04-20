package edu.baykov.spring;

import edu.baykov.student.InvalidMarksValueException;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.function.Predicate;

/** 9.2.4 Студенты. В качестве критерия правильности оценки передается значение бина range из задачи 9.1.4
 * <p>Класс <b>Student</b> представляет реализацию студента,
 * который описывается следующим образом:
 * <p>•Имя: строка</p>
 * <p>•Множество оценок: целые числа</p>
 * <p>•Правило, определения корректности оценок студента</p></p>
 * @author Nikolay Baykov
 */
@Component
@Scope("prototype")
public class StudentSpring implements Comparable<StudentSpring> {
    @Setter
    @Getter
    private String name;
    private ArrayList<Integer> marks;
    @Getter
    private Predicate<Integer> rule;

    @Autowired
    public StudentSpring() {
    }

    public StudentSpring(StudentSpring student) {
        this();
        this.setName(student.name);
        this.setRule(student.rule);
        this.marks = new ArrayList<>(student.getMarks());
    }

    private StudentSpring(Builder builder) {
        this.name = builder.name;
    }

    /**
     * 9.2.5 Создание студентов. Создайте бин типа ПостроительСтудентов.
     * Данная сущность имеет метод порождения объектов типа Студент.
     * Для порождения обязательно указание имени и опционально указание списка оценок.
     * Гарантируйте, что у всех порожденных студентов будет один и тот же критерий корректности оценок,
     * причем задается он бином range из задачи 9.1.4.
     */

    @Component
    public static class Builder implements StudentBuilder {
        StudentSpring student;

        @Autowired
        public Builder(StudentSpring student) {
            this.student = student;
        }

        private String name;
        private int[] marks;

        @Override
        public StudentBuilder name(String name) {
            this.name = name;
            return this;
        }
        @Override
        public StudentBuilder marks(@NonNull int... marks) {
            this.marks = marks;
            return this;
        }

        public StudentSpring build() {
            if (name==null) throw new IllegalArgumentException("You must enter a name of a student.");
            student.setName(name);
            student.addMarks(marks);
            return student;
        }

        @Override
        public String toString() {
            return "StudentBuilder{" +
                    "name='" + name + '\'' +
                    ", marks=" + Arrays.toString(marks) +
                    '}';
        }
    }

/**
* Продолжение класса Student ...
*/
    @Autowired
    public void setRule(@Qualifier("2to5") Predicate<Integer> rule) {
        this.rule = rule;
    }

    public void addMarks(@NonNull int... marks) {
        this.marks = new ArrayList<>(marks.length);
        addValidMark(marks);
    }

    private void addValidMark  (int[] marks) {
        for (int mark : marks) {
            if (!rule.test(mark))
                throw new InvalidMarksValueException(name + " has invalid marks.");
            this.marks.add(mark);
        }
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
        StudentSpring student = (StudentSpring) o;
        return Objects.equals(averageMark(), student.averageMark()) && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return (int) (averageMark()*100) + Objects.hashCode(name);
    }


    @Override
    public int compareTo(StudentSpring obj) {
        return Double.compare(averageMark(), obj.averageMark());
    }
}

