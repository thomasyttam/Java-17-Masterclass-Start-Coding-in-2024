package dev.lpa;

import java.net.URI;
import java.net.http.HttpClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConcurrentRequests {

    public static void main(String[] args) {

        Map<String,Integer> orderMap =
                Map.of( "apples", 500,
                        "oranges", 1000,
                        "bananas", 750,
                        "carrots", 2000,
                        "cantaloupes", 100 );

        String urlparams = "product=%s&amount=%d";

        String urlBase = "http://localhost:8080";

        List<URI> sites = new ArrayList<>();
        orderMap.forEach( (k,v) -> sites.add(URI.create(
                urlBase + "?" + urlparams.formatted(k, v)
        )));

        HttpClient client = HttpClient.newHttpClient();
    }
}
