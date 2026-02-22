package dev.lpa.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            // close a server socket mean won't accept new connection, not automatically close existing connection
            // The input and output streams get closed when the socket connection is closed
            try (Socket socket = serverSocket.accept();) //the application block here to wait client connection
            {
                BufferedReader input = new BufferedReader(
                        new InputStreamReader(socket.getInputStream())); // get client input
                PrintWriter output =
                        new PrintWriter(socket.getOutputStream(), true); // output, autoflush true

                while (true) {
                    String echoString = input.readLine();
                    System.out.println("Server got request data: " + echoString);
                    if (echoString.equals("exit")) {
                        break;
                    }
                    output.println("Echo from server: " + echoString);
                }
            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
