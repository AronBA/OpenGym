package dev.aronba.opengym.Calculator;

import javax.swing.*;

public class CalculatorPage extends JPanel {
    public CalculatorPage() {
        // Age
        add(new JSpinner());
        // Gender
        add(new JCheckBox());
        add(new JCheckBox());
        // Height
        add(new JSpinner());
        // Weight
        add(new JSpinner());
        // Activity
        add(new JSlider());
    }
}
