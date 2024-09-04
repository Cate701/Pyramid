import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

/*
 * Program for displaying the GUI
 *
 */

public class GUI extends JComponent implements Runnable {

    //using a dictionary to map the buttons to cards
    Dictionary<JButton, Card> buttonMap= new Hashtable<>();
    ArrayList<Card> deck = new ArrayList<>();
    int NUM_CARDS_IN_PYRAMID = 28;
    String welcome = "Welcome to Pyramid!";
    JFrame frame = new JFrame("Pyramid");
    JButton next;
    JButton play;
    JButton rules;
    JButton quit;
    JButton flipAndReset;
    JButton returnToMenu;
    JButton deckCard;


    //The R-- JButtons represent card placements on the board.
    // ex: R21 is the second row, first card (left to right, top to bottom)
    JButton R1;
    JButton R21;
    JButton R22;
    JButton R31;
    JButton R32;
    JButton R33;
    JButton R41;
    JButton R42;
    JButton R43;
    JButton R44;
    JButton R51;
    JButton R52;
    JButton R53;
    JButton R54;
    JButton R55;
    JButton R61;
    JButton R62;
    JButton R63;
    JButton R64;
    JButton R65;
    JButton R66;
    JButton R71;
    JButton R72;
    JButton R73;
    JButton R74;
    JButton R75;
    JButton R76;
    JButton R77;

    JPanel introMessage = new JPanel();
    JPanel nextButton = new JPanel();

    Container content = frame.getContentPane();

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next) {
                mainMenu();
            } else if (e.getSource() == play) {
                startGame();
            } else if (e.getSource() == rules) {
                rules();
            } else if (e.getSource() == quit) {
                quit();
            }
        }
    };

    //sets up the initial welcome screen for the game
    public void run() {

        JLabel welcomeText = new JLabel(welcome);
        welcomeText.setFont(new Font("Serif", Font.PLAIN, 40));

        next = new JButton("Next");
        next.addActionListener(actionListener);
        next.setFont(new Font("Serif", Font.PLAIN, 20));

        introMessage.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 20));
        introMessage.add(welcomeText);
        introMessage.setBounds(0, 150, 600, 100);

        nextButton.add(next);
        nextButton.setBounds(0, 250, 600, 100);

        content.add(introMessage);
        content.add(nextButton);
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    //this function will display the main menu of the game
    //menu includes play, rules, and quit buttons
    private void mainMenu() {
        //resetting the screen
        content.removeAll();
        content.repaint();

        //putting together main menu
        //currently there are two panels, "Main Menu" and the button options
        JLabel mainMenu = new JLabel("Main Menu");
        mainMenu.setFont(new Font("Serif", Font.PLAIN, 40));

        JPanel topLabel = new JPanel();
        topLabel.add(mainMenu);
        topLabel.setBounds(0, 100, 600, 100);

        play = new JButton("Play");
        play.addActionListener(actionListener);
        play.setFont(new Font("Serif", Font.PLAIN, 30));
        rules = new JButton("Rules");
        rules.addActionListener(actionListener);
        rules.setFont(new Font("Serif", Font.PLAIN, 30));
        quit = new JButton("Quit");
        quit.addActionListener(actionListener);
        quit.setFont(new Font("Serif", Font.PLAIN, 30));

        JPanel menuOptions = new JPanel();
        menuOptions.setBounds(250, 200, 600, 400);
        menuOptions.add(play);
        menuOptions.add(rules);
        menuOptions.add(quit);
        menuOptions.setLayout(new BoxLayout(menuOptions, BoxLayout.PAGE_AXIS));

        content.add(topLabel);
        content.add(menuOptions);
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } //mainMenu()

    //will set up game screen and enter game loop
    private void startGame() {
        //resetting the screen
        content.removeAll();
        content.repaint();

        //setting up the righthand panel to flip over and select cards from the deck
        JPanel deckCol = new JPanel();
        deckCol.setBounds(450, 0, 150, 600);
        deckCol.setBackground(Color.lightGray);


        content.add(deckCol);
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    } //startGame()

    //will display an explanatory page with rules and a back button
    private void rules() {

    } //rules()

    //exits the GUI completely
    private void quit() {
        frame.dispose();
    }

    /*
     * This function will take a deck of cards and "deal" them onto the board.
     * All of the R buttons will be mapped to a respective card from the deck in buttonMap.
     * Cards that are dealt will be removed from the deck. The function will return a deck of cards
     * consisting of the left over cards in the deck.
     */
    private ArrayList<Card> dealCards(ArrayList<Card> deck) {
        JButton[] pyramidCards = new JButton[]{R1, R21, R22, R31, R32, R33, R41, R42, R43, R44, R51, R52, R53, R54,
                                                R55, R61, R62, R63, R64, R65, R66, R71, R72, R73, R74, R75, R76, R77};
        for (int i = 0; i < NUM_CARDS_IN_PYRAMID; i++) {
            //Using i for pyramidCards index and 0 for deck index since .remove() shifts everything left and we want
            //card that is "next"
            buttonMap.put(pyramidCards[i], deck.get(0));
            deck.remove(0);
        }
        return deck;
    } //dealCards()

}
