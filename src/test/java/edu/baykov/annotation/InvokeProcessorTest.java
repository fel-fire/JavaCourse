package edu.baykov.annotation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashMap;
import java.util.Map;

import static edu.baykov.annotation.InvokeProcessorTest.InvokeProcessorTestValidConfig.*;
import static edu.baykov.annotation.InvokeProcessorTest.InvokeProcessorTestNonValidConfig.*;
import static org.junit.jupiter.api.Assertions.*;


public class InvokeProcessorTest {
    static InvokeProcessor invokeProcessor;

    static class InvokeProcessorTestValidConfig {
        static final Object object = new Object();
        static final Object anotherObject = new Object();


        @Invoke
        Object getObject() {
            return object;
        }

        @Invoke
        Object getAnotherObject() {
            return anotherObject;
        }

    }

    static class InvokeProcessorTestNonValidConfig {
        static final Object nonContextObject = new Object();
        static final Object objectFromParametrizedMethod = new Object();

        @Invoke
        Object getParamObject(Object obj) {
            return objectFromParametrizedMethod;
        }

        Object getNonContextObject() {
            return nonContextObject;
        }
    }

    static class InvokeProcessorTestVoidMethodConfig {
        @Invoke
        void getNothingObject() {
            throw new ValidateError();
        }
    }

    @BeforeAll
    static void init() {
        invokeProcessor = new InvokeProcessor();
    }

    @Test
    public void collectContextAddFromValidMethods() {
        Map<String, Object> context = invokeProcessor.collect(InvokeProcessorTestValidConfig.class);

        assertTrue(context.containsValue(object),"Object do not contains in context");
        assertTrue(context.containsValue(anotherObject),"AnotherObject do not contains in context");

    }

    @Test
    public void collectContextMethodNameEqualsObjectMethod() {
        Map<String, Object> context = invokeProcessor.collect(InvokeProcessorTestValidConfig.class);

        assertEquals(object, context.get("getObject"),
                "Method name \"getObject\" do not equals objects method in context");
        assertEquals(anotherObject, context.get("getAnotherObject"),
                "Method name \"getAnotherObject\" do not equals anotherObjects method in context");
    }

    @Test
    public void collectContextAddFromValidMethodsLength() {
        Map<String, Object> context = invokeProcessor.collect(InvokeProcessorTestValidConfig.class);
        assertEquals(2, context.size(),
                "Some invalid objects added in context");

    }

    @Test
    public void collectFromNonValidMethods() {
        Map<String, Object> context = invokeProcessor.collect(InvokeProcessorTestVoidMethodConfig.class);

        assertFalse(context.containsValue(nonContextObject),
                "Object from class without annotation was added in context");
        assertFalse(context.containsValue(objectFromParametrizedMethod),
                "Object from parameterized method was added in context");
    }

    @Test
    public void collectFromVoidMethod() {
        assertDoesNotThrow(() -> invokeProcessor.collect(InvokeProcessorTestNonValidConfig.class),
                "An attempt to invoke void method");

    }
    @Test
    public void collectWithNullSource() {
        assertEquals(new HashMap<String, Object>(), invokeProcessor.collect(null),
                "InvokeProcessor with a null argument does not return an empty HashMap");
    }

    @ParameterizedTest
    @ValueSource(classes = InvokeProcessorTestValidConfig.class)
    public void collectWithOneNullArgument(Class<?> cls) {

        assertEquals(invokeProcessor.collect(cls),
                invokeProcessor.collect(cls, null),
                "InvokeProcessor must continue null argument and return HashMap only " +
                        "for " + cls);
    }

 }
