import java.util.ArrayList;

public class Card {

    //value will range from 1-13
    int value = 0;
    //suit will be s, c, h, or d
    char suit = ' ';
    //rank will include 1-9, A, J, Q, and K
    // 1-9 actually represent 2-10. ex: '1' means a 2 card
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

    //initializeDeck() will initialize a deck in order, not shuffled
    //a deck is an arraylist of card objects
    public ArrayList<Card> initializeDeck() {
        char[] suits= new char[]{'c', 'd', 'h', 's'};
        String[] ranks = new String[]{"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        ArrayList<Card> deck = new ArrayList<Card>();
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
