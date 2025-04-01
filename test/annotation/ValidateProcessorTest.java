package annotation;

import edu.baykov.annotation.ValidateError;
import edu.baykov.annotation.ValidateProcessor;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class ValidateProcessorTest {

    @Test
    void validateWithValidateError() {
        assertThrows(ValidateError.class, () -> ValidateProcessor.validate(new ValidateProcessorTestObject1()));

    }
    @Test
    void validateWithoutValidateError() {
        assertDoesNotThrow(() -> ValidateProcessor.validate(new ValidateProcessorTestObject2()));
    }

    @Test
    void validateWithRuntimeExceptionAndValidateOnAnnotation() {
        assertThrows(RuntimeException.class, () -> ValidateProcessor.validate(new ValidateProcessorTestObject3()));
    }
}
