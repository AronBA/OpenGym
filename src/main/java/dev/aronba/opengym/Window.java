package dev.aronba.opengym;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {



    static Window instance;

    public static void refreshWindow(){
        getInstance().revalidate();
        getInstance().repaint();
    }
    public static Window getInstance(){
        if (instance == null){
            instance = new Window();
        }
        return instance;
    }
    private Window(){
        setLayout(new BorderLayout());
        setBounds(100,100,600,400);

        WorkoutPage workoutPage = new WorkoutPage();
        WorkoutPage workoutPage1 = new WorkoutPage();
        WorkoutPage workoutPage2 = new WorkoutPage();

        JTabbedPane Navbar = new JTabbedPane();
        Navbar.addTab("Workout",workoutPage1);
        Navbar.addTab("Profile",workoutPage);

        add(Navbar);





        setVisible(true);
    }



}
