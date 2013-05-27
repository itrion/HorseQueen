package horsequeen;

public abstract class Chip {

    private Player owner;
    private int position;

    public Chip(Player owner, int position) {
        this.owner = owner;
        this.position = position;
    }

    public Player getOwner() {
        return owner;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
