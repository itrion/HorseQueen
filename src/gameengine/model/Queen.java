package gameengine.model;

public class Queen extends Chip {

    private static final int MAX_SONS = 10;
    private int sons;

    public Queen(Player owner, int position) {
        this(owner, position, MAX_SONS);
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

    public int getSons() {
        return sons;
    }

    public void setSons(int sons) {
        this.sons = sons;
    }
}
