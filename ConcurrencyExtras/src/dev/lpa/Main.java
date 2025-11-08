package dev.lpa;

import java.util.Random;
import java.util.concurrent.ConcurrentSkipListSet;

record Student(String name, int enrolledYear, int studentId)
        implements Comparable<Student> {

    @Override
    public int compareTo(Student o) {
        return this.studentId - o.studentId;
    }
}

class StudentId {

    private int id = 0;

    public int getId() {
        return id;
    }

    public synchronized int getNextId() {
        return ++id;
    }
}

public class Main {

    private static Random random = new Random();

    private static ConcurrentSkipListSet<Student> studentSet =
            new ConcurrentSkipListSet<>();

    public static void main(String[] args) {

    }
}
