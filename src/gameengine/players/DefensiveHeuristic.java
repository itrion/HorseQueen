package gameengine.players;

import core.ai.Heuristic;
import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.model.Queen;
import java.util.ArrayList;
import java.util.List;

public class DefensiveHeuristic implements Heuristic<Board> {

    @Override
    public double evaluate(Board board) {
        int turnIndicator = toggelTurn(board.getTurnIndicator());
        if (isMyQueenDead(board, turnIndicator)) return Double.NEGATIVE_INFINITY;
        if (isOtherQueenDead(board, turnIndicator)) return Double.POSITIVE_INFINITY;
        if (canMyQueenDie(board, turnIndicator)) return Double.NEGATIVE_INFINITY;
        if (myQueenhasLessThanFourSons(board, turnIndicator)) return -1;
        //if (doIHaveMoreChips(board, turnIndicator)) return 1;
        return 0;
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
                if (canKillMyQueen(myQueen, chip, board)) return true;
        return false;
    }

    private boolean myQueenhasLessThanFourSons(Board board, int turnIndicator) {
        Queen myQueen = (Queen) board.getChips().get(turnIndicator);
        return (myQueen.getSons() < 3);
    }

    private Queen getMyQueen(Board board, int turnIndicator) {
        return (Queen) board.getChips().get(turnIndicator);
    }

    private boolean canKillMyQueen(Queen myQueen, Chip chip, Board board) {
        int colDiference = Math.abs(board.getCol(chip) - board.getCol(myQueen));
        int rowDiference = Math.abs(board.getRow(chip) - board.getRow(myQueen));
        if (colDiference == 2 && rowDiference == 1) return true;
        if (colDiference == 1 && rowDiference == 2) return true;
        return false;
    }

    private boolean doIHaveMoreChips(Board board, int turnIndicator) {
        List<Chip> myChips = new ArrayList<>();
        List<Chip> enemyChips = new ArrayList<>();
        for (Chip chip : board.getChips())
            if (isMine(chip, turnIndicator)) myChips.add(chip);
            else enemyChips.add(chip);
        return (myChips.size() > enemyChips.size());
    }

    private boolean isQueen(Chip chip) {
        return (chip instanceof Queen);
    }

    private boolean isMine(Chip chip, int turnIndicator) {
        return (chip.getOwner().getTurnIndicator() == turnIndicator);
    }
}
