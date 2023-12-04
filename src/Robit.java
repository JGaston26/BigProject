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
    private void setPreviousMove(String s){
        previousMove = s;
    }
    public String getPreviousMove(){
        return previousMove;
    }

    private void hitOrStand(){
        int random = (int )(Math.random() * 1) + 1;
        if (hand >= 17) {
            setPreviousMove("S");
            hitOrStand = false;
        } else if(random == 1){
            hitOrStand = true;//stand
            setPreviousMove("H");
        }
    }

    public void turn2() {
        System.out.println("Dealer's current hand is: " + hand);
        if (hitOrStand) {
            previousCard = (int) (Math.random() * 14) + 1;
            System.out.println("Dealer hits and draws a " + previousCard);
            hand += previousCard;
            System.out.println("Dealer's hand is now: " + hand);
        } else {
            hand += 0;
        }
    }

}