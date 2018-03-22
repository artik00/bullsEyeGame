import javax.swing.*;

public class Wrapper {

    public Wrapper() {

    }

    public void startGame() {
        BullsEye game = new BullsEye();
        boolean anotherGame = true;
        while (anotherGame) {
            String newGuess = JOptionPane.showInputDialog(null, "Guess a number");
            while (!game.checkGuess(newGuess)) {
                if (game.getPreviousGuesses() != null) {
                    newGuess = JOptionPane.showInputDialog(null, game.getPreviousGuesses() + "\n " + "Guess a number");
                } else {
                    newGuess = JOptionPane.showInputDialog(null, "Guess a number");
                }
            }
            while (true) {
                String answer = JOptionPane.showInputDialog(null, "Do you want another game ? (y/n)");
                if (answer.equals("n")) {
                    return ;
                } else if (answer.equals("y")) {
                    game.generateNewNumber();
                    break;
                }
            }
        }
    }
}
