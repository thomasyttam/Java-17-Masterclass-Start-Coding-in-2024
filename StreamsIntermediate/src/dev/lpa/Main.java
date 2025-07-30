package dev.lpa;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main (String[] args) {


        IntStream.iterate((int) 'A', i -> i <= (int) 'z', i -> i + 1)
                .filter(Character::isAlphabetic) // filter non alphabet
                .map(Character::toUpperCase)
                .distinct()
//                .dropWhile(i -> Character.toUpperCase(i) <= 'E') // drop the element less than or equal to E until it is false
//                .takeWhile(i -> i < 'a') // take the element until i >= 'a'
//                .filter(i -> Character.toUpperCase(i) > 'E') // filter the element greater than E
//                .skip(5) // skip the first 5 elements from streams
//                .map(Character::toUpperCase)
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println();
        Random random = new Random();

        Stream.generate(() -> random.nextInt((int)'A', (int)'Z' + 1))
                .limit(50)
//                .distinct()
                .sorted()
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println();
        int maxSeats = 100;
        int seatsInRow = 10;
        var stream =
                Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                        .map(i -> new Seat((char) ('A' + i / seatsInRow),
                                i % seatsInRow + 1))
//                        .sorted(); // need comparator
                        .sorted(Comparator.comparing(Seat::price)
                                .thenComparing(Seat::toString)); // first compare price then string
/*                      First method to doubleStream and back to String
                        .mapToDouble(Seat::price)// map transfer integer to record Seat
                        .mapToObj("%.2f"::formatted); // Cannot convert java.lang.String to double
*/
/*                      Second method to doubleStream and back to String
                        .mapToDouble(Seat::price)
                        .boxed()
                        .map("%.2f"::formatted);
 */


        stream.forEach(System.out::println);
    }
}
