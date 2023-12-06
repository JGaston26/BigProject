import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;
public class BlackjackLogic {
    private Blackjack player1;
    private Robit player2;
    private Scanner scan;



    public BlackjackLogic(Blackjack aa, Robit aa2) {
        player1 = aa;
        player2 = aa2;
        scan = new Scanner(System.in);
    }

    public boolean gameRunning() {
        if(player1.getHand() > 21){
            return false;
        }else if (player2.getHand() > 21) {
            return false;
        } else {
            return true;
        }
    }

    public void continuePlaying() {
        if (player1.getCash() <= 0) {
            System.out.println("You have no money! Thanks for playing, now get out.");
            player1.setAskContinue("End");
            System.exit(0);
        } else {
            System.out.print("Do you want to continue (Y/N): ");
            String ask = scan.nextLine();

            if (ask.equals("Y")) {
                player1.setHand(0);
                player1.drawCard();
                player2.resetHand();
            } else if (ask.equals("N")) {
                System.out.println("Thanks for Playing!");
                player1.setAskContinue("End");
            } else {
                System.out.println("Thanks for Playing!");
                player1.setAskContinue("End");
            }
        }
    }

    public boolean checkWin() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        int playerHand = player1.getHand();
        int dealerHand = player2.getHand();

        // Check if player or dealer has busted
        if (playerHand > 21) {
            System.out.println("Player busts! Dealer wins.");
            return false;
        } else if (dealerHand > 21) {
            System.out.println("Dealer busts! Player wins.");
            return true;
        }

        // Compare hands if neither player nor dealer has busted
        if (playerHand == 21) {
            System.out.println("Player has a Blackjack! Player wins.");
            return true;
        } else if (dealerHand == 21) {
            System.out.println("Dealer has a Blackjack! Dealer wins.");
            return false;
        }

        // Compare hands if neither player nor dealer has a Blackjack
        else if (playerHand > dealerHand) {
            System.out.print("Player wins!\n");
            return true;
        } else if (playerHand < dealerHand) {
            System.out.println("Dealer wins!");
            return false;
        } else {
            System.out.println("It's a tie!");
            return true; // You can modify this based on your game rules for a tie.
        }

    }

}
