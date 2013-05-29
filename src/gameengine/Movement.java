package gameengine;

import core.ai.Action;

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
    //TODO A queen may not give birth to its own baby and kill an enemy baby in the same move.
    @Override
    public Board execute(Board state) {
        Board board = new Board(state.getChips());
        if (chip instanceof Queen)
            moveQueen(board);
        else
            moveMonkey(board);
        return board;
    }

    private void moveQueen(Board board) {
        Queen queen = (Queen) board.getChip(this.chip.getPosition());
        board.addChip(new Monkey(queen.getOwner(), queen.getPosition()));
        queen.decraseSons();
        queen.setPosition(getNewPosition());
    }

    private void moveMonkey(Board board) {
        Monkey monkey = (Monkey) board.getChip(this.chip.getPosition());
        monkey.setPosition(getNewPosition());
    }

    @Override
    public boolean isApplicable(Board state) {
        final int newPosition = getNewPosition();
        if (!isValidPosition(newPosition))
            return false;
        return (rulesAreMet(chip, newPosition, state));
    }

    protected abstract int getNewPosition();

    public boolean isValidPosition(int position) {
        return (position >= 0 && position <= 64);
    }

    public boolean rulesAreMet(Chip chip, int newPositions, Board state) {
        return RuleChecker.chechRules(chip, newPositions, state);
    }
}
