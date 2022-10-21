package ru.vk;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import org.jetbrains.annotations.NotNull;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {

    private final @NotNull Logger logger;

    private final @NotNull String tag;

    @Inject
    public Application(@NotNull Logger logger,
                       @NotNull @Named("logging_tag") String tag) {
        this.logger = logger;
        this.tag = tag;
    }

    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String userInput = scanner.nextLine();
                logger.doLog(getMessage(userInput));
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.exit(1);
        }
    }

    private @NotNull String getMessage(String data) {
        return  "<"+ tag + ">"
                + data +
                "<"+ tag + ">";
    }

}
