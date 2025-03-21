package dev.lpa;

import dev.lpa.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {

    public static void main(String[] args) {

        List<StoreEmployee> storeEmployees = new ArrayList<>(List.of(
                new StoreEmployee(10015, "Mag", 2019,
                        "Target"),
                new StoreEmployee(10515, "Joe", 2021,
                        "Walmart"),
                new StoreEmployee(10105, "Tom", 2020,
                        "Macys"),
                new StoreEmployee(10215, "Marty", 2018,
                        "Walmart"),
                new StoreEmployee(10322, "Bud", 2016,
                        "Target")));
    }

    public static <T> void sortIt (List<T> list,
                                   Comparator<? super T> comparator){
        System.out.println("Sorting with Comparator: " + comparator.toString());
    }
}
