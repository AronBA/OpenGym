package dev.aronba.opengym;

import javax.swing.*;
import java.awt.*;
import java.lang.reflect.Array;
import java.security.spec.ECField;
import java.util.ArrayList;
import java.util.Arrays;

public class Exercise extends JPanel{

    String exerciseName;
    JList<String> jSets;
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
        jSets = new JList<>(sets);
        add(jSets);



        workout.content.add(this);
        Window.refreshWindow();
    }



    void removeSet(){
        if (!sets.isEmpty()){
            int[] indecies = jSets.getSelectedIndices();
            if(indecies.length == 0) {
                sets.remove(0);
            }
            else {
                for (int i = indecies.length-1; i >= 0; i--) {
                    sets.remove(indecies[i]);
                }
            }
            Window.refreshWindow();
        }

    }
    void addSet(){
        String inputDialog = JOptionPane.showInputDialog("Set");
        sets.add(0,inputDialog);
        Window.refreshWindow();
    }
}
