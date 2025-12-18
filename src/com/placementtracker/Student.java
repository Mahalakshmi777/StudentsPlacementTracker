package com.placementtracker;

import java.io.Serializable;

public class Student implements Serializable {

    private int id;
    private String name;
    private double marks;
    private double attendance;
    private String skills;

    public Student(int id, String name, double marks, double attendance, String skills) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.attendance = attendance;
        this.skills = skills;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public double getAttendance() {
        return attendance;
    }

    public String getSkills() {
        return skills;
    }

    // Display student details
    public void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Attendance: " + attendance + "%");
        System.out.println("Skills: " + skills);
    }
}
