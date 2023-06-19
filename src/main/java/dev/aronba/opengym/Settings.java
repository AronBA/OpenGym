package dev.aronba.opengym;

import java.io.File;

//this class should represent the opengym.conf file
public class Settings {

    public static File openGymFolder = new File(".opengym");
    public static File workoutFolder = new File(openGymFolder + "/Workouts");

    public static String standartTheme = "";

}
