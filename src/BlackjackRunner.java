import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class BlackjackRunner {
    public static void main(String[] args) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        Blackjack game = new Blackjack();
        game.start();

    }
}
