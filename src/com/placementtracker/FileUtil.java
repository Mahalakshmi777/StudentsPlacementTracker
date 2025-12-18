package com.placementtracker;

import java.io.*;
import java.util.ArrayList;

public class FileUtil {

    private static final String FILE_NAME = "students.dat";

    public static void saveToFile(ArrayList<PlacementStudent> students) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
            System.out.println("Data saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<PlacementStudent> loadFromFile() {
        ArrayList<PlacementStudent> students = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            students = (ArrayList<PlacementStudent>) ois.readObject();
            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("File not found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading file: " + e.getMessage());
        }
        return students;
    }
}
