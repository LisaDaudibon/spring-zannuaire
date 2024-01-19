package com.zenika.zacademy.display;

import java.io.FileWriter;
import java.io.IOException;

public class FileDisplayer implements Displayer {
    public void print(Object objectToDisplay) {
        try (FileWriter fileWriter = new FileWriter("log.txt", true)) {
            fileWriter.append(objectToDisplay.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
