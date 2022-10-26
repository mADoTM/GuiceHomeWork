package ru.vk;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {
    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Вы ввели недостаточное количество аргументов. Попробуйте заново");
            System.exit(1);
        }
        final var loggingType = LoggingType.fromString(args[0]);
        final var loggingTag = args[1];

        final Injector injector = Guice.createInjector(new ApplicationModule(loggingType, loggingTag));
        injector.getInstance(Application.class).waitForInput();
    }
}