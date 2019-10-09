package com.company;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileUtils {

    public static List<String> readSavedCharacter(String fileName) {

        List<String> listOfStrings = null;
        try {
            listOfStrings = Files.readAllLines(Paths.get(fileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listOfStrings;
    }

    public static void writeAllLines(String fileName, List<String> lines){
        try {
            Path path = Paths.get(fileName);
            Files.write(path, lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
