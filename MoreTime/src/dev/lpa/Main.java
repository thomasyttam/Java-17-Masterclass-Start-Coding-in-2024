//        ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
package dev.lpa;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;

public class Main {

    public static void main(String[] args) {

        System.setProperty("user.timezone", "America/Los_Angeles"); // set the system time zone
        System.out.println(ZoneId.systemDefault());

        System.out.println("Number of TZs = " + ZoneId.getAvailableZoneIds().size());

        ZoneId.getAvailableZoneIds().stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("-".repeat(30));
        ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.startsWith("Australia"))
                .sorted()
                .forEach(System.out::println);


        System.out.println("-".repeat(30));
        ZoneId.getAvailableZoneIds().stream()
                .filter(s -> s.startsWith("US"))
                .sorted()
                .map(ZoneId::of)
                .forEach(z -> System.out.println(z.getId() + ": " + z.getRules()));

        System.out.println("-".repeat(30));
        Set<String> jdk8Zones = ZoneId.getAvailableZoneIds();
        String[] alternate = TimeZone.getAvailableIDs();
        Set<String> oldway = new HashSet<>(Set.of(alternate));

//        jdk8Zones.removeAll(oldway); // oldway include all in jdk8Zones
//        System.out.println(jdk8Zones);
        oldway.removeAll(jdk8Zones); // jdk8Zones does not include all in oldway
        System.out.println(oldway);
        ZoneId bet = ZoneId.of("BET", ZoneId.SHORT_IDS);
        System.out.println(bet);

        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);

        Instant instantNow = Instant.now(); // zero offset of time from UTC
        System.out.println(instantNow);
    }
}
