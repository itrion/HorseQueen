package gameengine;

public class Queen extends Chip {

    private int sons;

    public Queen(Player owner, int position) {
        this(owner, position, 10);
    }

    public void decraseSons() {
        sons--;
    }

    @Override
    public Queen clone() {
        return new Queen(getOwner(), getPosition(), getSons());
    }

    private Queen(Player owner, int position, int sons) {
        super(owner, position);
        this.sons = sons;
    }

    private int getSons() {
        return sons;
    }
}
