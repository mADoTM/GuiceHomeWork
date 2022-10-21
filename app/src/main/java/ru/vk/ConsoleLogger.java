package ru.vk;

import org.jetbrains.annotations.NotNull;

public class ConsoleLogger implements Logger {
    private final @NotNull java.util.logging.Logger logger = java.util.logging.Logger.getLogger("");

    @Override
    public void doLog(String message) {
        logger.info(LoggerDetails.getId() + " " + message);
    }
}
