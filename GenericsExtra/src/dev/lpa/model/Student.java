package dev.lpa.model;

import java.util.Random;

public class Student {

    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();

    private static String[] firstNames = {"Ann", "Bill", "Cathy", "John", "Tim"};
    private static String [] courses = {"C++", "Java", "Python"};
}
