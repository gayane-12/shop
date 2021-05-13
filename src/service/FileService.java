package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileService {

    public static void creatFolder(String path) {
        File newFile = new File(path);
        newFile.mkdirs();
    }

    public static void createFile(String path, String name) {
        File newFile = new File(path + File.separator + name);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void append(String path, String text) {
        try {
            Files.write(Paths.get(path), (text + "\n").getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readLines(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void write(String path, String text) {
        try {
            Files.write(Paths.get(path), text.getBytes(), StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void empty(String path) {
        try {
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(path));
            writer.write("");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
