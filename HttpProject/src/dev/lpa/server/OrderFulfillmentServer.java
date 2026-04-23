package dev.lpa.server;

import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static java.net.HttpURLConnection.HTTP_OK;

public class OrderFulfillmentServer {

    private static long visitorCounter = 0;

    public static void main(String[] args) {

        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080),
                    0);

            server.createContext("/", exchange -> {
                String reqParameters = exchange.getRequestURI().toString();
                System.out.printf("%s %s %s%n",
                        exchange.getRemoteAddress(),
                        exchange.getRequestMethod(),
                        reqParameters);
                String requestMethod = exchange.getRequestMethod();

                String data = new String(exchange.getRequestBody().readAllBytes());
                System.out.println("Body data: " + data);

                Map<String,String> parameters = parseParameters(data);
                System.out.println(parameters);

                var bytes = response.getBytes();
                exchange.sendResponseHeaders(HTTP_OK, bytes.length);
                exchange.getResponseBody().write(bytes);
                exchange.close();

            });

            server.start();
            System.out.println("Server is listening on port 8080...");

            } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, String> parseParameters(String requestBody) {

        Map<String, String> parameters = new HashMap<>();
        String[] pairs = requestBody.split("&");
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            if (keyValue.length == 2) {
                parameters.put(keyValue[0], keyValue[1]);
            }
        }
        return parameters;
    }
}
