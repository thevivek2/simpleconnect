package com.eaglessoar.simpleconnect.exception;

import java.util.function.Supplier;

import static java.lang.String.format;

public class ConsumerNotFoundException extends RuntimeException {

    private static final String NOT_EXITS = "Consumer having uuid [%s] doesn't exists";

    private final String message;

    public ConsumerNotFoundException(String message) {
        this.message = message;
    }

    public static Supplier<ConsumerNotFoundException> uuid(String uuid) {
        return () -> new ConsumerNotFoundException(format(NOT_EXITS, uuid));
    }

    @Override
    public String getMessage() {
        return message;
    }
}
