package dev.aronba.opengym.Workout;

import dev.aronba.opengym.Window;
import dev.aronba.opengym.Workout.Workout;

import javax.swing.*;
import java.awt.*;

public class WorkoutPage extends JPanel {
    Workout currentworkout;
    JButton createWorkout;

    public WorkoutPage(){
        setLayout(new BorderLayout());
        createWorkout = new JButton("new workout");
        add(createWorkout);
        createWorkout.addActionListener(actionEvent -> newWorkout());



    }
    void newWorkout(){
        remove(createWorkout);
        this.currentworkout = new Workout(this);
        add(currentworkout,BorderLayout.CENTER);
        dev.aronba.opengym.Window.refreshWindow();
    }
    void removeWorkout(Workout workout){
        remove(workout);
        this.createWorkout = new JButton("new workout");
        add(createWorkout);
        createWorkout.addActionListener(actionEvent -> newWorkout());
        Window.refreshWindow();
    }





}
