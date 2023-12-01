import java.util.Scanner;
public class BlackjackRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Blackjack game = new Blackjack();
        System.out.print("Enter your name: ");
        System.out.println(game);
        String name = scan.nextLine();
        game.start(name);
    }
}
