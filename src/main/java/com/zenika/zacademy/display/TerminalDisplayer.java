package com.zenika.zacademy.display;

public class TerminalDisplayer implements Displayer {
    public void print(Object objectToDisplay) {
        System.out.println(objectToDisplay.toString());
    }
}
