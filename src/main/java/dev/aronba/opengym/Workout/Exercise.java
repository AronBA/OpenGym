package dev.aronba.opengym.Workout;

import dev.aronba.opengym.Window;

import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise extends JPanel{


    private String exerciseName;
    private JList<String> jSets;
    private DefaultListModel<String> sets;
    Exercise(Workout workout){



        exerciseName = JOptionPane.showInputDialog("ExerciseName");
        JButton removeExercise = new JButton("X");
        removeExercise.addActionListener(actionEvent -> workout.removeExercise(this));
        JPanel toppanel = new JPanel();


        setLayout(new BorderLayout());

        JLabel exerciseNameLabel = new JLabel(exerciseName);
        exerciseNameLabel.setFont(new Font("Arial", Font.BOLD,20));
        toppanel.add(exerciseNameLabel);
        toppanel.add(removeExercise); 
        add(toppanel, BorderLayout.NORTH);

        JButton newSet = new JButton("+");
        newSet.addActionListener(actionEvent ->addSet());

        JButton removeset = new JButton("-");
        removeset.addActionListener(actionEvent ->removeSet());


        JPanel sidepanel = new JPanel();
        sidepanel.setLayout(new GridLayout(2,1));
        add(sidepanel,BorderLayout.EAST);
        setMaximumSize(new Dimension(Integer.MAX_VALUE,200));

        sidepanel.add(newSet);
        sidepanel.add(removeset);
        sets = new DefaultListModel<>();
        jSets = new JList<>(sets);
        add(jSets,BorderLayout.CENTER);


        add(new JSeparator(), BorderLayout.SOUTH);


        workout.content.add(this);
        dev.aronba.opengym.Window.refreshWindow();
    }

    public List<String> getSetsAsList() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < sets.size(); i++){
           list.add(sets.elementAt(i));
        }
        return list;
    }

    public String getExerciseName() {
        return exerciseName;
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
            dev.aronba.opengym.Window.refreshWindow();
        }

    }
    void addSet(){
        String inputDialog = JOptionPane.showInputDialog("Set");
        sets.add(0,inputDialog);
        Window.refreshWindow();
    }
}
