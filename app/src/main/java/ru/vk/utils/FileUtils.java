package ru.vk.utils;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;

public class FileUtils {
    private final static HashSet<String> filesUsingStatus = new HashSet<>();

    public static void createFileWithText(String text) throws IOException {
        String fileName = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance().getTime()) + ".txt";


        File file = new File(fileName);
        var path = file.toPath();

        var operation = StandardOpenOption.CREATE_NEW;
        if (file.exists()) {
            operation = StandardOpenOption.TRUNCATE_EXISTING;
            if(filesUsingStatus.contains(fileName)) {
                operation = StandardOpenOption.APPEND;
            }
        }
        filesUsingStatus.add(fileName);
        Files.write(path, (text + "\n").getBytes(), operation);
    }
}
