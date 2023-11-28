public class Robit {

    private int cash;
    private int hand;
    private boolean hitOrStand;
    private String previousCard;

    public Robit(){

        hand = 0;
        hitOrStand = false;
        previousCard = "";
    }

    public boolean hitOrStand(){
        int random = (int )(Math.random() * 1) + 1;
        if(random == 1){
            hitOrStand = true;//stand
        }
        return hitOrStand; //hit
    }

}