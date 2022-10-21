package ru.vk;

import org.jetbrains.annotations.NotNull;

public class ConsoleLogger implements Logger {
    private final @NotNull org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger("user");

    @Override
    public void doLog(String message) {
        logger.info(LoggerDetails.getId() + " " + message);
    }
}
