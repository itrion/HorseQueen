package horsequeen.actions;

import core.ai.Action;
import horsequeen.Board;
import horsequeen.Chip;
import horsequeen.Monkey;
import horsequeen.Queen;

public abstract class Movement implements Action<Board> {

    public static final int ONE_ROW_UP = -8;
    public static final int ONE_ROW_DOWN = 8;
    public static final int TWO_ROWS_UP = -16;
    public static final int TWO_ROWS_DOWN = 16;
    public static final int ONE_COLUMN_LEFT = -1;
    public static final int ONE_COLUMN_RIGHT = 1;
    public static final int TWO_COLUMNS_LEFT = -2;
    public static final int TWO_COLUMNS_RIGHT = 2;
    protected Chip chip;

    public Movement(Chip chip) {
        this.chip = chip;
    }

    public boolean isValidPosition(int position) {
        return (position >= 0 && position <= 64);
    }

    public boolean rulesAreMet(Chip chip, int newPositions, Board state) {
        //TODO fix when the rules are met
        return true;
    }

    @Override
    public Board execute(Board state) {
        Board board = new Board(state.getChips());
        if (chip instanceof Queen) moveQueen(board);
        else moveMonkey();
        return board;
    }

    @Override
    public boolean isApplicable(Board state) {
        final int newPosition = getNewPosition();
        if (!isValidPosition(newPosition)) return false;
        return (rulesAreMet(chip, newPosition, state));
    }

    private void moveQueen(Board board) {
        Queen queen = (Queen) chip;
        board.addChip(new Monkey(queen.getOwner(), queen.getPosition()));
        queen.decraseSons();
        queen.setPosition(getNewPosition());
    }

    private void moveMonkey() {
        Monkey monkey = (Monkey) chip;
        monkey.setPosition(getNewPosition());
    }

    protected abstract int getNewPosition();
}
