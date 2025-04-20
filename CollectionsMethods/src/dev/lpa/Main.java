package dev.lpa;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        //        Card.printDeck(Card.getStandardDeck());

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

        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled Deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed Deck of Cards", 4);

        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        Collections.sort(deck, sortingAlgorithm);
        Card.printDeck(deck, "Standard Deck sorted by rank, suit", 13);

        Collections.reverse(deck);
        Card.printDeck(deck, "Sorted by rank, suit reversed", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4, 8));
        Card.printDeck(kings, "Kings in deck", 1);

        List<Card> tens = new ArrayList<>(deck.subList(16, 20));
        Card.printDeck(tens, "Tens in deck", 1);

        int subListIndex = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex);
        System.out.println("Contains = " + deck.containsAll(tens));

        Collections.shuffle(deck);
        int subListIndex2 = Collections.indexOfSubList(deck, tens);
        System.out.println("sublist index for tens = " + subListIndex2); // cannot find since shuffle
        System.out.println("Contains = " + deck.containsAll(tens)); // true, still find all elements in tens

        boolean disjoint = Collections.disjoint(deck, tens);
        System.out.println("disjoint = " + disjoint);

        boolean disjoint2 = Collections.disjoint(kings, tens);
        System.out.println("disjoint = " + disjoint2);


    }
}
