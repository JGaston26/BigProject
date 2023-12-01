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
    private Scanner scan;
    private String choice;
    private BlackjackLogic logic;

    /**
     * Instantiates a Blackjack object
     * <p>
     * No parameter but will set default values
     */

    public Blackjack() {
        hand = (int) (Math.random() * 21) + 1;
        previousCard = 0;
        cash = 1000;
        bet = 0;
        scan = new Scanner(System.in);
        choice = "";
        logic = new BlackjackLogic(this, player2);
    }

    public int getHand() {
        return hand;
    }
    /**
     * Starts the game and welcomes the user.
     *
     * @param name The name of the user
     */
    public void start(String name) {
        Robit player2 = new Robit();
        System.out.println("Welcome to Blackjack " + name + "!");
        System.out.println();
        System.out.println("  BLACKJACK RULES: ");
        System.out.println("	-Each player is dealt 2 cards. The dealer is dealt 2 cards with one face-up and one face-down.");
        System.out.println("	-Cards are equal to their value with face cards being 10 and an Ace being 1 or 11.");
        System.out.println("	-The players cards are added up for their total.");
        System.out.println("	-Players “Hit” to gain another card from the deck. Players “Stand” to keep their current card total.");
        System.out.println("	-Dealer “Hits” until they equal or exceed 17.");
        System.out.println("	-The goal is to have a higher card total than the dealer without going over 21.");
        System.out.println("	-If the player total equals the dealer total, it is a “Push” and the hand ends.");
        System.out.println();

        while (logic.gameRunning()) {
            turn();
            player2.turn2();
        }
    }

    /**
     * Draws a card at random and adds it to the value of hand
     */
    public void drawCard() {
        previousCard = (int) (Math.random() * 14) + 1;
        hand += previousCard;
    }

    public void turn() {
        System.out.println("Your current hand is: " + hand);
        System.out.println("Would you like to hit or stand? (H/S): ");
        choice = scan.nextLine();
        if (choice.equals("H")) {
            drawCard();
        } else if (choice.equals("S")) {
            hand += 0;
        } else {
            System.out.println("That is not a choice try again!");
            System.out.println("Would you like to hit or stand? (H/S): ");
            choice = scan.nextLine();
        }
    }

}
