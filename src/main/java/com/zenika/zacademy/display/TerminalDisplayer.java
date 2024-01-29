package com.zenika.zacademy.display;

import org.springframework.stereotype.Component;

@Component("terminalDisplayerRef")
public class TerminalDisplayer implements Displayer {
    public void print(Object objectToDisplay) {
        System.out.println(objectToDisplay.toString());
    }
}
