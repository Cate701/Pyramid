import java.util.ArrayList;

/*
 * Program for managing the cards and deck
 */

public class Card {
    //value will range from 1-13
    int value = 0;
    //suit will be s, c, h, or d
    char suit = ' ';
    //rank will include 2-10, A, J, Q, and K
    String rank = "";
    int deckSize = 64;
    public Card(int value, char suit, String rank) {
        this.value = value;
        this.suit = suit;
        this.rank = rank;
    }

    public Card(char suit, String rank) {
        this.suit = suit;
        this.rank = rank;
        //using ASCII chart
        if (rank.equals("A")) {
            value = 1;
        } else if (rank.equals("J")) {
            value = 11;
        } else if (rank.equals("Q")) {
            value = 12;
        } else if (rank.equals("K")) {
            value = 13;
        } else {
            value = Integer.parseInt(rank);
        }
    }

    public int getValue() {
        return value;
    }

    //is13 will take two cards and return a boolean if the two values added equals 13
    //for kings, the value is already 13 so Card two will be null
    public boolean is13(Card one, Card two) {
        if (one == null) {
            return false;
        } else if (two == null) {
            if (one.getValue() == 13) {
                return true;
            } else {
                return false;
            }
        } else return one.getValue() + two.getValue() == 13;
    }

    //initializeDeck() will initialize a deck in order, not shuffled
    //a deck is an arraylist of card objects
    public ArrayList<Card> initializeDeck() {
        char[] suits = {'c', 'd', 'h', 's'};
        String[] ranks = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        ArrayList<Card> deck = new ArrayList<Card>(); // will be filled and returned
        for (char suit : suits) {
            for (String rank : ranks) {
                Card c = new Card(suit, rank);
                deck.add(c);
            }
        }
        return deck;
    }

    //shuffleDeck() will shuffle the card order using math.random
    public ArrayList<Card> shuffleDeck(ArrayList<Card> oldDeck) {
        ArrayList<Card> newDeck = new ArrayList<Card>(deckSize);

        for (int i = 0; i < deckSize; i++) {
            int randNum = (int)(Math.random() * (deckSize - 1));
            while (newDeck.get(randNum) != null) {
                randNum = (int)(Math.random() * (deckSize - 1));
            }
            newDeck.add(randNum, oldDeck.get(i));
        }
        return newDeck;
    }

}
