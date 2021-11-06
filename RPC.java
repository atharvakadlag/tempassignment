import java.util.Random;

// rock paper scissors
public class RPC extends Game {
    // rng is a Random object
    private Random rng;
    // requiredWins is the number of wins required to win the game
    private int requiredWins;
    // maxLosses is the number of losses allowed before the game is over
    private int maxLosses;
    // numWins is the number of wins the player has
    private int numWins;
    // numLosses is the number of losses the player has
    private int numLosses;

    // constructor
    RPC (Random rng, int requiredWins, int maxLosses) {
        this.rng = rng;
        this.requiredWins = requiredWins;
        this.maxLosses = maxLosses;
    }

    // getWins
    public int getWins() {
        return numWins;
    }

    // getLosses
    public int getLosses() {
        return numLosses;
    }

    // get game
    public String getName () {
        return "Rock, Paper, Scissors";
    }

    // prepare for a new game
    public String prepToPlay () {
        return "Enter rock, paper, or scissors. Beat me " + requiredWins + " times before I win " + requiredWins + " times!";
    }

    // isOver
    public boolean isOver () {
        return (this.getWins() >= this.requiredWins) || (this.getLosses() >= this.maxLosses);
    }

    // finalMessage
    public String finalMessage () {
        if (this.getWins() >= this.requiredWins) {
            return "You win the set";
        } else {
            return "You lose the set";
        }
    }

    // isValid
    public boolean isValid (String input) {
        return (input.equals("rock") || input.equals("paper") || input.equals("scissors"));
    }

    // processMove
    public String processMove (String input) {
        String result = "";
        // choose a random string among rock, paper, and scissors
        int rngInt = rng.nextInt(3);
        String[] moves = {"rock", "paper", "scissors"};
        String aiMove = moves[rngInt];

        if (input.equals(aiMove)) {
            result = "we tie";
        } else if (input.equals("rock") && aiMove.equals("scissors")) {
            result = "rock vs. scissors you Win";
            numWins++;
        } else if (input.equals("paper") && aiMove.equals("rock")) {
            result = "paper vs. rock you Win";
            numWins++;
        } else if (input.equals("scissors") && aiMove.equals("paper")) {
            result = "scissors vs. paper you Win";
            numWins++;
        } else {
            result = input + " vs. " + aiMove + " you Lose";
            numLosses++;
        }
        return result;
    }

    // toString
    public String toString() {
        return rng + " " + requiredWins + " " + maxLosses;
    }
}