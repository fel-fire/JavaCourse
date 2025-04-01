package annotation;

import edu.baykov.annotation.InvokeProcessor;
import org.junit.jupiter.api.Test;
import java.util.Map;

import static annotation.InvokeProcessorTestConfig.*;
import static org.junit.jupiter.api.Assertions.*;


public class InvokeProcessorTest {

    @Test
    public void collect() {

        Map<String, Object> context = InvokeProcessor.collect(InvokeProcessorTestConfig.class);

        assertTrue(context.containsValue(object));
        assertTrue(context.containsValue(anotherObject));
        assertFalse(context.containsValue(nonContextObject));
    }
 }
