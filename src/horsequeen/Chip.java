package horsequeen;

public abstract class Chip {

    private Player owner;

    public Chip(Player owner) {
        this.owner = owner;
    }

    public Player getOwner() {
        return owner;
    }
}
