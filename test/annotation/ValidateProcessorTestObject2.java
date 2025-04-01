package annotation;

import edu.baykov.annotation.Validate;

@Validate({SecondTest.class})
    class ValidateProcessorTestObject2 {
    }

class SecondTest {
    void test(Object object) {
    }
}