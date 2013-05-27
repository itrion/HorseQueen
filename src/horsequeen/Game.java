package horsequeen;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.PlayersEnviroment;
import core.ai.State;
import horsequeen.actions.MoveDownLeft;
import horsequeen.actions.MoveDownRight;
import horsequeen.actions.MoveLeftDown;
import horsequeen.actions.MoveLeftUp;
import horsequeen.actions.MoveRightDown;
import horsequeen.actions.MoveRightUp;
import horsequeen.actions.MoveUpLeft;
import horsequeen.actions.MoveUpRight;
import java.util.ArrayList;
import java.util.List;

public class Game implements PlayersEnviroment {

    private Player[] players;
    private int turnIndicator;
    private Board board;

    public Game(Player playerOne, Player playerTwo) {
        this.players = new Player[2];
        this.players[0] = playerOne;
        this.players[0] = playerTwo;
        this.board = createInitialBoard();
    }

    private Board createInitialBoard() {
        Board initialBoard = new Board();
        initialBoard.addChip(new Queen(players[0], 3));
        initialBoard.addChip(new Queen(players[1], 60));
        return initialBoard;
    }

    public void start() {
        turnIndicator = 0;
        while (true) {
            board = playNextTurn(board);
            if (GameOverChecker.check(board)) break;
            toggleTurn();
            board = playNextTurn(board);
            if (GameOverChecker.check(board)) break;
            toggleTurn();
        }
    }

    private Board playNextTurn(Board currentState) {
        return players[turnIndicator].play(currentState, this);
    }

    private void toggleTurn() {
        turnIndicator = turnIndicator + 1 % 2;
    }

    @Override
    public boolean isFinalState(State state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isTurnOf(State state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List getApplicableActions(State state) {
        List<Action> applicableActions = new ArrayList<>();
        for (Chip chipOnBoard : board.getChips())
            if (chipOnBoard.getOwner() == players[turnIndicator])
                applicableActions.addAll(getActionsFor(chipOnBoard));
        return applicableActions;
    }

    private List<Action> getActionsFor(Chip chipOnBoard) {
        List<Action> actionsForChip = new ArrayList<>();
        for (Action action : getActionList(chipOnBoard))
            if (action.isApplicable(board)) actionsForChip.add(action);
        return actionsForChip;

    }

    @Override
    public State getFinalState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public State getInitialState() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ActionList getActionList() {
        return null;
    }

    private List<Action> getActionList(Chip chipOnBoard) {
        List<Action> actions = new ArrayList<>();
        actions.add(new MoveUpLeft(chipOnBoard));
        actions.add(new MoveUpRight(chipOnBoard));
        actions.add(new MoveDownLeft(chipOnBoard));
        actions.add(new MoveDownRight(chipOnBoard));
        actions.add(new MoveLeftUp(chipOnBoard));
        actions.add(new MoveLeftDown(chipOnBoard));
        actions.add(new MoveRightUp(chipOnBoard));
        actions.add(new MoveRightDown(chipOnBoard));
        return actions;
    }
}