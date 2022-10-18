package ru.vk;


import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class ConsoleLogger implements Logger {
    private final @NotNull java.util.logging.Logger logger;

    @Inject
    public ConsoleLogger(@NotNull java.util.logging.Logger logger) {
        this.logger = logger;
    }
    @Override
    public void doLog(String message) {
        logger.info(LoggerDetails.getId() + " " + message);
    }
}
