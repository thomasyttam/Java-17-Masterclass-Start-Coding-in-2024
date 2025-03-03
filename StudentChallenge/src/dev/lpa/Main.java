package dev.lpa;

import dev.lpa.model.LPAStudent;
import dev.lpa.util.QueryList;

import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        QueryList<LPAStudent> queryList = new QueryList<>();
        for (int i = 0; i < 5; i++) {
            queryList.add(new LPAStudent());
        }

        System.out.println("Order");
        queryList.sort(null);
        queryList.sort(Comparator.naturalOrder());
    }

    public static void printList(List<?> students) {

        for(var student : students) {
            System.out.println(student);
        }
    }
}