public class BlackjackLogic {
    private Blackjack game;
    private Robit player2;

    public BlackjackLogic(Blackjack aa, Robit aa2) {
        game = aa;
        player2 = aa2;
    }

    public boolean gameRunning() {
        if(game.getHand() > 21 /*player2.getPreviousMove().equals("S") */){
            return false;
        }else if(player2.getHand() > 21) {
            return false;
        } else {
            return true;
        }
    }
    public boolean checkWin() {
        int playerHand = game.getHand();
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
        if (playerHand > dealerHand) {
            System.out.println("Player wins!");
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
