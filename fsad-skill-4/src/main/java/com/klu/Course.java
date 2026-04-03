package com.klu;
public class Course {
    private String courseName;
    private int duration;   // duration in months
    // Constructor Injection
    public Course(String courseName, int duration) {
        this.courseName = courseName;
 this.duration = duration;
    }
    // Getters (optional but good practice)
    public String getCourseName() {
        return courseName;
    }
    public int getDuration() {
        return duration;
    }
@Override
    public String toString() {
        return courseName + " (" + duration + " months)";
    }
}
