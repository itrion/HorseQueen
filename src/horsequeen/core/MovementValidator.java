package horsequeen.core;

public class MovementValidator {

    private Board board;
    private Tile origin;
    private Tile target;
    private Player currentTurnPlayer;
    private final int originRow;
    private final int originColumn;
    private final int targetRow;
    private final int targetColumn;

    public MovementValidator(Board board, Tile origin, Tile target) {
        this.board = board;
        this.origin = origin;
        this.target = target;
        this.currentTurnPlayer = origin.getOccupant().getOwner();
        this.originRow = board.getRow(origin);
        this.originColumn = board.getColumn(origin);
        this.targetRow = board.getRow(target);
        this.targetColumn = board.getColumn(target);
    }

    public boolean validate() {
        if (!allowedMovement()) return false;
        if (origin.getOccupant() instanceof Queen)
            return checkQueenRules();
        else
            return checkHorseRules();
    }

    private boolean checkQueenRules() {
        Queen queen = (Queen) origin.getOccupant();
        if (!target.isEmpty())
            if(queen.getRemainingBabies() == 2) return false; 
        return false;
    }

    private boolean checkHorseRules() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private boolean allowedMovement() {
        if (isHorizontalMovement())return true;
        if (isVerticalMovement()) return true;
        return false;
    }

    private boolean isHorizontalMovement() {
        return (Math.abs(originRow - targetRow) == 1 && Math.abs(originColumn - targetColumn) == 2);
    }
    
    private boolean isVerticalMovement() {
        return (Math.abs(originRow - targetRow) == 2 && Math.abs(originColumn - targetColumn) == 1);
    }
}
