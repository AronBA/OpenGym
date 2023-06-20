package dev.aronba.opengym;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLaf;

import javax.swing.*;
import java.io.*;
import java.util.Properties;

//this class should represent the opengym.conf file
public class Settings {
    public static File openGymFolder = new File(".opengym");
    public static File workoutFolder = new File(openGymFolder + "/Workouts");
    private static File configFile = new File(openGymFolder + "/opengym.conf");
    private static Theme theme;
    private static Properties properties;

    public static void readSettings() {
        properties = new Properties();
        try {
            FileInputStream fis = new FileInputStream(configFile.toString());
            properties.load(fis);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (properties.getProperty("theme") == null) {
            setTheme(Theme.FlatLafDark);
            return;
        }
        setTheme(Theme.valueOf(properties.getProperty("theme")));
    }
    public static void setTheme(Theme theme) {
        Settings.theme = theme;
        try {
            UIManager.setLookAndFeel(Theme.getTheme(theme));
        } catch( Exception ex ) {
            System.err.println("Failed to set LaF");
        }
    }
    public static void updateTheme() {
        SwingUtilities.updateComponentTreeUI(Window.getInstance());
    }
    public static void saveTheme(Theme theme) {
        try {
            FileOutputStream fos = new FileOutputStream(configFile.toString());
            properties.setProperty("theme", String.valueOf(theme));
            properties.store(fos, "Current theme");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
