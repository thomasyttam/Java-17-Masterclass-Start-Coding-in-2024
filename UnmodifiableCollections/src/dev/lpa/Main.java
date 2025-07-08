package dev.lpa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Bill struggles with generics");

        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);

        List<Student> students = new ArrayList<>(List.of(bob, bill));
        List<Student> studentsFirstCopy = new ArrayList<>(students); // pass a list of constructor create a shallow copy
        List<Student> studentsSecondCopy = List.copyOf(students);

        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder()));
        studentsSecondCopy.add(new Student("Bonnie", new StringBuilder())); // cannot modify as unmodified list
        bobsNotes.append("Bob was one of my first students."); // change bob as change in bobsNotes

        StringBuilder bonniesNotes = studentsFirstCopy.get(2).getStudentNotes();
        bonniesNotes.append("Bonnie is taking 3 of my courses");

        students.forEach(System.out::println);
        System.out.println("-----------------------");
        studentsFirstCopy.forEach(System.out::println);
        System.out.println("-----------------------");
        studentsSecondCopy.forEach(System.out::println);
        System.out.println("-----------------------");
    }
}
