package horsequeen.core;

public abstract class Chip {

    private HorseQueenPlayer owner;

    protected Chip(HorseQueenPlayer owner) {
        this.owner = owner;
    }

    public HorseQueenPlayer getOwner() {
        return owner;
    }
}
