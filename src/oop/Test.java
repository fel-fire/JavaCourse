package oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        //test_1_5_1();
        //test_1_5_2();
        //test_1_5_3();
        //test_1_5_4();
        //test_1_5_5();
        //test_1_5_6();
        //test_1_5_7();
        //test_1_5_8();
        //test_1_6_1();
        //test_1_6_2();
        //test_1_6_3();
        //test_1_6_4();
        //test_1_6_5();
        //test_1_6_6();
        //test_1_6_8();
        //test_1_6_9();
        test_1_6_10();

    }

    // 1.5.1. Создайте пистолет с тремя патронами и выстрелите из него пять раз.
    public static void test_1_5_1() {
        Handgun gun = new Handgun(10,10);
        for (int i = 0; i < 5; i ++) {
            gun.shoot();
        }
    }
    // 1.5.2. Создайте кота по имени “Барсик”, и затем пусть он помяукает сначала один раз, а затем три раза.
    public static void test_1_5_2() {
        Cat cat = new Cat("");
        cat.meow();
        cat.meow(3);
    }
    // 1.5.3. Создайте линию из точки {1;1} в точку {10;15} и выведите на экран её длину.
    public static void test_1_5_3() {
        Line line = new Line(1, 1, 10, 15);
        System.out.println(line.length());
    }

    /*     1.5.4 Добавьте Человеку следующие возможности: возвращать Личное имя, возвращать Отчество, возвращать Фамилию.
     Измените метод приведения Человека к строковой форме так, чтобы значение фамилии выбиралось с использованием указанного выше поведения.*/
    public static void test_1_5_4() {
        Name name = new Name("Иван", "Козлов", "Петрович");
        Human grandGrandFather = new Human(name);
        Human grandFather = new Human("Валентин", grandGrandFather);
        Human father = new Human("Игорь", grandFather);
        Human son = new Human("Евгений", father);

        System.out.println(grandGrandFather);
        System.out.println(grandFather);
        System.out.println(father);
        System.out.println(son);
    }

    /*1.5.5. необходимо выполнить следующие задачи:
    1.	Создать несколько экземпляров дробей.
    2.	Написать по одному примеру использования каждого метода.
    3.	Вывести на экран примеры и результаты их выполнения в формате «1/3 * 2/3 = 2/9»
    4.	Посчитать f1.sum(f2).div(f3).minus(5)*/
    private static void test_1_5_5() {
        Fraction fraction1 = new Fraction(1, 2);
        Fraction fraction2 = new Fraction(2, 3);
        Fraction fraction3 = new Fraction(3, 4);
        System.out.println(fraction1.sum(fraction2));
        System.out.println(fraction1.substract(fraction2));
        System.out.println(fraction1.divide(fraction2));
        System.out.println(fraction1.multiple(fraction2));
        System.out.println(fraction1.sum(fraction2).divide(fraction3).substract(5));
    }

    /*     1.5.6. Необходимо выполнить следующие задачи:
          1.	Создайте студента Васю с оценками 3,4,5,4
          2.	Создайте студента Петю с оценками 5,5,5,5
          3.	Выведите для обоих студентов информацию о среднем балле и являются ли они отличниками*/
    public static void test_1_5_6() {
        Student student1 = new Student("Vasya", 3, 4, 5, 4);
        Student student2 = new Student("Petya", 5, 5, 5, 5);
        System.out.println(student1.avgMark());
        System.out.println(student2.avgMark());
        System.out.println(student1.isExcellent());
        System.out.println(student2.isExcellent());
    }

    /*    1.5.7 Длина Ломаной. Необходимо выполнить следующие задачи:
      1.	Создать Ломаную, проходящую через точки {1;5}, {2;8}, {5;3}
      2.	Вывести на экран её длину
      3.	Добавить (к ранее созданной Ломаной) точки {5;15}, {8;10}
      4.	Снова вывести на экран длину Ломаной*/
    public static void test_1_5_7() {
        Point point1 = new Point(1, 5);
        Point point2 = new Point(2, 8);
        Point point3 = new Point(5, 3);
        Polyline polyline = new Polyline(point1, point2, point3);
        System.out.println(polyline.length());
        polyline.addPoint(new Point(5, 15));
        polyline.addPoint(new Point(8, 10));
        System.out.println(polyline.length());
    }

    /* 1.5.8. Необходимо выполнить следующие задачи:
            1.	Создайте Квадрат в точке {5;3} со стороной 23
            2.	Присвойте в ссылку типа Ломаная результат вызова метода получения Ломаной у ранее созданного квадрата
            3.	Выведите на экран общую длину полученной Ломаной
            4.	Сдвиньте последнюю Точку Ломаной в позицию {15,25}
            5.	Снова выведите на экран длину Ломаной*/

    public static void test_1_5_8() {
        Square square = new Square(5, 3, 23);
        Polyline polyline = square.asPolyline();
        System.out.println(square);
        System.out.println(polyline);
        System.out.println(polyline.length());
        polyline.setPointValue(15, 25, polyline.pointQuantity());
        System.out.println(polyline);
        System.out.println(polyline.length());
    }

    /*1.6.1 Гарантируйте, что у дома всегда будет положительное количество этажей. В случае попытки указать отрицательное
    количество этажей должна выбрасываться соответствующая ошибка.
    Продемонстрируйте работоспособность решения на примерах.*/
    public static void test_1_6_1() {
        //House house1 = new House(-1);
        House house2 = new House(5);
        System.out.println(house2);
    }

    /*1.6.2 Гарантируйте, что:
            •	Как минимум один параметр будет иметь не null значение и не пустую строку.
            •	Имя неизменяемо.
    Продемонстрируйте работоспособность решения на примерах.*/
    public static void test_1_6_2() {
//        Name name1 = new Name(null);
//        Name name2 = new Name("");
//        System.out.println(name1);
//        System.out.println(name2);

    }

    /*1.6.3 Гарантируйте, что Квадрату невозможно задать отрицательное значение длины стороны.
    При попытке задать сторону равной нулю или менее, выбрасывается ошибка с соответствующим текстом.
    Контроль должен осуществляться как во время создания объекта, так и позднее, в случае если будет необходимо
    менять размеры Квадрата. Необходимо предоставить возможность изменения длины стороны Квадрата и возможность
    узнать размер стороны. Продемонстрируйте работоспособность решения на примерах.*/
    public static void test_1_6_3() {
        //Square square = new Square(0, 0, -1);
        Square square1 = new Square(0, 0, 5);
        square1.setSideLength(10);
        //square1.setSideLength(-5);
        System.out.println(square1.getSideLength());
    }

    /*1.6.4 Реализуйте следующие требования:
        •	Дробь не может быть изменена после создания
        •	Необходимо корректно обрабатывать отрицательные значения. Учтите, что знаменатель не может быть отрицательным.
Продемонстрируйте работоспособность решения на примерах.*/
    private static void test_1_6_4() {
        Fraction fraction1 = new Fraction(1, -2);
        Fraction fraction2 = new Fraction(-2, 3);
        Fraction fraction3 = new Fraction(-3, -4);
        System.out.println(fraction1);
        System.out.println(fraction2);
        System.out.println(fraction3);
        System.out.println(fraction1.sum(fraction2));
        System.out.println(fraction1.substract(fraction2));
        System.out.println(fraction1.divide(fraction2));
        System.out.println(fraction1.multiple(fraction2));
        System.out.println(fraction1.sum(fraction2).divide(fraction3).substract(-5));
    }

    /*1.6.5 Создайте пистолет вместимостью 7, зарядите три патрона, выстрелите из него пять раз, затем зарядите в него
    8 патронов, выстрелите еще 2 раза, разрядите его, сделайте контрольный выстрел.
    Если все выполнено верно, то должно быть выведено: Бах! Бах! Бах! Клац! Клац! Бах! Бах! Клац!
*/
    public static void test_1_6_5() {
        Handgun handgun = new Handgun(7);
        handgun.load(3);
        for (int i = 0; i < 5; i++) {
            handgun.shoot();
        }
        handgun.load(8);
        for (int i = 0; i < 2; i++) {
            handgun.shoot();
        }
        handgun.unload();
        handgun.shoot();

    }

    /*Необходимо, чтобы Линия соответствовала следующим требованиям:
            •	Две любые линии не могут ссылаться на один и тот же объект точки.
•	У Линии можно изменить координаты начала или конца
•	У Линии можно запросить координаты начала или конца
    Продемонстрируйте работоспособность решения на примерах.
*/
    public static void test_1_6_6() {
        Point point1 = new Point(1, 5);
        Point point2 = new Point(6, 10);
        Point point3 = new Point(11, 15);
        Line line1 = new Line(point1, point2);
        Line line2 = new Line(point2, point3);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line1.getEndPoint() == line2.getStartPoint());
        line1.setEndPoint(point3);
        System.out.println(line1);
        System.out.println(line2);
        System.out.println(line1.getEndPoint() == line2.getEndPoint());

    }

    //private static void test_1_6_7()

    /*1.6.8 Необходимо гарантировать, что добавлять Студенту можно только оценки в диапазоне от 2 до 5,
    при этом у Студента всегда можно узнать список оценок.
    Продемонстрируйте на примерах, что нет способа задать Студенту некорректную оценку.*/
    public static void test_1_6_8() {
        Student student = new Student("Petr", 2, 3, 4, 5 );
        System.out.println(student.getMarks().add(345));
        System.out.println(student.getMarks());
    }

    public static void test_1_6_9() {
        Town moscow = new Town("Москва");
        Town stPeterburg = new Town("Санкт-Петербург");
        Town nizhniyNovgorod = new Town("Нижний Новгород");
        Town voronezh = new Town("Воронеж");

        moscow.addWay(new Way(stPeterburg, 100));
        moscow.addWay(new Way(nizhniyNovgorod, 150));
        moscow.addWay(new Way(voronezh, 125));

        System.out.println(moscow);

        moscow.addWay(new Way(stPeterburg, 200));
        moscow.addWay(new Way(voronezh, 270));
        moscow.removeWay(nizhniyNovgorod);
        System.out.println(moscow);
    }

