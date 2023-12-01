public class BlackjackLogic {
    private Blackjack game2;
    private Robit player2;

    public BlackjackLogic() {
        game2 = game;
    }

    public boolean gameRunning() {
        if (game2.getHand() >= 21) {
            return false;
        } else if (player2.getHand() >= 21) {
            return false;
        } else {
            return true;
        }
    }
}
