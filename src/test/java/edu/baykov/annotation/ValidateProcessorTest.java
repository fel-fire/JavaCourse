package edu.baykov.annotation;

import org.junit.jupiter.api.Test;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static org.junit.jupiter.api.Assertions.*;

public class ValidateProcessorTest {

    @Validate({ValidateProcessorTestObject1.FirstTest.class})
    static class ValidateProcessorTestObject1 {

        static class FirstTest {
            void test(Object object) {
                throw new ValidateError("Test is not passed");
            }
        }
    }

    @Validate({ValidateProcessorTestObject2.SecondTest.class})
    static class ValidateProcessorTestObject2 {
        static class SecondTest {
            void test(Object object) {
            }
        }
    }

    @ValidateAnnotationTest
    static public class ValidateProcessorTestObject3 {
        static class ThirdTest {
            void test(Object object) {
                throw new RuntimeException("Test for runtime exception");
            }
        }
    }

    @NonAnnotatedAnnotationTest
    static class ValidateProcessorTestObject4 {
    }

    @NonValidateAnnotationTest
    static class ValidateProcessorTestObject5 {
    }
    @NonValidateAnnotationTest
    static class ValidateProcessorTestObject6 {
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @Validate({ValidateProcessorTestObject3.ThirdTest.class})
    public @interface ValidateAnnotationTest {
    }

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface NonAnnotatedAnnotationTest {
    }

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @NonAnnotatedAnnotationTest
    public @interface NonValidateAnnotationTest {
    }


    @Test
    void validateWithValidateError() {
        assertThrows(ValidateError.class,
                () -> ValidateProcessor.validate(new ValidateProcessorTestObject1()),
                "Validate Error was not thrown out for invalid class");

    }

    @Test
    void validateWithoutValidateError() {
        assertDoesNotThrow(() -> ValidateProcessor.validate(new ValidateProcessorTestObject2()),
                "Exception was thrown for valid class");
    }

    @Test
    void validateWithRuntimeException() {
        assertThrows(RuntimeException.class,
                () -> ValidateProcessor.validate(new ValidateProcessorTestObject3()),
                "Runtime Exception was not thrown for errorClass");
    }

    @Test
    void validateWithValidateOnAnnotation() {
        assertDoesNotThrow(() -> ValidateProcessor.validate(new ValidateProcessorTestObject6()),
                "There was an attempt to validate a class with annotation " +
                        "which non-marked with an @Validate annotation");
    }

    @Test
    void validateWithObjWichAnnotationIsNotAnnotated() {
        assertDoesNotThrow(() -> ValidateProcessor.validate(new ValidateProcessorTestObject4()),
                "There was an attempt to validate a class with No-@Validate annotation " +
                        "which non-marked with an annotation");
    }

    @Test
    void validateWithObjWichAnnotationIsNoValidateAnnotated() {
        assertDoesNotThrow(() -> ValidateProcessor.validate(new ValidateProcessorTestObject5()),
                "There was an attempt to validate a class with No-@Validate annotation " +
                        "which non-marked with an @Validate annotation");
    }

    @Test
    void validateWithoutAnnotation() {
        assertDoesNotThrow(() -> ValidateProcessor.validate(new ValidateProcessorTestObject4()),
                "There was an attempt to validate a class not marked with an annotation");
    }

    @Test
    void validateWithNullSource() {
        assertThrows(IllegalArgumentException.class, () -> ValidateProcessor.validate(null),
                "Objects array is null or some object is null but validate was not stopped");
    }

    @Test
    void validateWitOneNullSource() {
        assertThrows(IllegalArgumentException.class,
                () -> ValidateProcessor.validate(new ValidateProcessorTestObject2(), null),
                "Objects array is null or some object is null but validate was not stopped");
    }
}
