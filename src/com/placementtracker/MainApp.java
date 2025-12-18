package com.placementtracker;

import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentService service = new StudentService();

        // Load previous data
        service.getStudents().addAll(FileUtil.loadFromFile());

        boolean exit = false;

        while(!exit) {
            System.out.println("\n--- Student Placement Tracker ---");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Check Eligibility & Rank");
            System.out.println("4. Save & Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch(choice) {
                case 1:
                    try {
                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Name: ");
                        String name = sc.nextLine();
                        System.out.print("Marks: ");
                        double marks = sc.nextDouble();
                        System.out.print("Attendance: ");
                        double attendance = sc.nextDouble();
                        sc.nextLine();
                        System.out.print("Skills (comma separated): ");
                        String skills = sc.nextLine();

                        PlacementStudent student = new PlacementStudent(id, name, marks, attendance, skills);
                        service.addStudent(student);
                        System.out.println("Student added successfully!");
                    } catch (InvalidMarksException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    service.displayAll();
                    break;

                case 3:
                    for(PlacementStudent s : service.getStudents()) {
                        service.isEligible(s);
                    }
                    service.rankStudents();
                    System.out.println("Eligibility checked and ranks assigned!");
                    break;

                case 4:
                    FileUtil.saveToFile(service.getStudents());
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
        System.out.println("Thank you for using Student Placement Tracker!");
    }
}
