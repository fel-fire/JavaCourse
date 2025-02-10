package oop;

import edu.baykov.oop.Storage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StorageTest {

    static <T> T getValue(Storage<T> c) {
        T result = c.getObj();
        System.out.println(result);
        return result;
    }

    @Test
    void getObj() {
        Storage<Integer> storage1 = new Storage<>(null, 0);
        Storage<Integer> storage2 = new Storage<>(99, -1);
        Storage<String> storage3 = new Storage<>(null, "default");
        Storage<String> storage4 = new Storage<>("hello", "hello world");

        assertEquals(0, getValue(storage1));
        assertEquals(99, getValue(storage2));
        assertEquals("default", getValue(storage3));
        assertEquals("hello", getValue(storage4));
    }
}
