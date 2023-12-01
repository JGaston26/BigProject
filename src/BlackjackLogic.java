public class BlackjackLogic {
    private Blackjack game;
    private Robit player2;

    public BlackjackLogic(Blackjack aa, Robit aa2) {
        game = aa;
        player2 = aa2;
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
