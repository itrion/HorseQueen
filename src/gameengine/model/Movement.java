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
    protected Board board;

    protected Movement(Chip chip) {
        this.chip = chip;
    }

    @Override
    public boolean isApplicable(Board board) {
        this.board = board;
        final int newPosition = getNewPosition();
        if (!isValidPosition()) return false;
        return (rulesAreMet(chip, newPosition, board));
    }

    public boolean isValidPosition() {
        Chip clonedChip = chip.clone();
        clonedChip.setPosition(getNewPosition());
        if (Math.abs(board.getCol(chip) - board.getCol(clonedChip)) > 2) return false;
        if (Math.abs(board.getRow(chip) - board.getRow(clonedChip)) > 2) return false;
        return (getNewPosition() >= 0 && getNewPosition() <= 64);
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
            bornNewMonkey(board, queen);
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

    private void bornNewMonkey(Board board, Queen queen) {
        board.addChip(new Monkey(queen.getOwner(), queen.getPosition()));
        queen.decraseSons();
    }
}
