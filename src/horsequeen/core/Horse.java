package horsequeen.core;

public class Horse extends Chip {

    private Queen mother;

    public Horse(Queen mother) {
        super(mother.getOwner());
        this.mother = mother;
    }

    public Queen getMother() {
        return mother;
    }
}
