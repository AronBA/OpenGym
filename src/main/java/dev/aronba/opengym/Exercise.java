package dev.aronba.opengym;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.security.spec.ECField;
import java.util.ArrayList;

public class Exercise extends JPanel{

    String exerciseName;
    DefaultListModel<String> sets;
    Exercise(Workout workout){

        exerciseName = JOptionPane.showInputDialog("ExerciseName");
        JButton removeExercise = new JButton("remove");
        removeExercise.addActionListener(actionEvent -> workout.removeExercise(this));
        JPanel toppanel = new JPanel();


        setLayout(new BorderLayout());

        JLabel exerciseNameLabel = new JLabel(exerciseName);

        toppanel.add(exerciseNameLabel);
        toppanel.add(removeExercise); 
        add(toppanel, BorderLayout.NORTH);

        JButton newSet = new JButton("new set");
        newSet.addActionListener(actionEvent ->addSet());
        add(newSet,BorderLayout.EAST);

        JButton removeset = new JButton("remove set");
        removeset.addActionListener(actionEvent ->removeSet());
        add(removeset,BorderLayout.SOUTH);

        //setMaximumSize(new Dimension(Integer.MAX_VALUE,50));

        sets = new DefaultListModel<>();
        JList<String> Jsets = new JList<String>(sets);
        add(Jsets);



        workout.content.add(this);
        Window.refreshWindow();
    }



    void removeSet(){
        if (!sets.isEmpty()){
            sets.remove(0);
            Window.refreshWindow();
        }

    }
    void addSet(){
        String inputDialog = JOptionPane.showInputDialog("Set");
        sets.add(0,inputDialog);
        Window.refreshWindow();
    }
}
