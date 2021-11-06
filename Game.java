import java.util.Scanner;

public abstract class Game {
    // protected methods
    // String prepToPlay() updates the state of the object to be the beginning of a new game.
    protected abstract String prepToPlay();

    // boolean isOver() checks if the current state of the game is done (win or lose)
    protected abstract boolean isOver();

    // boolean isValid(String move) checks if the given string represents a valid move
    protected abstract boolean isValid(String move);

    // String processMove(String move) This method takes a valid move and updates the gamestate based on the user’s move
    // The return value of this method is either a string (a message to show the user) or the special value null (to indicate “no message”)
    protected abstract String processMove(String move);

    // String finalMessage() this method should return a “final string” to the user at the end of the game.
    protected abstract String finalMessage();

    // public methods
    // String getName() returns the name of the game
    public abstract String getName();

    // void play(Scanner user) This function should implement the general game outline
    public void play(Scanner user) {
        // setup a new game
        // repeat the following until the game is done
        //     print " Enter Your Move or ’ quit ’ to quit >"
        //     repeat until a valid move ( or quit ) is entered
        //         allow the user to enter a one - word move
        //     process the chosen move
        //     if necessary , print an update to the game state
        // after the game , print a " final message "
        System.out.println(prepToPlay());
        while (!isOver()) {
            System.out.print("Enter your move or 'quit' to quit > ");
            String move = user.next();
            if (move.equals("quit")) {
                break;
            }
            if (!isValid(move)) {
                System.out.println("Invalid move. Try again.");
                continue;
            }
            String result = processMove(move);
            if (result != null) {
                System.out.println(result);
            }
        }
        System.out.println(finalMessage());
    }
}