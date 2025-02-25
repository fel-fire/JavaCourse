package oop;

import edu.baykov.oop.MyStream;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyStreamTest {

    @Test
    void myStreamAction() {
        List<String> list = new ArrayList<>(List.of("1", "2", "3", "4", "5"));
        MyStream<String> stream = new MyStream<>(list);
        int result = stream.map(Integer::parseInt)
                           .reduce(0, Integer::sum);

        assertEquals(15, result);
    }

    @Test
    void myStreamAction2() {
        List<String> list = new ArrayList<>(List.of("One", "Two", "three", "four", "Five"));

        MyStream<String> stream = new MyStream<>(list);
        int result = stream.filter(s -> Pattern.matches("^[A-Z].*", s)).map(s -> s != null ? 1 : 0).reduce(0, Integer::sum);

        // ИЛИ

        //MyStream<String> stream2 = new MyStream<>(list);
        //List<String> result2 = stream2.filter(s -> Pattern.matches("^[A-Z].*", s)).collect(ArrayList::new, (s, l) -> l.add(s));


        assertEquals(3, result);
        //assertEquals(3, result2.size());


    }
}
