package oop;

import edu.baykov.geometry.Point;
import edu.baykov.oop.Stack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StackTest {
    @Test
    void push() {
        Stack<String> stack = new Stack<>();
        stack.push("one");
        stack.push("two");
        stack.push("three");

        assertEquals(3, stack.size());
    }
    @Test
    void pop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        int tmp1 = stack.pop();
        int tmp2 = stack.pop();

        assertEquals(1, stack.size());
        assertEquals(3, tmp1);
        assertEquals(2, tmp2);
    }

    @Test
    void peek() {
        Point point1 = new Point(1, 1);
        Point point2 = new Point(2, 2);
        Point point3 = new Point(3, 3);
        Stack<Point> stack = new Stack<>();
        stack.push(point1);
        stack.push(point2);
        stack.push(point3);
        Point testPoint = stack.peek();

        assertTrue(testPoint == point3);
        assertEquals(3, stack.size());

    }
}
