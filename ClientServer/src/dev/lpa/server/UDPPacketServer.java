package dev.lpa.server;

import java.io.IOException;
import java.net.DatagramSocket;

public class UDPPacketServer {

    private static final int PORT = 5000;
    private static final int PACKET_SIZE = 1024;

    public static void main(String[] args) {

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
