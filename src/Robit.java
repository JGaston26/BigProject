public class Robit {

    private int cash;
    private int hand;
    private boolean hitOrStand;
    private int previousCard;

    public Robit(){

        hand = (int) (Math.random() * 21) + 1;
        hitOrStand = false;
        previousCard = 0;
    }

    public int getHand() {
        return hand;
    }
    public boolean hitOrStand(){
        int random = (int )(Math.random() * 1) + 1;
        if (hand >= 17) {
            return hitOrStand;
        } else if(random == 1){
            hitOrStand = true;//stand
        }
        return hitOrStand; //hit
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