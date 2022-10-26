package ru.vk;

import com.google.inject.Inject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ComposeLogger implements Logger {
    @NotNull
    private final Set<Logger> loggers;

    @Inject
    public ComposeLogger(@NotNull Set<Logger> loggers) {
        this.loggers = loggers;
    }
    @Override
    public void doLog(String message) {
        loggers.forEach(logger -> logger.doLog(message));
    }
}
