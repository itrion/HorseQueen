package horsequeen;

public class Queen extends Chip {
    private int sons;

    public Queen(Player owner, int position) {
        super(owner, position);
        this.sons = 10;
    }

    public void decraseSons() {
        sons--;
    }
}
