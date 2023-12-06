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
        previousMove = "H";

    }

    public int getHand() {
        return hand;
    }

    public void resetHand(){
        hand = 0;
        hand += (int) (Math.random() * 11) + 1;
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

        while (hand < 17) { // Dealer hits until hand is 17 or higher
            previousCard = (int) (Math.random() * 11) + 1;
            if (previousCard == 11) {
                System.out.println("Dealer hits and draws an ace");
                System.out.println(" ");
            }
            if (previousCard == 11 && hand + previousCard > 21) {
                hand += 1;
                System.out.println("Dealer's hand is now: " + hand);
            } else {
                System.out.println("Dealer hits and draws a " + previousCard);
                System.out.println();
                hand += previousCard;
                System.out.println("Dealer's hand is now: " + hand);
            }

        }

        setPreviousMove("S"); // Dealer stands after hitting until 17 or higher
    }

    private void setPreviousMove(String s){
        previousMove = s;
    }

}