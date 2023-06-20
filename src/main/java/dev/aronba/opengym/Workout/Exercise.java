package dev.aronba.opengym.Workout;

import dev.aronba.opengym.Window;

import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represents an Exercise
 */

public class Exercise extends JPanel{
    private final String exerciseName;
    private DefaultListModel<String> sets;
    private JList<String> jSets;
    Exercise(Workout workout){
        sets = new DefaultListModel<>();
        jSets = new JList<>(sets);
        exerciseName = JOptionPane.showInputDialog("ExerciseName");

        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/trash.png"))
                .getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon trashIcon = new ImageIcon(img);
        JButton removeExercise = new JButton(trashIcon);
        removeExercise.setPreferredSize(new Dimension(30, 30));

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

        add(jSets,BorderLayout.CENTER);

        JButton removeset = new JButton("-");
        removeset.addActionListener(actionEvent ->removeSet());

        JPanel sidepanel = new JPanel();
        sidepanel.setLayout(new GridLayout(2,1));
        add(sidepanel,BorderLayout.EAST);
        setMaximumSize(new Dimension(Integer.MAX_VALUE,200));

        sidepanel.add(newSet);
        sidepanel.add(removeset);

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
