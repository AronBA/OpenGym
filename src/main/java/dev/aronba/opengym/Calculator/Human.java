package dev.aronba.opengym.Calculator;

public class Human {
    private int age;
    private char gender;
    private int height;
    private int weight;
    public Human(int age, char gender, int height, int weight) {
        this.age = age;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
    }
    public int getCalories() {
        int calories = (int) Math.round((weight * 10) + (height * 6.25) - (age * 5));
        if (gender == 'm') {
            // 10W + 6.25H - 5A + 5
            calories += 5;
        }
        else {
            // 10W + 6.25H - 5A - 161
            calories -= 161;
        }
        return calories;
    }

}
