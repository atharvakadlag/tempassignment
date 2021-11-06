import java.util.Random;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // create rock paper scissors game
        Random rand = new Random();
        RPS rps = new RPS(rand, 2, 2);
        Scanner scanner = new Scanner(System.in);
        rps.play(scanner);
    }
}
