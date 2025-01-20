package oop;

public class Test {
    public static void main(String[] args) {
        //test_2_1_2();
        //test_2_1_3();
        //test_2_1_4();
        //test_2_2_1();
        //test_2_2_2();
        //test_2_2_3();
        //test_2_2_5();

        //System.out.println(method_2_3_1(2, new Fraction(3, 5), 2.3));
        //method_2_3_2(new Cuckoo(), new Parrot("Попка - дурак!"), new Sparrow(), new Cuckoo(),
        //            new Parrot("Я люблю Java"), new Sparrow());

//        System.out.println(method_2_3_3(
//                new Round(5),
//                new Triangle(2, 2, 3),
//                new Rectangle(5, 10),
//                new Square2(5))
//        );
        //method_2_3_4(new Cat("Barsik"), new Cat("Pushok"), new Lion());
//        System.out.println(method_2_3_5(
//                new Line(0, 0, 0, 5),
//                new Polyline(
//                        new Point(2, 6),
//                        new Point(5, 7),
//                        new Point(12, 5),
//                        new Point(22,13))));
        //test_2_3_6();
//        System.out.println(method_2_3_7(
//                new Polyline(new Point(1,1), new Point(1, 3), new Point(3, 6)),
//                new Square(7, 7, 7)));
//        test_2_3_8();
//        test_2_3_9();
    }


    private static void test_2_1_2() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(5, 0);
        Point point3 = new Point(5, 5);
        Point point4 = new Point(0, 5);
        ClosedPolyline closedPolyline = new ClosedPolyline(point1, point2, point3, point4);
        System.out.println(closedPolyline.length());
    }

    private static void test_2_1_3() {
        TownWithBackWay moscow = new TownWithBackWay("Moscow");
        TownWithBackWay berlin = new TownWithBackWay("Berlin");
        moscow.addWay(new Way(berlin, 2500));
        System.out.println(moscow);
        System.out.println(berlin);
        TownWithBackWay paris = new TownWithBackWay("Paris", new Way(moscow, 3000), new Way(berlin, 4500));
        System.out.println(moscow);
        System.out.println(berlin);
        System.out.println(paris);

        moscow.addWay(new Way(berlin, 10000));
        System.out.println(moscow);
        System.out.println(berlin);
        System.out.println(paris);
    }

    private static void test_2_1_4() {
        MachineRifle machineRifle1 = new MachineRifle();
        MachineRifle machineRifle2 = new MachineRifle(20);
        MachineRifle machineRifle3 = new MachineRifle(20, 5);
        machineRifle1.load(20);
        machineRifle2.load(20);
        machineRifle3.load(20);
        machineRifle1.shoot();
        machineRifle1.shoot(3);
        machineRifle2.shoot(1);
        machineRifle3.shoot(3);
    }

    private static void test_2_2_1() {
        Handgun handgun = new Handgun(8, 8);
        for (int i = 0; i < 4; i++) {
            handgun.shoot();
        }
        System.out.println(handgun.load(20));
        System.out.println(handgun.ammo());
        for (int i = 0; i < 10; i++) {
            handgun.shoot();
        }

    }

    private static void test_2_2_2() {
        Fraction fraction1 = new Fraction(4, 2);
        Fraction fraction2 = new Fraction(2, 4);
        System.out.println(fraction1.intValue());
        System.out.println(fraction2.intValue());
        System.out.println(fraction1.longValue());
        System.out.println(fraction2.longValue());
        System.out.println(fraction1.doubleValue());
        System.out.println(fraction2.doubleValue());
        System.out.println(fraction1.floatValue());
        System.out.println(fraction2.floatValue());
    }

    private static void test_2_2_3() {
        Sparrow sparrow = new Sparrow();
        sparrow.sing();
        Cuckoo cuckoo = new Cuckoo();
        cuckoo.sing();
        Parrot parrot = new Parrot("От улыбки станет всем светлей");
        parrot.sing();

    }
    private static void test_2_2_5() {
        CompositePoint cp = new CompositePoint(
                PointCoordinatesGenerator.generate(3, 4, 5),
                new PointColor("green"),
                new PointSize(20));
        System.out.println(cp);


    }

    private static void test_2_3_6() {
        Square square = new Square(5, 0, 10);
        System.out.println(square.getPolyline().length());
    }

    private static void test_2_3_8() {
        Shooter shooter1 = new Shooter("John");
        shooter1.shoot();
        Shooter shooter2 = new Shooter("Ted", new Handgun(5));
        shooter2.shoot();
        Shooter shooter3 = new Shooter("Bill", new MachineRifle(30, 10));
        shooter3.shoot();
    }

    private static void test_2_3_9() {
        Student vasya = new Student("Vasya", new StudentOneOrZero(), 1, 1, 1, 0, 0, 0);
        Student petya = new Student("Petya", new StudentOnlyEven(), 2, 4, 6, 8);
        Student sidor = new Student("Sidor",   1, 10, 20, 30, 40);
        System.out.println(vasya);
        System.out.println(petya);
        System.out.println(sidor);
    }

    // Указанном блоке располагаются решения задач из раздела 2.3, которые необходимо было выполнить
    // в виде разработки нового метода

    /* 2.3.1 Сложение. Разработайте метод, который принимает набор числовых значений и возвращает их
    сумму в вещественной форме. С использованием данного метода выполните следующие сложения:*/
    private static double method_2_3_1(Number... numbers) {
        if (numbers == null || numbers.length == 0) throw new IllegalArgumentException("Invalid input values");
        double res = 0;
        for (Number number : numbers) res += number.doubleValue();
        return res;
    }

    /* 2.3.2 Птичий рынок. Разработайте метод, который принимает набор птиц из задачи 2.2.3 и вызывает метод пения у каждой из
    них. Продемонстрируйте работоспособность метода, передав в него несколько воробьев, кукушек и попугаев.*/
    private static void method_2_3_2(Bird... birds) {
        if (birds == null || birds.length == 0) throw new IllegalArgumentException("Invalid input values");
        for (Bird bird : birds) bird.sing();
    }

    /*    2.3.3 Общая площадь. Разработайте метод, который принимает набор фигур из задачи 2.2.4 и считает их общую площадь
            (без учета возможного перекрытия фигурами друг друга). Продемонстрируйте работоспособность метода, передав
    туда несколько кругов и квадратов.*/
    private static double method_2_3_3(Figure... figures) {
        if (figures == null || figures.length == 0) throw new IllegalArgumentException("Invalid input values");
        double totalArea = 0;
        for (Figure figure : figures) {
            //System.out.println(figure.getArea());
            totalArea += figure.getArea();
        }
        return totalArea;
    }

