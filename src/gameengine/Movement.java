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

    @Override
    public Board execute(Board state) {
        Board board = new Board(toggleTurn(state.getTurnIndicator()), state.getChips());
        boolean isEmptyNewPosition = board.isEmpty(getNewPosition());
        if (!isEmptyNewPosition)
            cleanPosition(state, getNewPosition());
        if (chip instanceof Queen)
            moveQueen(board, isEmptyNewPosition);
        else
            moveMonkey(board);
        return board;
    }

    private void moveQueen(Board board, boolean isEmptyNewPosition) {
        Queen queen = (Queen) board.getChip(this.chip.getPosition());
        if (isEmptyNewPosition)
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

    private int toggleTurn(int turnIndicator) {
        return (turnIndicator + 1) % 2;
    }

    private void cleanPosition(Board state, int newPosition) {
        state.remove(newPosition);
    }
}
