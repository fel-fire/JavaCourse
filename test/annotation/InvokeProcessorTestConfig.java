package annotation;

import edu.baykov.annotation.Invoke;

public class InvokeProcessorTestConfig {
    static final Object object = new Object();
    static final Object anotherObject = new Object();
    static final Object nonContextObject = new Object();

    @Invoke
    Object getObject() {
        return object;
    }

    @Invoke
    Object getAnotherObject() {
        return anotherObject;
    }

    Object getNonContextObject() {
        return nonContextObject;
    }
}
