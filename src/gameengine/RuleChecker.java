package gameengine;

public class RuleChecker {

    public static BoardIndexTranslator boardIndexTranslator;

    public static boolean chechRules(Chip chip, int newPosition, Board board) {
        final boolean capturingMovement = isCapturingMovement(chip, newPosition, board);
        if (chip instanceof Queen) {
            Queen queen = (Queen) chip;
            return !queenOfHeightEqualLessThanTwoMovesWithoutCapture(queen, capturingMovement);
        }
        if (chip instanceof Monkey)
            return !monkeyDontCapturesAndDontGoesTowardEnemyQueen(capturingMovement, chip, newPosition, board);
        return true;
    }

    private static boolean isCapturingMovement(Chip chip, int newPosition, Board board) {
        Chip chipOnBoard = board.getChip(newPosition);
        if (chipOnBoard == null) return false;
        return (chipOnBoard.getOwner() != chip.getOwner());
    }

    private static boolean moveTowardEnemyQueen(Chip chip, int newPosition, Board board) {
        Chip clone = chip.clone();
        clone.setPosition(newPosition);
        double olderEuclideanPosition = boardIndexTranslator.getEuclideanDistance(chip, board.getEnemyQueen(chip));
        double newEuclideanPosition = boardIndexTranslator.getEuclideanDistance(clone, board.getEnemyQueen(chip));
        return (newEuclideanPosition <= olderEuclideanPosition);
    }

    private static boolean queenOfHeightEqualLessThanTwoMovesWithoutCapture(Queen queen, final boolean capturingMovement) {
        return queen.getSons() <= 2 && !capturingMovement;
    }

    private static boolean monkeyDontCapturesAndDontGoesTowardEnemyQueen(final boolean capturingMovement, Chip chip, int newPosition, Board board) {
        return !capturingMovement && !moveTowardEnemyQueen(chip, newPosition, board);
    }
}
