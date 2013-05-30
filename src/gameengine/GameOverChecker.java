package gameengine;

public class GameOverChecker {

    static boolean check(Board currentState) {
        // TODO 2. Deprive your opponent of legal moves by leaving him with
        // TODO a queen of height two, no babies, and nothing within line of
        // sight for said queen to kill. 
        if (wasQueenKilled(currentState)) return true;
        if (oponentHasNoMovements(currentState)) return true;
        if (queenOfHeightTwoHasNoBabiesAndCantKill()) return true;
        return false;
    }

    private static boolean wasQueenKilled(Board currentState) {
        Chip firsChip = currentState.getChip(0);
        Chip secondChip = currentState.getChip(1);
        return !areBothQueens(firsChip, secondChip);
    }

    private static boolean oponentHasNoMovements(Board currentState) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static boolean queenOfHeightTwoHasNoBabiesAndCantKill() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private static boolean areBothQueens(Chip firsChip, Chip secondChip) {
        return (firsChip instanceof Queen && secondChip instanceof Queen);
    }
}
