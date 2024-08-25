import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Program for displaying the GUI
 *
 */

public class GUI extends JComponent implements Runnable {

    String welcome = "Welcome to Pyramid!";
    JFrame frame = new JFrame("Pyramid");
    JButton next;
    JButton play;
    JButton rules;
    JButton quit;
    JButton flipAndReset;
    JButton returnToMenu;


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
    public void mainMenu() {
        content.removeAll();
        content.repaint();
        JLabel mainMenu = new JLabel("Main Menu");
        mainMenu.setFont(new Font("Serif", Font.PLAIN, 40));

        JPanel topLabel = new JPanel();
        topLabel.add(mainMenu);
        topLabel.setBounds(0, 100, 600, 100);


        //TODO: Add play, rules, and quit buttons top to bottom

        content.add(topLabel);
        frame.setLayout(null);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}
