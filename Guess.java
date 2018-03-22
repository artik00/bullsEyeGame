public class Guess {
    private int guess ;
    private int hits;
    private int bullseye;

    public Guess(int guess) {
        this.guess = guess;
    }

    public Guess(int guess, int hits, int bullseye) {
        this.guess = guess;
        this.hits = hits;
        this.bullseye = bullseye;
    }

    public int getGuess() {
        return guess;
    }

    public void setGuess(int guess) {
        this.guess = guess;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getBullseye() {
        return bullseye;
    }

    public void setBullseye(int bullseye) {
        this.bullseye = bullseye;
    }

    @Override
    public String toString() {
        return "Guess : " + guess + " hits : " + hits + " bullseye : " + bullseye + "\n";
    }
}
