package ru.zverev.lr2.model;

public enum ErrorMessages {

    EMPTY(""),

    VALIDATION("Ошибка валидации"),

    UNSUPPORTED("Произошла непредвиденная ошибка"),

    UNKNOWN("Не поддерживаемая ошибка");

    private final String description;

    ErrorMessages(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return description;
    }
}
