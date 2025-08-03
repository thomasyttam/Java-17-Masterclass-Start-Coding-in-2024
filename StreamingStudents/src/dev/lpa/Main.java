package dev.lpa;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass");
        Course jmc= new Course("JMC", "Java Masterclass");
//
//        Student tim = new Student("AU", 2019, 30, "M",
//                true, jmc, pymc);
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);
//
//        System.out.println();
//
//        Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
//                .limit(10)
//                .forEach(System.out::println);

        Student[] students = new Student[1000];
        Arrays.setAll(students, i -> Student.getRandomStudent(jmc, pymc));  // use same array for all questions

//        Remove below random stream
//        var maleStudents = Stream.generate(
//                () -> Student.getRandomStudent(jmc,pymc))
//                .limit(1000);
//        maleStudents.filter(s -> s.getGender().equals("M")); // need to use the reference of stream
//        maleStudents = maleStudents.filter(s -> s.getGender().equals("M"));

        var maleStudents = Arrays.stream(students)
                        .filter(s -> s.getGender().equals("M"));
        System.out.println("# of male students " + maleStudents.count());

        for (String gender : List.of("M", "F", "U")) { // pass list of "M", "F", "U" as elements
            var myStudents = Arrays.stream(students)
                    .filter(s -> s.getGender().equals(gender));
            System.out.println("# of " + gender + " students " + myStudents.count());
        }

        List<Predicate<Student>> list = List.of(
                (s) -> s.getAge() < 30, // first condition
                (Student s) -> s.getAge() >= 30 && s.getAge() < 60
        );

        long total = 0;
        for (int i = 0; i < list.size(); i++) {
            var myStudents = Arrays.stream(students).filter(list.get(i));
            long cnt = myStudents.count();
            total += cnt;
            System.out.printf("# of students (%s) = %d%n",
//                    i == 0 ? " < 30" : ">= 30 & < 60", cnt);
                    i == 0 ? "< 30" : ">= 30 & < 60", cnt);
        }
        System.out.println("# of students >= 60 = " + (students.length - total));

        var ageStream = Arrays.stream(students).
                mapToInt(Student::getAgeEnrolled);
        System.out.println("Stats for Enrollment Age = " + ageStream.summaryStatistics());

        var currentAgeStream = Arrays.stream(students).
                mapToInt(Student::getAge);
        System.out.println("Stats for Current Age = " +
                currentAgeStream.summaryStatistics());

        Arrays.stream(students)
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        boolean longTerm = Arrays.stream(students)
                .anyMatch(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12));
        System.out.println("longTerm students? " + longTerm);

        long longTermCount = Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12))
                .count();
        System.out.println("longTerm students? " + longTermCount);

        Arrays.stream(students)
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                        (s.getMonthsSinceActive() < 12))
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                // after toList, it is not a stream, it became a List
                .toList()
                .forEach(System.out::println);
    }
}
