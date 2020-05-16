package com.eaglessoar.simpleconnect.exception;

import java.util.function.Supplier;

import static java.lang.String.format;

public class ProviderNotFoundException extends RuntimeException {

    private static final String NOT_EXITS = "Provider having uuid [%s] doesn't exists";

    private final String message;

    public ProviderNotFoundException(String message) {
        this.message = message;
    }

    public static Supplier<ProviderNotFoundException> uuid(String uuid) {
        return () -> new ProviderNotFoundException(format(NOT_EXITS, uuid));
    }

    @Override
    public String getMessage() {
        return message;
    }
}
