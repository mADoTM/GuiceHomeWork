package ru.vk;

import ru.vk.utils.FileUtils;

import java.io.IOException;

public class FileLogger implements Logger {
    @Override
    public void doLog(String message) {
        try {
            FileUtils.createFileWithText(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
