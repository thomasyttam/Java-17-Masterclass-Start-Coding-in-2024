package dev.lpa.games.poker;

import dev.lpa.Card;

import java.util.ArrayList;
import java.util.List;

public class PokerHand {

    private List<Card> hand;
    private List<Card> keepers;
    private List<Card> discards;
    private Ranking score = Ranking.NONE;
    private int playerNO;

    public PokerHand(int playerNO, List<Card> hand) {
        hand.sort(Card.sortRankReversedSuit());
        this.hand = hand;
        this.playerNO = playerNO;
        keepers = new ArrayList<>(hand.size());
        discards = new ArrayList<>(hand.size());
    }

    @Override
    public String toString() {
        return "%d. %-16s Rank%d %-40s %s".formatted(
                playerNO, score, score.ordinal(), hand,
                (discards.size() > 0) ? "Discards:" + discards : "");
    }
}
