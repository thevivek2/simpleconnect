package com.eaglessoar.simpleconnect.exception;

import java.util.function.Supplier;

import static java.lang.String.format;

public class DuplicateLookupException extends RuntimeException {

    private static final String NOT_EXITS = "Lookup having code [%s] already exists.";

    private final String message;

    public DuplicateLookupException(String message) {
        this.message = message;
    }

    public static Supplier<DuplicateLookupException> code(String code) {
        return () -> new DuplicateLookupException(format(NOT_EXITS, code));
    }

    @Override
    public String getMessage() {
        return message;
    }
}
