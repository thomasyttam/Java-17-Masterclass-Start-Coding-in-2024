package dev.lpa;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        private final static String CONN_STRING = "jdbc:mysql://localhost:3306/music";

        String username = JOptionPane.showInputDialog(
                null, "Enter DB Username");

        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf,
                "Enter DB Password", JOptionPane.OK_CANCEL_OPTION);
        final char[] password =
                (okCxl == JOptionPane.OK_OPTION) ? pf.getPassword() : null;
    }
}
