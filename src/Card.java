import javax.swing.*;
import java.util.ArrayList;

/*
 * Program for managing the cards and deck
 */

public class Card {
    //this JButton will be equivalent to the JButton that displays the card on the GUI
    JButton button = null;
    //string will lead to correct card image
    String cardFacePath = "";
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
    } //Card()

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
    } //Card()

    public int getValue() {
        return value;
    } //getValue()

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
    } //is13()

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
    } //initializeDeck()

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
    } //shuffleDeck()

    //asssignCardFacePaths() will take a deck and assign the paths to the pngs for each card face and return the deck
    private ArrayList<Card> assignCardFacePaths(ArrayList<Card> deck) {
        for (int i = 0; i < deck.size(); i++) {
            char suit = deck.get(i).getSuit();
            String rank = deck.get(i).getRank();
            switch (suit) {
                case 's':
                    switch (rank) {
                        case "A":
                            deck.get(i).setCardFacePath("cards/ace_of_spades.png");
                        case "2":
                            deck.get(i).setCardFacePath("cards/2_of_spades.png");
                        case "3":
                            deck.get(i).setCardFacePath("cards/3_of_spades.png");
                        case "4":
                            deck.get(i).setCardFacePath("cards/4_of_spades.png");
                        case "5":
                            deck.get(i).setCardFacePath("cards/5_of_spades.png");
                        case "6":
                            deck.get(i).setCardFacePath("cards/6_of_spades.png");
                        case "7":
                            deck.get(i).setCardFacePath("cards/7_of_spades.png");
                        case "8":
                            deck.get(i).setCardFacePath("cards/8_of_spades.png");
                        case "9":
                            deck.get(i).setCardFacePath("cards/10_of_spades.png");
                        case "10":
                            deck.get(i).setCardFacePath("cards/10_of_spades.png");
                        case "J":
                            deck.get(i).setCardFacePath("cards/jack_of_spades.png");
                        case "Q":
                            deck.get(i).setCardFacePath("cards/queen_of_spades.png");
                        case "K":
                            deck.get(i).setCardFacePath("cards/king_of_spades.png");
                    }
                case 'h':
                    switch (rank) {
                        case "A":
                            deck.get(i).setCardFacePath("cards/ace_of_hearts.png");
                        case "2":
                            deck.get(i).setCardFacePath("cards/2_of_hearts.png");
                        case "3":
                            deck.get(i).setCardFacePath("cards/3_of_hearts.png");
                        case "4":
                            deck.get(i).setCardFacePath("cards/4_of_hearts.png");
                        case "5":
                            deck.get(i).setCardFacePath("cards/5_of_hearts.png");
                        case "6":
                            deck.get(i).setCardFacePath("cards/6_of_hearts.png");
                        case "7":
                            deck.get(i).setCardFacePath("cards/7_of_hearts.png");
                        case "8":
                            deck.get(i).setCardFacePath("cards/8_of_hearts.png");
                        case "9":
                            deck.get(i).setCardFacePath("cards/10_of_hearts.png");
                        case "10":
                            deck.get(i).setCardFacePath("cards/10_of_hearts.png");
                        case "J":
                            deck.get(i).setCardFacePath("cards/jack_of_hearts.png");
                        case "Q":
                            deck.get(i).setCardFacePath("cards/queen_of_hearts.png");
                        case "K":
                            deck.get(i).setCardFacePath("cards/king_of_hearts.png");
                    }
                case 'd':
                    switch (rank) {
                        case "A":
                            deck.get(i).setCardFacePath("cards/ace_of_diamonds.png");
                        case "2":
                            deck.get(i).setCardFacePath("cards/2_of_diamonds.png");
                        case "3":
                            deck.get(i).setCardFacePath("cards/3_of_diamonds.png");
                        case "4":
                            deck.get(i).setCardFacePath("cards/4_of_diamonds.png");
                        case "5":
                            deck.get(i).setCardFacePath("cards/5_of_diamonds.png");
                        case "6":
                            deck.get(i).setCardFacePath("cards/6_of_diamonds.png");
                        case "7":
                            deck.get(i).setCardFacePath("cards/7_of_diamonds.png");
                        case "8":
                            deck.get(i).setCardFacePath("cards/8_of_diamonds.png");
                        case "9":
                            deck.get(i).setCardFacePath("cards/10_of_diamonds.png");
                        case "10":
                            deck.get(i).setCardFacePath("cards/10_of_diamonds.png");
                        case "J":
                            deck.get(i).setCardFacePath("cards/jack_of_diamonds.png");
                        case "Q":
                            deck.get(i).setCardFacePath("cards/queen_of_diamonds.png");
                        case "K":
                            deck.get(i).setCardFacePath("cards/king_of_diamonds.png");
                    }
                case 'c':
                    switch (rank) {
                        case "A":
                            deck.get(i).setCardFacePath("cards/ace_of_clubs.png");
                        case "2":
                            deck.get(i).setCardFacePath("cards/2_of_clubs.png");
                        case "3":
                            deck.get(i).setCardFacePath("cards/3_of_clubs.png");
                        case "4":
                            deck.get(i).setCardFacePath("cards/4_of_clubs.png");
                        case "5":
                            deck.get(i).setCardFacePath("cards/5_of_clubs.png");
                        case "6":
                            deck.get(i).setCardFacePath("cards/6_of_clubs.png");
                        case "7":
                            deck.get(i).setCardFacePath("cards/7_of_clubs.png");
                        case "8":
                            deck.get(i).setCardFacePath("cards/8_of_clubs.png");
                        case "9":
                            deck.get(i).setCardFacePath("cards/10_of_clubs.png");
                        case "10":
                            deck.get(i).setCardFacePath("cards/10_of_clubs.png");
                        case "J":
                            deck.get(i).setCardFacePath("cards/jack_of_clubs.png");
                        case "Q":
                            deck.get(i).setCardFacePath("cards/queen_of_clubs.png");
                        case "K":
                            deck.get(i).setCardFacePath("cards/king_of_clubs.png");
                    }
            }
        }
        return deck;
    } //assignCardFacePaths()

    public void setButton(JButton button) {
        this.button = button;
    } //setButton()

    public char getSuit() {
        return suit;
    } //getSuit()

    public String getRank() {
        return rank;
    } //getRank()

    public void setCardFacePath(String cardFacePath) {
        this.cardFacePath = cardFacePath;
    } //setCardFacePath()
}
