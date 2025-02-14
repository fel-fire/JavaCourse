package oop;

import edu.baykov.oop.Storage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StorageTest {

/*    static <T> T getValue(Storage<T> c) {
        T result = c.getObj();
        System.out.println(result);
        return result;
    }*/

    @Test
    void getObj() {
        Storage<Integer> storage1 = new Storage<>(null);
        Storage<Integer> storage2 = new Storage<>(99);
        Storage<String> storage3 = new Storage<>(null);
        Storage<String> storage4 = new Storage<>("hello");

        assertEquals(0, storage1.getObj(0));
        assertEquals(99, storage2.getObj(-1));
        assertEquals("default", storage3.getObj("default"));
        assertEquals("hello", storage4.getObj("hello world"));
    }
}
