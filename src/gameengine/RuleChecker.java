package gameengine;

import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.model.Queen;

public class RuleChecker {

    public static boolean chechRules(Chip chip, int newPosition, Board board) {
        if (newPositionHasChipOfMine(chip, newPosition, board)) return false;
        boolean capturingMovement = isCapturingMovement(chip, newPosition, board);
        if (chip instanceof Queen) return checkQueenRules(chip, capturingMovement);
        else return checkMonekeyRules(capturingMovement, chip, newPosition, board);
    }

    private static boolean newPositionHasChipOfMine(Chip chip, int newPosition, Board board) {
        if (board.isEmpty(newPosition)) return false;
        return board.getChip(newPosition).getOwner() == chip.getOwner();
    }

    private static boolean isCapturingMovement(Chip chip, int newPosition, Board board) {
        if (board.isEmpty(newPosition)) return false;
        return (board.getChip(newPosition).getOwner() != chip.getOwner());
    }

    private static boolean checkQueenRules(Chip chip, boolean capturingMovement) {
        Queen queen = (Queen) chip;
        return !queenOfHeightEqualLessThanTwoMovesWithoutCapture(queen, capturingMovement);
    }

    private static boolean checkMonekeyRules(boolean capturingMovement, Chip chip, int newPosition, Board board) {
        return !monkeyDontCapturesAndDontGoesTowardEnemyQueen(capturingMovement, chip, newPosition, board);
    }

    private static boolean queenOfHeightEqualLessThanTwoMovesWithoutCapture(Queen queen, final boolean capturingMovement) {
        return queen.getSons() <= 2 && !capturingMovement;
    }

    private static boolean monkeyDontCapturesAndDontGoesTowardEnemyQueen(final boolean capturingMovement, Chip chip, int newPosition, Board board) {
        return !capturingMovement && !moveTowardEnemyQueen(chip, newPosition, board);
    }

    private static boolean moveTowardEnemyQueen(Chip chip, int newPosition, Board board) {
        Chip clonedChip = chip.clone();
        clonedChip.setPosition(newPosition);
        return (board.getEuclideanDistance(clonedChip, board.getEnemyQueen(chip)) <= board.getEuclideanDistance(chip, board.getEnemyQueen(chip)));
    }
}
