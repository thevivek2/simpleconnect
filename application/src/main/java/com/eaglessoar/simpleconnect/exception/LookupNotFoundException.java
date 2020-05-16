package com.eaglessoar.simpleconnect.exception;

import java.util.function.Supplier;

import static java.lang.String.format;

public class LookupNotFoundException extends RuntimeException {

    private static final String NOT_EXITS = "Lookup having uuid [%s] doesn't exists";
    private static final String NOT_EXITS_BY_CODE = "Lookup having code [%s] doesn't exists";

    private final String message;

    public LookupNotFoundException(String message) {
        this.message = message;
    }

    public static Supplier<LookupNotFoundException> uuid(String uuid) {
        return () -> new LookupNotFoundException(format(NOT_EXITS, uuid));
    }

    public static Supplier<LookupNotFoundException> code(String code) {
        return () -> new LookupNotFoundException(format(NOT_EXITS_BY_CODE, code));
    }

    @Override
    public String getMessage() {
        return message;
    }
}
