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
        System.out.println(keyView);    // auto get update the keyView

        var values = contacts.values();
        values.forEach(System.out::println);

        values.retainAll(ContactData.getData("email"));
        System.out.println(keyView);
        contacts.forEach((k, v) -> System.out.println(v));

        System.out.println("-".repeat(40));
        List<Contact> list = new ArrayList<>(values);
        list.sort(Comparator.comparing(Contact::getNameLastFirst));
        list.forEach(c -> System.out.println(c.getNameLastFirst() + ": " + c));

        System.out.println("-".repeat(40));
        Contact first = list.get(0);
        contacts.put(first.getNameLastFirst(), first); // same value, different key
        values.forEach(System.out::println);
        keyView.forEach(System.out::println);

        HashSet<Contact> set = new HashSet<>(values);
        set.forEach(System.out::println);
        if(set.size() < contacts.keySet().size()) {
            System.out.println("Duplicate Values are in my Map");
        }
    }
}
