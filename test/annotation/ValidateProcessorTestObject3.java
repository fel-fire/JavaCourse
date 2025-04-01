package annotation;

@ValidateAnnotationTest
public class ValidateProcessorTestObject3 {
}

class ThirdTest {
    void test(Object object) {
        throw new RuntimeException("Test for runtime exception");
    }
}
