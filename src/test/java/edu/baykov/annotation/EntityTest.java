package edu.baykov.annotation;

import org.junit.jupiter.api.Test;

import static edu.baykov.annotation.YesOrNo.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class EntityTest {

    @ToString
    static class A extends Entity{
        String value = "A";
    }

    @ToString
    static class B extends Entity{
        @ToString(value = NO)
        String value = "B";
    }

    @ToString(NO)
    static class C extends Entity{
        @ToString(YES)
        String value = "C";
    }

    static class D extends Entity{
        @ToString()
        String value = "D";
    }

    static class E extends Entity{
        String value = "E";
    }

    static class F extends A {
        @ToString
        String oneMoreValue = "F";
    }

    @Test
    void toStringWithAnnotatedClassByYESAndNoAnnotatedField() {
        A testA = new A();
        String actual = testA.toString();

        assertEquals("A{value=A}", actual,
                "Incorrect actual value for entity of the annotated by default \"YES\" class");
    }

    @Test
    void toStringWithAnnotatedClassAndAnnotatedFieldByNO() {
        B testB = new B();
        String actual = testB.toString();

        assertEquals("B{}", actual,
                "Incorrect actual value for entity of the annotated by default \"YES\" class" +
                "and the annotated by \"NO\" field");
    }

    @Test
    void toStringWithAnnotatedClassByNOAndAnnotatedFieldByYES() {
        C testC = new C();
        String actual = testC.toString();

        assertEquals("C{value=C}", actual,
                "Incorrect actual value for entity of the annotated by \"NO\" class" +
                        "and the annotated by default \"YES\" field");
    }

    @Test
    void toStringWithNoAnnotatedClassAndAnnotatedFieldByYES() {
        D testD = new D();
        String actual = testD.toString();

        assertEquals("D{value=D}", actual,
                "Incorrect actual value for entity of the non annotated class" +
                        "and the annotated by default \"YES\" field");
    }

    @Test
    void toStringWithNoAnnotatedClassAndNoAnnotatedField() {
        E testE = new E();
        String actual = testE.toString();

        assertEquals("E{}", actual,
                "Incorrect actual value for entity of  the non annotated class and field");
    }

    @Test
    void toStringWithInheritedClass() {
        F testF = new F();
        String actual = testF.toString();

        assertEquals("F{value=A, oneMoreValue=F}", actual,
                "Incorrect actual value for entity of inherited class");
    }
}
