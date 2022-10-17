package ru.vk;

import org.jetbrains.annotations.NotNull;

public enum LoggingType {
    Console("console"),
    File("file"),
    Compose("compose");

    private final String text;

    LoggingType(String text) {
        this.text = text;
    }

    public @NotNull
    static LoggingType fromString(String text) {
        for (LoggingType type : LoggingType.values()) {
            if (type.text.equalsIgnoreCase(text)) {
                return type;
            }
        }
        throw new IllegalArgumentException();
    }
}
