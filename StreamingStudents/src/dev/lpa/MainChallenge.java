package dev.lpa;

import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class MainChallenge {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java");

                // cannot use as traditional for loop with post increment
//        List<Student> students = Stream
//                .iterate(1, s -> s <= 5000, s -> s++) // cannot use as s will increment only after the value is returned as result.
//                .limit(10)
//                .peek(System.out::println)
//                .map(s -> Student.getRandomStudent(jmc, pymc))
//                .toList();
//        List<Student> students = Stream
//                .iterate(1, s -> s <= 5000, s -> s + 1)
//                .limit(10)
//                .peek(System.out::println)
//                .map(s -> Student.getRandomStudent(jmc, pymc))
//                .toList();
        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        double totalPercent = students.stream()
                .mapToDouble(s -> s.getPercentComplete("JMC"))
//                .sum() // same as get sum but use reduce in this challenge
                .reduce(0, Double::sum); // get the sum of percent complete

        double avePercent = totalPercent / students.size(); // get the average
        System.out.printf("Average Percentage Complete = %.2f%% %n", avePercent);

        int topPercent = (int) (1.25 * avePercent); // find the percent of top student
        System.out.printf("Best Percentage Complete = %d%% %n", topPercent);

        Comparator<Student> longTermStudent
                = Comparator.comparing(Student::getYearEnrolled);

        List<Student> hardWorkers = students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0) // find active student
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
                .toList();

//        System.out.println("hardWorkers = "  + hardWorkers.size());
        hardWorkers.forEach(s -> {
            s.addCourse(jgames);
//            System.out.println(s);
            System.out.print(s.getStudentId() + " ");
        });

        System.out.println();

        Comparator<Student> uniqueSorted = longTermStudent.thenComparing(
                Student::getStudentId);

        students.stream()
                .filter(s -> s.getMonthsSinceActive("JMC") == 0) // find active student
                .filter(s -> s.getPercentComplete("JMC") >= topPercent)
                .sorted(longTermStudent)
                .limit(10)
//                .toList()
//                .collect(Collectors.toList()) // modifiable list
//                .collect(Collectors.toSet()) // set is not sort
//                .collect(() -> new TreeSet<>(uniqueSorted),
//                        TreeSet::add, TreeSet::addAll)
                .forEach(s -> {
            s.addCourse(jgames);
//            System.out.println(s);
            System.out.print(s.getStudentId() + " ");
        });

    }
}
