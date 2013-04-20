package horsequeen.core;

public abstract class Chip {

    private Player owner;

    protected Chip(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