/*    2.3.4 Мяуканье. Разработайте метод, который принимает набор объектов способных мяукать и вызывает
    мяуканье у каждого объекта.*/
    private static void method_2_3_4(Meowable... cats) {
        if (cats == null || cats.length == 0) throw new IllegalArgumentException("Invalid input values");
        for (Meowable cat : cats) cat.meow();
    }

/*    2.3.5 Измерение длины. Разработайте метод, который принимает набор объектов у которых
    можно посчитать длину, и возвращает сумму длин принятых объектов.*/
    private static int method_2_3_5(Measurable... lines) {
        if (lines == null || lines.length == 0) throw new IllegalArgumentException("Invalid input values");
        int res = 0;
        for (Measurable line : lines) res += line.length();
        return res;
    }

/*    2.3.7 Поломки. Разработайте метод, который принимает такой набор объектов, у которых можно получить ломаную линию,
    и возвращает их объединение в виде одного объекта типа Ломаная.*/
    private static Polyline method_2_3_7(TransformableToPolyline... obj) {
        if (obj == null || obj.length == 0) throw new IllegalArgumentException("Invalid input values");
        Polyline polyline = obj[0].getPolyline();
        for (int i = 1; i < obj.length; i++) {
            Polyline tmpPolyline = obj[i].getPolyline();
            Point[] tmp = tmpPolyline.getPoints().toArray(new Point[0]);
            polyline.addPoint(tmp);
        }
        return polyline;
    }
}


