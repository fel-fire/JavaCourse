package edu.baykov.spring.processor;

public class ValidateError extends RuntimeException {

    public ValidateError() {
    }
    public ValidateError(String message) {
        super(message);
    }
}
