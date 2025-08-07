package dev.lpa;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainTerminalOptional {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(pymc, jmc))
                        .limit(1000)
                        .toList();

//        int minAge = 21;
//        int minAge = 17; // not found
        int minAge = 18;

        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .findAny()// findAny not mandatory return the first finding, if need first finding, use findFirst
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n",
                                s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .findFirst()
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n",
                                s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        // sorted by ascending order by age, find first get youngest one
        students.stream()
                .filter(s -> s.getAge() <= minAge)
                // below 2 line replace by min(...)
//                .sorted(Comparator.comparing(Student::getAge)) // sorted by ascending order by age, find first get youngest one
//                .findFirst()
                .min(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n",
                                s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .max(Comparator.comparing(Student::getAge))
                .ifPresentOrElse(s -> System.out.printf("Student %d from %s is %d%n",
                                s.getStudentId(), s.getCountryCode(), s.getAge()),
                        () -> System.out.println("Didn't find anyone under " + minAge));

        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .mapToInt(Student::getAge)
                // get the average from IntStream and return OptionalDouble
                .average()
                .ifPresentOrElse(a -> System.out.printf("Avg age under 21: %.2f%n", a),
                        ()-> System.out.println("Didn't find anyone under " + minAge));

        students.stream()
                .filter(s -> s.getAge() <= minAge)
                .map(Student::getCountryCode)
                .distinct()
                .reduce((a, b) -> String.join(",", a, b))
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("None found"));

//        Change to the code below
//        List<String> countries = students.stream()
//                .map(Student::getCountryCode)
//                .distinct()
//                .toList();
//
//        Optional.of(countries)
//                .map(l -> String.join(",", l))
//                .filter(l -> l.contains("FR"))
//                .ifPresentOrElse(System.out::println,
//                        () -> System.out.println("Missing FR"));
//
        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .map(l -> String.join(",", l))
                .filter(l -> l.contains("AU"))
                .findAny()
                .ifPresentOrElse(System.out::println,
                        () -> System.out.println("Missing AU"));
    }
}
