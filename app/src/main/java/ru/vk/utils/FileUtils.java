package ru.vk.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileUtils {
    public static void createFileWithText(String text) throws IOException {
        String fileName = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".txt";

        File file = new File(fileName);

        if(!file.exists()) {
            file.createNewFile();
        }
        Files.write(Paths.get(fileName), (text + "\n").getBytes(), StandardOpenOption.APPEND);
    }
}
