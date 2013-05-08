package horsequeen.core;

public class Queen extends Chip {

    private int remainingBabies;

    public Queen(HorseQueenPlayer owner, int remainingBabies) {
        super(owner);
        this.remainingBabies = remainingBabies;
    }

    public int getRemainingBabies() {
        return remainingBabies;
    }

    public void decreaseBabies() {
        this.remainingBabies--;
    }
}
