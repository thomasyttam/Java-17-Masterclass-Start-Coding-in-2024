package dev.lpa;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {

        for (Locale l : List.of(Locale.US, Locale.CANADA_FRENCH,
                Locale.CANADA)) {

            ResourceBundle rb = ResourceBundle.getBundle("BasicText", l); // l for Locale
//            System.out.println(rb.getClass().getName());
//            System.out.println(rb.getBaseBundleName());
//            System.out.println(rb.keySet());

            System.out.printf("%s %s!%n",
                    rb.getString("hello"), rb.getString("world")); // key is case-sensitive
        }

    }
}
