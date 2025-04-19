package dev.lpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        //        Card.printDeck(Card.getStandardDeck());

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Card[] cardArray = new Card[13];
        Card aceOfHearts = Card.getFaceCard(Card.Suit.HEART, 'A');
        Arrays.fill(cardArray, aceOfHearts);
        Card.printDeck(Arrays.asList(cardArray), "Aces of Hearts", 1);

        List<Card> cards = new ArrayList<>(52); // 52 will not set 52 null elements, size still zero
        Collections.fill(cards, aceOfHearts); // replace the element, but size still zero
        System.out.println(cards);
        System.out.println("cards.size() = " + cards.size());

        List<Card> acesOfHearts = Collections.nCopies(13, aceOfHearts);
        Card.printDeck(acesOfHearts, "Aces of Hearts", 1);

        Card kingOfClubs = Card.getFaceCard(Card.Suit.CLUB, 'K');
        List<Card> kingsOfClubs = Collections.nCopies(13, kingOfClubs);
        Card.printDeck(kingsOfClubs, "Kings of Clubs", 1);

        Collections.addAll(cards, cardArray); // addAll will increase the size of cards
        Collections.addAll(cards, cardArray);
        Card.printDeck(cards, "Card Collection wih Aces added", 2);

        Collections.copy(cards, kingsOfClubs); // copy will not increase the size of cards
        Card.printDeck(cards, "Card Collection wih Kings copies", 2);
        System.out.println("cards.size() = " + cards.size());

        cards = List.copyOf(kingsOfClubs); //this method returns an unmodifiable list
        Card.printDeck(cards, "List Copy of Kings", 2);
        System.out.println("cards.size() = " + cards.size());
    }
}
