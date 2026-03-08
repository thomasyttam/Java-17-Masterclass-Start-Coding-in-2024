package dev.lpa.server;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

public class SimpleServerChannel {

    public static void main(String[] args) {

        try (ServerSocketChannel serverChannel = ServerSocketChannel.open()) {
            serverChannel.socket().bind(new InetSocketAddress(5000));

            System.out.println("Server is listening on port " +
                    serverChannel.socket().getLocalPort());

            List<SocketChannel> clientChannels = new ArrayList<>();

            while (true) {
                System.out.println("Waiting to connect to another client");
                SocketChannel clientChannel = serverChannel.accept();
                clientChannels.add(clientChannel);
                System.out.printf("Client %s connected%n",
                        clientChannel.socket().getRemoteSocketAddress());

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                SocketChannel channel = clientChannel;
                System.out.println("Waiting on client request data");
                int readBytes = channel.read(buffer);

                if (readBytes > 0) {
                    buffer.flip(); // flip the buffer state from writeable to readble

                    channel.write(ByteBuffer.wrap("Echo from server: ".getBytes()));
                    while (buffer.hasRemaining()) {
                        channel.write(buffer);
                    }
                    buffer.clear();
                } else if (readBytes == -1) {
                    System.out.printf("Connection to %s lost%n",
                            channel.socket().getRemoteSocketAddress());
                    channel.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Server exception " + e.getMessage());
        }
    }
}
