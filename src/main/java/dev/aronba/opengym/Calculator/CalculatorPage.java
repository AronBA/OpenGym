package dev.aronba.opengym.Calculator;

import javax.swing.*;
import java.awt.*;

public class CalculatorPage extends JPanel {
    private static Human human;
    public CalculatorPage() {
        JSpinner ageSpinner = new JSpinner(getModel(15, 80));
        ageSpinner.setValue(25);

        ButtonGroup bg = new ButtonGroup();
        JRadioButton male = new JRadioButton("M");
        JRadioButton female = new JRadioButton("F");
        bg.add(male);
        bg.add(female);
        JPanel genderPanel = new JPanel();
        genderPanel.add(male);
        genderPanel.add(female);

        JSpinner heightSpinner = new JSpinner(getModel(0, 300));
        heightSpinner.setValue(175);


        JSpinner weightSpinner = new JSpinner();
        weightSpinner.setValue(80);


        JLabel calorieLabel = new JLabel();

        JButton calculateButton = new JButton("Calculate");
        calculateButton.addActionListener((l) -> {
            char gender = 'm';
            if (female.isSelected()) gender = 'f';
            human = new Human((int)ageSpinner.getValue(), gender, (int)heightSpinner.getValue(), (int) weightSpinner.getValue());
            calorieLabel.setText("Calories: " + human.getCalories());
        });
        setLayout(new GridLayout(6, 2));
        add(new Label("Age"));
        add(ageSpinner);
        add(new Label("Gender"));
        add(genderPanel);
        add(new Label("Height(cm)"));
        add(heightSpinner);
        add(new Label("Weight(kg)"));
        add(weightSpinner);
        add(calculateButton);
        add(calorieLabel);
    }
    private SpinnerNumberModel getModel(int min, int max) {
        SpinnerNumberModel model = new SpinnerNumberModel();
        model.setMinimum(min);
        model.setMaximum(max);
        return model;
    }
}
