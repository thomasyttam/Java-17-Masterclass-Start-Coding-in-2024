package dev.lpa;

import javax.swing.*;
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

//            System.out.printf("%s %s!%n",
//                    rb.getString("hello"), rb.getString("world")); // key is case-sensitive

            String message = "%s %s!%n".formatted(
                    rb.getString("hello"), rb.getString("world")); // key is case-sensitive

            ResourceBundle ui = ResourceBundle.getBundle("UIComponents", l);

            JOptionPane.showOptionDialog(null, // use current window
                    message,
                    ui.getString("first.title"),
                    JOptionPane.DEFAULT_OPTION, // dialog with ok button
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
//                    null,
//                    new Object[]{ui.getString("btn.ok")}, //get button in different language
                    new Object[]{rb.getString("yes"), rb.getString("no")},
                    null);
        }

    }
}
