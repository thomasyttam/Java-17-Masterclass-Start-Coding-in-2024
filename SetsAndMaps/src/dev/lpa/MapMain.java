package dev.lpa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapMain {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");

        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.forEach(System.out::println);
        System.out.println("-".repeat(40));

        Map<String, Contact> contacts = new HashMap<>();

        for (Contact contact : fullList) {
            contacts.put(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("-".repeat(40));
        System.out.println(contacts.get("Charlie Brown"));

        System.out.println(contacts.get("Chuck Brown"));

        Contact defaultContact = new Contact("Chuck Brown");
        System.out.println(contacts.getOrDefault("Chuck Brown", defaultContact));

        System.out.println("-".repeat(40));
        contacts.clear(); // clear all contacts
        // contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));
        for (Contact contact : fullList) {
            Contact duplicate = contacts.put(contact.getName(), contact);
            if (duplicate != null) {
//                System.out.println("duplicate = " + duplicate);
//                System.out.println(("current = " + contact));
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("-".repeat(40));
        contacts.clear(); // clear all contacts

        for (Contact contact : fullList) {
            contacts.putIfAbsent(contact.getName(), contact);
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("-".repeat(40));
        contacts.clear(); // clear all contacts

        for (Contact contact : fullList) {
            Contact duplicate = contacts.putIfAbsent(contact.getName(), contact);
            if (duplicate != null) {
                contacts.put(contact.getName(), contact.mergeContactData(duplicate));
            }
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("-".repeat(40));
        contacts.clear(); // clear all contacts
        fullList.forEach(contact -> contacts.merge(contact.getName(), contact,
//                (previous, current) -> previous.mergeContactData(current)
                Contact::mergeContactData
//                {
//                    System.out.println("prev: " + previous + " : current " + current);
//                    Contact merged = previous.mergeContactData(current);
//                    System.out.println("merged =  " + merged);
//                    return merged;
//                }
                ));
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        System.out.println("-".repeat(40));
        for(String contactName : new String[] {"Daisy Duck", "Daffy Duck",
                "Scrooge Duck"}) {
//            contacts.compute(contactName, (k, v) -> new Contact(k)); -> replace old contact with new one
            contacts.computeIfAbsent(contactName, (k) -> new Contact(k));
        }
        contacts.forEach((k, v) -> System.out.println("key = " + k + ", value = " + v));

        
    }
}
