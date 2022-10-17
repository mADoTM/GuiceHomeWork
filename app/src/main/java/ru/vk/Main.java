package ru.vk;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        final var loggingType = LoggingType.fromString(args[0]);
        final var loggingTag = args[1];

        final Injector injector = Guice.createInjector(new ApplicationModule(loggingType, loggingTag));
        injector.getInstance(Application.class).waitForInput();
    }
}