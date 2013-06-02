package gameengine;

import core.ai.PlayersEnviroment;
import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.model.Queen;
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
        //if (queenOfCurrentPlayerDieInNextTurn(currentState)) return true;
        return false;
    }

    private boolean wasQueenKilled(Board currentState) {
        List<Chip> chips = currentState.getChips();
        Chip firsChip = chips.get(0);
        Chip secondChip = chips.get(1);
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

    private boolean queenOfCurrentPlayerDieInNextTurn(Board board) {
        int turnIndicator = toggelTurn(board.getTurnIndicator());
        Queen currentPlayerQueen = getCurrentPlayerQueen(board, turnIndicator);
        for (Chip chip : board.getChips())
            if (!isCurrentPlayerChip(chip, turnIndicator))
                if (canDieCurrentPlayerQueen(currentPlayerQueen, chip, board)) return true;
        return false;
    }

    private Queen getCurrentPlayerQueen(Board board, int turnIndicator) {
        return (Queen) board.getChips().get(turnIndicator);
    }

    private int toggelTurn(int turnIndicator) {
        return (turnIndicator + 1) % 2;
    }

    private boolean isCurrentPlayerChip(Chip chip, int turnIndicator) {
        return (chip.getOwner().getTurnIndicator() == turnIndicator);
    }

    private boolean canDieCurrentPlayerQueen(Queen myQueen, Chip chip, Board board) {
        int colDiference = Math.abs(board.getCol(chip) - board.getCol(myQueen));
        int rowDiference = Math.abs(board.getRow(chip) - board.getRow(myQueen));
        if (colDiference == 2 && rowDiference == 1) return true;
        if (colDiference == 1 && rowDiference == 2) return true;
        return false;
    }
}
