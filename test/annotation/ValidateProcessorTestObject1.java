package annotation;

import edu.baykov.annotation.Validate;
import edu.baykov.annotation.ValidateError;


    @Validate({FirstTest.class})
    class ValidateProcessorTestObject1 {
    }

    class FirstTest {
        void test(Object object) {
            throw new ValidateError("Test is not passed");
        }
}



