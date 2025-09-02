package dev.lpa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try(FileReader reader = new FileReader("file.txt")) {
            char[] block = new char[1000]; // manuel create a buffer
            int data;
//            while ((data = reader.read()) != -1) { // read data by default, one integer at a time
            while ((data = reader.read(block)) != -1) { // read data by default, one integer at a time
                String content = new String(block, 0, data);
//                System.out.println(data);
//                System.out.println((char)data);
                System.out.printf("---> [%d chars] %s%n", data, content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("-----------------------------------");
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader("file.txt"))) {

            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
