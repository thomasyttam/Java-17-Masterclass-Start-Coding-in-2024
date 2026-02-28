package dev.lpa.server;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

public class SimpleServerChannel {

    public static void main(String[] args) {

        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.socket().bind(new InetSocketAddress(5000));

            System.out.println("Server is listening on port " +
                    serverChannel.socket().getLocalPort());
        } catch (Exception e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
