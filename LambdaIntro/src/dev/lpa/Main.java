package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    record Person (String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>(Arrays.asList(
                new Person("Lucy", "Van Pelt"),
                new Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")));
    }
}
