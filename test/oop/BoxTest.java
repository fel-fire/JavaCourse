package oop;

import edu.baykov.oop.Box;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class BoxTest {
    static Box<Integer> box;

    private static void getValue(Box<?> c) {
        System.out.println(c.getObj());
    }

    @BeforeAll
    static void init() {
        box = new Box<>();
    }
    @Test
    void setBoxAndGetBox() {
        box.setObj(5);
        getValue(box);
        box.setObj(3);
        int i = box.getObj();

        assertEquals(3, i);
        assertNull(box.getObj());
    }
}
