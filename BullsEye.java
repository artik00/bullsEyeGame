import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BullsEye {

    private Integer number;
    private List<Guess> guessList = new ArrayList<>();

    public BullsEye() {
        generateNewNumber();
    }

    private static boolean areAllDigitsDistinct(int number) {
        int a = number % 10;
        int b = number / 10 % 10;
        int c = number / 100 % 10;
        int d = number / 1000 % 10;
        return a != b && a != c && a != d && b != c && b != d && c != d ;
    }

    public boolean checkGuess(String numberToCheck) {
        if (!isValidInput(numberToCheck)){
            return false;
        }
        Integer numberGuessed = Integer.valueOf(numberToCheck);
        if (number.equals(numberGuessed)) {
            JOptionPane.showMessageDialog(null, "You Guessed the right number", "Success", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }
        Guess currentGuess = calculateHitsAndBullsEyes(numberGuessed);
        JOptionPane.showMessageDialog(null, "Number of hits is : " + currentGuess.getHits() + " Number of bullseyes : " + currentGuess.getBullseye(), "Result", JOptionPane.INFORMATION_MESSAGE);
        guessList.add(currentGuess);
        return false;
    }

    private Guess calculateHitsAndBullsEyes(Integer numberGuessed) {
        int tempGuessedNumber = numberGuessed;
        int tempActualNumber = number;
        Guess guess = new Guess(numberGuessed);
        while (tempGuessedNumber > 0) {
            int guessedDigit = tempGuessedNumber % 10;
            int actualDigit = tempActualNumber % 10;
            if (guessedDigit == actualDigit) {
                guess.setBullseye(guess.getBullseye() + 1);
            } else if (isDigitInNumber(guessedDigit)) {
                guess.setHits(guess.getHits() + 1);
            }
            tempGuessedNumber = tempGuessedNumber / 10;
            tempActualNumber = tempActualNumber / 10;
        }
        return guess;
    }

    private boolean isValidInput(String stringToValidate) {
        if (!isNumeric(stringToValidate)) {
            JOptionPane.showMessageDialog(null, "Input must be numbers only", "Input Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (stringToValidate.length() != 4) {
            JOptionPane.showMessageDialog(null, "Input is not 4 numbers long", "Input Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (!areAllDigitsDistinct( Integer.valueOf(stringToValidate))) {
            JOptionPane.showMessageDialog(null, "Not all numbers are distinct", "Input Error" , JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    private boolean isNumeric(String str)
    {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private boolean isDigitInNumber(int digit) {
        int tempNumber = number;
        while (tempNumber > 0) {
            int temp = tempNumber % 10;
            if (temp == digit) {
                return true;
            } else {
                tempNumber = tempNumber / 10;
            }
        }
        return false;
    }

    public void generateNewNumber() {
        Random random = new Random();
        boolean areAllNumbersDistinct = false;
        int tempNumber = 0;
        while (!areAllNumbersDistinct) {
            tempNumber = random.nextInt(8999) + 1000;
            areAllNumbersDistinct = areAllDigitsDistinct(tempNumber);
        }
        this.number = tempNumber;
        guessList.clear();
    }

    public String getPreviousGuesses() {
        if (!guessList.isEmpty()) {
            StringBuffer stringBuffer = new StringBuffer();
            for (Guess guess : guessList) {
                stringBuffer.append(guess);
            }
            return stringBuffer.toString();
        }
        return null;
    }
}
