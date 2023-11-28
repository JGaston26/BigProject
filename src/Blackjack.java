import java.util.Scanner;

/**
 * This class represents the user's object
 *
 * @author Tony Tran
 */
public class Blackjack {
    /** The total value of the user's hand */
    private int hand;
    /** The  value of the user's previous card */
    private int previousCard;
    /** The total value of money the user has */
    private int cash;
    /** The value the user will bet */
    private int bet;

    /**
     * Instantiates a Blackjack object
     * <p>
     * No parameter but will set default values
     */

    public Blackjack() {
        hand = 0;
        previousCard = 0;
        cash = 1000;
        bet = 0;
    }

    /**
     * Starts the game and welcomes the user.
     *
     * @param name The name of the user
     */
    public void start(String name) {
        Robit player2 = new Robit();
        System.out.println("Welcome to Blackjack " + name + ".");

    }

    /**
     * Draws a card at random and adds it to the value of hand
     *
     * @return The value of the previous card
     */
    public int drawCard() {
        previousCard = (int) (Math.random() * 14) + 1;
        hand += previousCard;
        return previousCard;
    }

}
