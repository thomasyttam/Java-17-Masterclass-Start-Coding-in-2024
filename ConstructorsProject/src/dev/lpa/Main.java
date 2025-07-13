package dev.lpa;

import dev.external.Child;

public class Main {

    public static void main(String[] args) {

//        Parent parent = new Parent();
        Parent parent = new Parent("John Doe", "01/01/1950", 4);
        Parent parent2 = new Parent("John Doe", "01/01/1950", 4); // no static initializer is called
        Child child = new Child();

        System.out.println("Parent: " + parent);
        System.out.println("Child: " + child);
    }
}
