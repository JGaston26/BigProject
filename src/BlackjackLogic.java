public class BlackjackLogic {
    private Blackjack game;
    private Robit player2;

    public BlackjackLogic(Blackjack aa, Robit aa2) {
        game = aa;
        player2 = aa2;
    }

    public void compare(){
        int playerHand = game.getHand();
        int dealerHand = player2.getHand();
        if(playerHand == dealerHand){
            System.out.println("It's a tie");
        }
        else if (playerHand > 21 && dealerHand > 21){
            if (playerHand > dealerHand){
                System.out.println("Dealer wins!");
            }else{
                System.out.println("Player wins!");
            }
        }
        if(playerHand == 21){
            System.out.println("Blackjack!");
        }
        if(dealerHand == 21){
            System.out.println("Dealer Blackjack!");
        }
        if(21 - playerHand < 21 - dealerHand){
            System.out.println("PLayer Wins!");
        }else{
            System.out.println("Dealer Wins");
        }
    }

    public boolean gameRunning() {
        if (game.getHand() >= 21) {
            return false;
        } else if (player2.getHand() >= 21) {
            return false;
        } else {
            return true;
        }
    }
}
