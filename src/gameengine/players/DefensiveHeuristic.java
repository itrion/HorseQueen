package gameengine.players;

import core.ai.Heuristic;
import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.model.Queen;

public class DefensiveHeuristic implements Heuristic<Board> {

    @Override
    public double evaluate(Board board) {
        int turnIndicator = toggelTurn(board.getTurnIndicator());
        if (isMyQueenDead(board, turnIndicator)) return -Double.MAX_VALUE;
        if (canMyQueenDie(board, turnIndicator)) return -Double.MAX_VALUE;
        if (isOtherQueenDead(board, turnIndicator)) return Double.MAX_VALUE;
        if (myQueenhasLessThanFourSons(board, turnIndicator)) return -Double.MAX_VALUE;
        return chipDiference(board, turnIndicator);
    }

    private int toggelTurn(int turnIndicator) {
        return (turnIndicator + 1) % 2;
    }

    private boolean isMyQueenDead(Board board, int turnIndicator) {
        Chip chip = board.getChips().get(turnIndicator);
        return (!isQueen(chip) || !isMine(chip, turnIndicator));
    }

    private boolean isOtherQueenDead(Board board, int turnIndicator) {
        Chip chip = board.getChips().get(toggelTurn(turnIndicator));
        if (!isQueen(chip) || isMine(chip, turnIndicator))
            return true;
        else return false;
    }

    private boolean canMyQueenDie(Board board, int turnIndicator) {
        Queen myQueen = getMyQueen(board, turnIndicator);
        for (Chip chip : board.getChips())
            if (!isMine(chip, turnIndicator))
                if (canKillMyChip(myQueen, chip, board)) return true;
        return false;
    }

    private boolean myQueenhasLessThanFourSons(Board board, int turnIndicator) {
        Queen myQueen = (Queen) board.getChips().get(turnIndicator);
        return (myQueen.getSons() <= 3);
    }

    private Queen getMyQueen(Board board, int turnIndicator) {
        return (Queen) board.getChips().get(turnIndicator);
    }

    private boolean canKillMyChip(Chip myChip, Chip enemyChip, Board board) {
        int colDiference = Math.abs(board.getCol(enemyChip) - board.getCol(myChip));
        int rowDiference = Math.abs(board.getRow(enemyChip) - board.getRow(myChip));
        if (colDiference == 2 && rowDiference == 1) return true;
        if (colDiference == 1 && rowDiference == 2) return true;
        return false;
    }

    private int chipDiference(Board board, int turnIndicator) {
        int myChipsCounter = 0;
        int enemyChipsCounter = 0;
        for (Chip chip : board.getChips())
            if (isMine(chip, turnIndicator))
                myChipsCounter++;
            else
                enemyChipsCounter++;
        return myChipsCounter-enemyChipsCounter;
    }

    private boolean isQueen(Chip chip) {
        return (chip instanceof Queen);
    }

    private boolean isMine(Chip chip, int turnIndicator) {
        return (chip.getOwner().getTurnIndicator() == turnIndicator);
    }
}
