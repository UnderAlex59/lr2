package ru.zverev.lr2.model;

public enum ErrorCodes {
    EMPTY(""),

    VALIDATION_EXCEPTION("ValidationException"),

    UNKNOWN_EXCEPTION("UnknownException"),

    UNSUPPORTED_EXCEPTION("UnsupportedException");

    private final String name;

    ErrorCodes(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}
