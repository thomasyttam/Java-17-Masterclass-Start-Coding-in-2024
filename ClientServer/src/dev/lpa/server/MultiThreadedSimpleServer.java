package dev.lpa.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadedSimpleServer {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        try (ServerSocket serverSocket = new ServerSocket(5000)) {

            // close a server socket mean won't accept new connection, not automatically close existing connection
            // The input and output streams get closed when the socket connection is closed

            while (true) {
//                try (Socket socket = serverSocket.accept();) //the application block here to wait client connection, occur once, no way for second client
                Socket socket = serverSocket.accept();
                System.out.println("Server accepts client connection");
                socket.setSoTimeout(900_000);
                executorService.submit(() -> handleClientRequest(socket));

                /* Move to handleClientRequest method below
                    BufferedReader input = new BufferedReader(
                            new InputStreamReader(socket.getInputStream())); // get client input
                    PrintWriter output =
                            new PrintWriter(socket.getOutputStream(), true); // output, autoflush true

                    while (true) {
                        String echoString = input.readLine(); // blocking method, block here unit client send a request
                        System.out.println("Server got request data: " + echoString);
                        if (echoString.equals("exit")) {
                            break;
                        }
                        output.println("Echo from server: " + echoString);
                    } */
//                } catch (IOException e) {
//                    System.out.println("client socket resources closed here");
//                }
            }
        } catch (IOException e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }

    private static void handleClientRequest(Socket socket) {

        try (socket;
             BufferedReader input = new BufferedReader(
                     new InputStreamReader(socket.getInputStream())); // get client input
             PrintWriter output =
                     new PrintWriter(socket.getOutputStream(), true); // output, autoflush true
        ) {
            while (true) {
                String echoString = input.readLine(); // blocking method, block here unit client send a request

                System.out.println("Server got request data: " + echoString);
                if (echoString.equals("exit")) {
                    break;
                }
                output.println("Echo from server: " + echoString);
            }
        } catch (Exception e) {
            System.out.println("Client socket shut down here");
        }

    }
}
