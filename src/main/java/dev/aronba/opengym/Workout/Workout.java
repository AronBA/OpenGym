package dev.aronba.opengym.Workout;

import dev.aronba.opengym.History.HistoryPage;
import dev.aronba.opengym.Window;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

import static dev.aronba.opengym.Json.Json.saveWorkoutToJson;

public class Workout extends JPanel {

    WorkoutPage workoutPage;
    private final ArrayList<Exercise> exercises;
    JPanel content;
    Workout(WorkoutPage workoutPage){

        this.workoutPage = workoutPage;

        exercises = new ArrayList<>();

        content = new JPanel();
        content.setLayout(new BoxLayout(content,BoxLayout.Y_AXIS));

        setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();

        JScrollPane scrollPane= new JScrollPane(content);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane,BorderLayout.CENTER);

        JButton BtnAddExercise = new JButton("add Exercise");
        BtnAddExercise.addActionListener(actionEvent -> this.addExercise());
        jPanel.add(BtnAddExercise);

        JButton BtnFinishWorkout = new JButton("finish Wokrout");
        BtnFinishWorkout.addActionListener(actionEvent -> this.finish());
        jPanel.add(BtnFinishWorkout);

        add(jPanel,BorderLayout.SOUTH);

    }
    public void finish(){
        workoutPage.removeWorkout(this);
        saveWorkoutToJson(this);
    }
    public void addExercise(){
        Exercise t = new Exercise(this);
        exercises.add(t);
    }
    public void removeExercise(Exercise exercise){
        this.content.remove(exercise);
        exercises.remove(exercise);
        Window.refreshWindow();
    }
    public ArrayList<Exercise> getExercises() {
        return exercises;
    }
}
