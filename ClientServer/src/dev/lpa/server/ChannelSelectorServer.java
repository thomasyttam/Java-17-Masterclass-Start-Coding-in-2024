package dev.lpa.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class ChannelSelectorServer {

    public static void main(String[] args) {

        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.bind(new InetSocketAddress(5000));
            serverChannel.configureBlocking(false);
            Selector selector = Selector.open();
            serverChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException io) {
            System.out.println(io.getMessage());
        }
    }
}
