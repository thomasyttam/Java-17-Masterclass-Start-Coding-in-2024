package dev.lpa.server;

import java.io.IOException;
import java.net.ServerSocket;

public class SimpleServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
