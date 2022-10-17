package ru.vk;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Application {
    public void waitForInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Waiting for new lines. Key in Ctrl+D to exit.");
            while (true) {
                String userInput = scanner.nextLine();
                printSome(userInput);
            }
        } catch (IllegalStateException | NoSuchElementException e) {
            System.exit(1);
        }
    }

    @InputLogAnnotation
    protected void printSome(String text) {
        System.out.println(text);
    }
}
