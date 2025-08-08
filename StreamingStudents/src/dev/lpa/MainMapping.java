package dev.lpa;

import java.util.List;
import java.util.stream.IntStream;
// import java.util.stream.Collectors;
import static java.util.stream.Collectors.*;

;

public class MainMapping {

    public static void main(String[] args) {

        Course pymc= new Course("PYMC", "Python Masterclass", 50);
        Course jmc= new Course("JMC", "Java Masterclass", 100);
        Course jgames = new Course("JGAME", "Creating games in Java");

        List<Student> students = IntStream
                .rangeClosed(1, 5000)
                .mapToObj(s -> Student.getRandomStudent(jmc, pymc))
                .toList();

        // return Map <String, List<Student>>
        var mappedStudents = students.stream()
                .collect(groupingBy(Student::getCountryCode));

        mappedStudents.forEach((k, v) -> System.out.println(k + " " + v.size()));

        System.out.println("-----------------------");
        int minAge = 25;

        // import static stream Collectors method
        var youngerSet = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        filtering(s -> s.getAge() <= minAge , toList())));

        youngerSet.forEach((k, v) -> System.out.println(k + " " + v.size()));

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        System.out.println("Experienced Students = " + experienced.get(true).size());
        System.out.println("Non-Experienced Students = " + experienced.get(false).size());

        var expCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));
        System.out.println("Experienced Students = " + expCount.get(true));

        var experiencedAndActive = students.stream()
                .collect(partitioningBy(
                        s -> s.hasProgrammingExperience()
                                && s.getMonthsSinceActive() == 0,
                        counting()));
        System.out.println("Experienced and Active Students = " +
                experiencedAndActive.get(true));

        // return Map<String, Map<String, List<Student>>>
        var multiLevel = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                        groupingBy(Student::getGender)));

        multiLevel.forEach((key, value) -> { //key country code
            System.out.println(key);
            value.forEach((key1, value1) -> // key gender
                    System.out.println("\t" + key1 + " " + value1.size()));
        });

        long studentBodyCount = 0;
        for (var list : experienced.values()) {
            studentBodyCount += list.size(); // add size of each list
        }
        System.out.println("studentBodyCount = " + studentBodyCount);

        studentBodyCount = experienced.values().stream()
                // count each list size
                .mapToInt(l -> l.size())
                .sum();
        System.out.println("studentBodyCount = " + studentBodyCount);

        studentBodyCount = experienced.values().stream()
                .map(l -> l.stream() // Stream<Stream<Student>>
                        .filter(s -> s.getMonthsSinceActive() <= 3)
                        .count() // Stream<Long>
                )
                .mapToLong(l -> l)
                .sum();
        System.out.println("studentBodyCount = " + studentBodyCount);

        long count = experienced.values().stream()
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students = " + count);

        count = multiLevel.values().stream()
//                .flatMap(map -> map.values().stream()) //Stream<List<Student>>
//                .flatMap(map -> map.stream())//Stream<Student>
                .flatMap(map -> map.values().stream()
                        .flatMap(l -> l.stream())
                )
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students in multiLevel = " + count);

        count = multiLevel.values().stream()
                .flatMap(map -> map.values().stream())
                .flatMap(l -> l.stream())
                .filter(s -> s.getMonthsSinceActive() <= 3)
                .count();
        System.out.println("Active Students in multiLevel = " + count);
    }
}
