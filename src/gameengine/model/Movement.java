package gameengine.model;

import core.ai.Action;
import gameengine.RuleChecker;

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

    protected Movement(Chip chip) {
        this.chip = chip;
    }

    @Override
    public boolean isApplicable(Board state) {
        final int newPosition = getNewPosition();
        if (!isValidPosition(newPosition)) return false;
        return (rulesAreMet(chip, newPosition, state));
    }

    public boolean isValidPosition(int position) {
        return (position >= 0 && position <= 64);
    }

    public boolean rulesAreMet(Chip chip, int newPositions, Board state) {
        return RuleChecker.chechRules(chip, newPositions, state);
    }

    @Override
    public Board execute(Board currentBoard) {
        Board clonedBoard = new Board(toggleTurn(currentBoard.getTurnIndicator()), currentBoard.cloneChips());
        boolean isEmptyNewPosition = clonedBoard.isEmpty(getNewPosition());
        if (!isEmptyNewPosition)
            cleanPosition(clonedBoard, getNewPosition());
        if (chip instanceof Queen)
            moveQueen(clonedBoard, isEmptyNewPosition);
        else
            moveMonkey(clonedBoard);
        return clonedBoard;
    }

    private int toggleTurn(int turnIndicator) {
        return (turnIndicator + 1) % 2;
    }

    private void cleanPosition(Board board, int newPosition) {
        board.remove(newPosition);
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

    public abstract int getNewPosition();

    public Chip getChip() {
        return chip;
    }
}