//    1.6.10 Необходимо гарантировать, что начальник отдела гарантированно работает в том же отделе, в котором он начальник.
    public static void test_1_6_10() {
        Department it = new Department("IT");
        System.out.println(it);
        System.out.println();

        Employee employee1 = new Employee("Козлов", it);
        Employee employee2 = new Employee("Петров", it);
        Employee employee3 = new Employee("Сидоров", it);
        Employee employee4 = new Employee("Воронин", it);
        Employee employee = new Employee("Тараканов", it);
        it.setManager(employee1);

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);
        System.out.println(employee);
        System.out.println();

        Department tech = new Department("Technical", employee4);
        System.out.println(tech);
        System.out.println();

        employee.setDepartment(tech);
        Employee employee6 = new Employee("Собакин", tech);
        Employee employee7 = new Employee("Кошкин", tech);
        Employee employee8 = new Employee("Курицын", tech);

        System.out.println(employee4);
        System.out.println(employee6);
        System.out.println(employee7);
        System.out.println(employee8);
        System.out.println(employee);
        System.out.println();

/*        System.out.println(it.getEmployeesList());
        System.out.println(tech.getEmployeesList());

        tech.addEmployee(employee2);
        tech.removeEmployee(employee7);

        System.out.println(it.getEmployeesList());
        System.out.println(tech.getEmployeesList());*/

        employee1.hire();
        System.out.println(employee1);
        employee4.setDepartment(null);

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);
        System.out.println(employee6);
        System.out.println(employee7);
        System.out.println(employee8);
        System.out.println(employee);

        System.out.println(it.getEmployeesList());
        System.out.println(tech.getEmployeesList());

        tech.setManager(employee1);
        it.setManager(employee3);
        tech.removeEmployee(employee8);

        System.out.println(it.getEmployeesList());
        System.out.println(tech.getEmployeesList());

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee3);
        System.out.println(employee4);
        System.out.println(employee6);
        System.out.println(employee7);
        System.out.println(employee8);
        System.out.println(employee);

        System.out.println(it);
        System.out.println(tech);

    }




}


