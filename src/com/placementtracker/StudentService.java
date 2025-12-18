package com.placementtracker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentService implements EligibilityCriteria {

    private ArrayList<PlacementStudent> students;

    public StudentService() {
        students = new ArrayList<>();
    }

    // Add student with marks validation
    public void addStudent(PlacementStudent student) throws InvalidMarksException {
        if(student.getMarks() < 0 || student.getMarks() > 100) {
            throw new InvalidMarksException("Marks must be between 0 and 100.");
        }
        students.add(student);
        
        // Auto-calculate eligibility for this student immediately
        isEligible(student);
    }

    @Override
    public boolean isEligible(PlacementStudent student) {
        // Basic criteria
        boolean basic = student.getMarks() >= 60 && student.getAttendance() >= 75;

        // Skill requirement: must include "java"
        boolean skillRequired = student.getSkills().toLowerCase().contains("java");

        if(basic && skillRequired) {
            student.setEligible(true);
            return true;
        } else {
            student.setEligible(false);
            return false;
        }
    }

    // Rank only eligible students
    public void rankStudents() {
        ArrayList<PlacementStudent> eligibleStudents = new ArrayList<>();
        for(PlacementStudent s : students) {
            if(s.isEligible()) eligibleStudents.add(s);
        }

        Collections.sort(eligibleStudents, Comparator.comparingDouble(PlacementStudent::getMarks).reversed());

        int rank = 1;
        for(PlacementStudent s : eligibleStudents) {
            s.setRank(rank++);
        }
    }

    public void displayAll() {
        for(PlacementStudent s : students) {
            s.display();
        }
    }

    public ArrayList<PlacementStudent> getStudents() {
        return students;
    }
}
