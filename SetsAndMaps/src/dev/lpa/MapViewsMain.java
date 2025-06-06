package dev.lpa;

import java.util.*;

public class MapViewsMain {

    public static void main(String[] args) {

        Map<String, Contact> contacts = new HashMap<>();
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));

        Set<String> keyView = contacts.keySet();    // not in order
        System.out.println(keyView);

        Set<String> copyOfKeys = new TreeSet<>(contacts.keySet());  // in order
        System.out.println(copyOfKeys);

        if(contacts.containsKey("Linus Van Pelt")) {
            System.out.println("Linus and I go way back, so of cause I have info");
        }

        keyView.remove("Daffy Duck");   // remove the key and value in contacts
        System.out.println(keyView);
        contacts.forEach((k, v) -> System.out.println(v));

        copyOfKeys.remove("Linus Van Pelt");    // not remove the key and value in contacts as it is copy
        System.out.println(copyOfKeys);
        contacts.forEach((k, v) -> System.out.println(v));

        keyView.retainAll(List.of("Linus Van Pelt", "Charlie Brown",
                "Robin Hood", "Mickey Mouse"));   // retains the key and value in contacts
        System.out.println(keyView);
        contacts.forEach((k, v) -> System.out.println(v));

        keyView.clear(); // clear all keys and value
        System.out.println(contacts);

//        keyView.add("Daffy Duck"); -> cannot add, en exception occur when run, only keys no value
//        System.out.println(contacts);

        ContactData.getData("email").forEach(c -> contacts.put(c.getName(), c));
        ContactData.getData("phone").forEach(c -> contacts.put(c.getName(), c));
        System.out.println(keyView);    // auto get update the keyview
    }
}
