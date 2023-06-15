package dev.aronba.opengym;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Workout extends JPanel {

    WorkoutPage workoutPage;


    JPanel content;
    Workout(WorkoutPage workoutPage){

        this.workoutPage = workoutPage;

        setLayout(new BorderLayout());

        content = new JPanel();
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));


        JScrollPane scrollPane= new JScrollPane(content);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane,BorderLayout.CENTER);

        JButton BtnAddExercise = new JButton("add Exercise");
        BtnAddExercise.addActionListener(actionEvent -> this.addExercise());

        JButton BtnFinishWorkout = new JButton("finish Wokrout");
        BtnFinishWorkout.addActionListener(actionEvent -> this.finish());

        JPanel jPanel = new JPanel();
        jPanel.add(BtnAddExercise);
        jPanel.add(BtnFinishWorkout);
        add(jPanel,BorderLayout.SOUTH);

    }
    public void finish(){
        workoutPage.removeWorkout(this);
    }
    public void addExercise(){
        new Exercise(this);

    }
    public void removeExercise(Exercise exercise){
        System.out.println("test");
        this.content.remove(exercise);
        Window.refreshWindow();
    }
}