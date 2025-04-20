package edu.baykov.spring;

/**
 * Интерфейс для Построителя студентов из задачи 9.2.4.
 */

public interface StudentBuilder {
    StudentBuilder name(String name);
    StudentBuilder marks(int... marks);
    StudentSpring build();
}
