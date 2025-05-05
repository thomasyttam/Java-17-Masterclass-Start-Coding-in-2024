package dev.lpa;

import java.util.Objects;

public class PlayingCard {

    private String suit;
    private String face;
    private int internalHash;

    public PlayingCard(String suit, String face) {
        this.suit = suit;
        this.face = face;
//        this.internalHash = 1;
        this.internalHash = (suit.equals("Hearts")) ? 11 : 12;
    }

    @Override
    public String toString() {
        return face + " of " + suit;
    }

//    @Override
////    public int hashCode() {
//////        return super.hashCode();
////        return internalHash;
////    }
////
////    @Override
////    public boolean equals(Object obj) {
//////        return super.equals(obj);
////        System.out.println("---> Checking Playing Card equality");
////        return true;
////    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlayingCard that = (PlayingCard) o;
        return Objects.equals(suit, that.suit) && Objects.equals(face, that.face);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(suit);
        result = 31 * result + Objects.hashCode(face);
        return result;
    }
}
