public class Robit {

    private int cash;
    private int hand;
    private boolean hitOrStand;
    private int previousCard;
    private String previousMove;
    public Robit(){

        hand = (int) (Math.random() * 21) + 1;
        hitOrStand = false;
        previousCard = 0;
        previousMove = "";

    }

    public int getHand() {
        return hand;
    }

    public void resetHand(){
        hand = 0;
    }

    public String getPreviousMove(){
        return previousMove;
    }


    private void hitOrStand() {
        int random = (int) (Math.random() * 2) + 1;

        if (hand >= 17) {
            hitOrStand = false; // stand
            setPreviousMove("S");
        } else if (random < 0.5) {
            hitOrStand = false; // stand
            setPreviousMove("S");
        } else {
            hitOrStand = true; // hit
            setPreviousMove("H");
        }
    }


    public void turn2() {
        System.out.println("Dealer's current hand is: " + hand);
        hitOrStand();
        if (hitOrStand) {
            previousCard = (int) (Math.random() * 14) + 1;
            System.out.println("Dealer hits and draws a " + previousCard);

            hand += previousCard;
            System.out.println("Dealer's hand is now: " + hand);
            this.setPreviousMove("H");

        } else {
            this.setPreviousMove("S");
        }
    }

    private void setPreviousMove(String s){
        previousMove = s;
    }

}