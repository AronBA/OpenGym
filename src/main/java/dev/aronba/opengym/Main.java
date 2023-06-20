package dev.aronba.opengym;

import javax.swing.*;

class Main {
    public static void main(String[] args) {
        Settings.readSettings();
        Window.getInstance();
    }
}