package com.zenika.zacademy.display;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
@Component("fileDisplayerRef")
public class FileDisplayer implements Displayer {
    @Value("${displayer.log.path}")
    private String LOG_PATH;

    public void print(Object objectToDisplay) {
        try (FileWriter fileWriter = new FileWriter(LOG_PATH, true)) {
            fileWriter.append(objectToDisplay.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
