package dev.lpa;

public class BookingAgent {

    public static void main(String[] args) {

        int rows = 10;
        int totalSeats = 100;
        Theatre rodgersNYC = new Theatre("Richard Rogers",
                rows, totalSeats);
        rodgersNYC.printSeatMap();
    }
}
