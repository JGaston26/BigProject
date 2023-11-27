import java.util.Scanner;


public class Blackjack {
    private int hand;
    private String previousCard;
    private int cash;
    private int bet;

    public Blackjack() {
        hand = 0;
        previousCard = "";
        cash = 1000;
        bet = 0;
    }

    public void start() {
        Robit player2 = new Robit();
        System.out.println("Welcome to Blackjack.");

    }

}
