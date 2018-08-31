package ru.job4j.nonblocking;

public class OptimisticException extends RuntimeException {
    public OptimisticException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
