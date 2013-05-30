package gameengine;

import core.ai.PlayersEnviroment;
import java.util.List;

public class GameOverChecker {

    private PlayersEnviroment enviroment;

    public GameOverChecker(PlayersEnviroment enviroment) {
        this.enviroment = enviroment;
    }

    public boolean check(Board currentState) {
        if (wasQueenKilled(currentState)) return true;
        if (oponentHasNoLegalMovements(currentState)) return true;
        if (queenOfHeightTwoHasNoBabiesAndCantKill()) return true;
        return false;
    }

    private boolean wasQueenKilled(Board currentState) {
        Chip firsChip = currentState.getChip(0);
        Chip secondChip = currentState.getChip(1);
        return !areBothQueens(firsChip, secondChip);
    }

    private boolean oponentHasNoLegalMovements(Board currentState) {
        return enviroment.getApplicableActions(currentState).isEmpty();
    }

    private boolean queenOfHeightTwoHasNoBabiesAndCantKill() {
        // TODO a queen of height two, no babies, and nothing within line of
        // sight for said queen to kill. 
        return false;
    }

    private boolean areBothQueens(Chip firsChip, Chip secondChip) {
        return (firsChip instanceof Queen && secondChip instanceof Queen);
    }
}
