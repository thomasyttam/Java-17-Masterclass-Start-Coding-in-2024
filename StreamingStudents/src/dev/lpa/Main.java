package dev.lpa;

import java.util.Arrays;
import java.util.stream.Stream;

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
        Arrays.setAll(students, i -> Student.getRandomStudent(jmc, pymc));

        var maleStudents = Stream.generate(
                () -> Student.getRandomStudent(jmc,pymc))
                .limit(1000);
        maleStudents = maleStudents.filter(s -> s.getGender().equals("M"));

        System.out.println("# of male students " + maleStudents.count());
    }
}
