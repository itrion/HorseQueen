package horsequeen.core;

public class Queen extends Chip {

    private static final int AMOUNT_OF_BABIES = 5;
    private int remainingBabies;

    public Queen(HorseQueenPlayer owner) {
        super(owner);
        this.remainingBabies = AMOUNT_OF_BABIES;
    }

    public int getRemainingBabies() {
        return remainingBabies;
    }

    public void decreaseBabies() {
        this.remainingBabies--;
    }
}
