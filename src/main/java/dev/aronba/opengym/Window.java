package dev.aronba.opengym;

import dev.aronba.opengym.History.HistoryPage;
import dev.aronba.opengym.Workout.WorkoutPage;

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
        HistoryPage historyPage = new HistoryPage();


        JTabbedPane Navbar = new JTabbedPane();


        Navbar.addTab("Workout",workoutPage);
        Navbar.addTab("History",historyPage);

        add(Navbar);





        setVisible(true);
    }



}
