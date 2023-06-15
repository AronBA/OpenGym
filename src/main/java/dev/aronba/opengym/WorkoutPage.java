package dev.aronba.opengym;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class WorkoutPage extends JPanel {
    Workout currentworkout;
    JButton createWorkout;

    WorkoutPage(){
        setLayout(new BorderLayout());
        createWorkout = new JButton("new workout");
        add(createWorkout);
        createWorkout.addActionListener(actionEvent -> newWorkout());



    }
    void newWorkout(){
        remove(createWorkout);
        this.currentworkout = new Workout(this);
        add(currentworkout,BorderLayout.CENTER);
        Window.refreshWindow();
    }
    void removeWorkout(Workout workout){
        remove(workout);
        this.createWorkout = new JButton("new workout");
        add(createWorkout);
        createWorkout.addActionListener(actionEvent -> newWorkout());
        Window.refreshWindow();
    }





}
