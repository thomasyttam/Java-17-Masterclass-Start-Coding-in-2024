package dev.lpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        List<Student> studentsThirdCopy = Collections.unmodifiableList(students); // return a view


        studentsFirstCopy.add(new Student("Bonnie", new StringBuilder()));
        // List.copyOf create a immutable list, but the element in the array still changed by bobsNotes.append
//        studentsSecondCopy.add(new Student("Bonnie", new StringBuilder())); // cannot modify as unmodified list, here is added
//        studentsSecondCopy.set(0, new Student("Bonnie", new StringBuilder())); // cannot modify as unmodified list, here is replace element 0
//        studentsSecondCopy.sort(Comparator.comparing(Student::getName)); // cannot modify as unmodified list, here is sorted
//        studentsThirdCopy.set(0, new Student("Bonnie", new StringBuilder())); // cannot modify as unmodified list, here is replace element 0
        studentsFirstCopy.sort(Comparator.comparing(Student::getName));
        students.add(new Student("Bonnie", new StringBuilder())); // only not affect second copy
        bobsNotes.append("Bob was one of my first students."); // change bob as change in bobsNotes for first and second copy

        StringBuilder bonniesNotes = studentsFirstCopy.get(2).getStudentNotes();
        bonniesNotes.append("Bonnie is taking 3 of my courses");

        students.forEach(System.out::println);
        System.out.println("-----------------------");
        studentsFirstCopy.forEach(System.out::println);
        System.out.println("-----------------------");
        studentsSecondCopy.forEach(System.out::println);
        System.out.println("-----------------------");
        studentsThirdCopy.forEach(System.out::println);
        System.out.println("-----------------------");

    }
}
