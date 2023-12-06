import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
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
    private  Robit player2 = new Robit();
    private String askContinue;

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
        askContinue = "";
    }

    public Blackjack(int cash) {
        hand = (int) (Math.random() * 21) + 1;
        previousCard = 0;
        this.cash = cash;
        bet = 0;
        scan = new Scanner(System.in);
        choice = "";
        logic = new BlackjackLogic(this, player2);
        askContinue = "";
    }

    public int getHand() {
        return hand;
    }
    public int getCash(){
        return cash;
    }
    public int getBet(){
        return bet;
    }
    public void addCash(int val){
        cash += val;
    }
    public void subtractCash(int val){
        cash -= val;
    }
    public void setHand(int i){
        hand = i;
    }
    public void setAskContinue(String str){
        askContinue = str;
    }
    public String printHand(){
        return  "Your current hand is: " + getHand();
    }

    public String printDealerHand(){
        return "Dealers current hand is: " + player2.getHand();
    }

    public void setBet(int betVal){
        bet = betVal;
    }

    public void doBet(int betVal) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        if(logic.checkWin()){
            addCash(betVal);
            System.out.print("You won $" + betVal + " ");
            printHand();
        }else{
            subtractCash(betVal);
            System.out.print("You lost $" + betVal + " ");
            printHand();
        }
    }

    public void drawCard() {
        previousCard = (int) (Math.random() * 11) + 1;
        if (previousCard == 11 && hand + previousCard > 21) {
            hand += 1;
        } else {
            hand += previousCard;
        }
    }

    /**
     * Starts the game and welcomes the user.
     */
    public void start() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Robit player2 = new Robit();
        System.out.print("Enter your name: ");
        String name = scan.nextLine();
        printName(name);
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

        while(!askContinue.equals("End")) {
            File file = new File("King Of Swing.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            clip.loop(Clip.LOOP_CONTINUOUSLY);
            System.out.println("You have $" + cash);
            System.out.print("How much would you like to bet: ");
            turn();
        }
    }

    /**
     * Draws a card at random and adds it to the value of hand
     */


    public void turn() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        setBet(scan.nextInt());
        scan.nextLine();
        // Assuming logic is an instance of your game logic class
        while (logic.gameRunning()) {
            System.out.println(printHand());
            System.out.println(printDealerHand());
            System.out.print("Would you like to hit or stand? (H/S): ");
            choice = scan.nextLine();
            if (choice.equals("H")) {
                System.out.println(" ");
                drawCard();
                System.out.println("You have $" + getCash());
                if (getHand() > 21) {
                    doBet(getBet());
                    logic.continuePlaying();
                }else if(player2.getHand() > 21){
                    doBet(getBet());
                    logic.continuePlaying();
                }
            } else if (choice.equals("S")) {
                player2.turn2();
                doBet(getBet());
                logic.continuePlaying();

            } else {
                System.out.println("That is not a choice. Try again!");
            }

        }
    }

    private static void printName(String name) {
        System.out.println("Welcome to Blackjack " + name + "!");
    }
}
