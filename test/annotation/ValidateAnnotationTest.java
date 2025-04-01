package annotation;

import edu.baykov.annotation.Validate;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Validate({ThirdTest.class})
public @interface ValidateAnnotationTest {
}
