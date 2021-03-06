package gameengine;

import core.ai.Action;
import core.ai.ActionList;
import core.ai.PlayersEnviroment;
import core.ai.State;
import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.model.Player;
import gameengine.movements.MoveDownLeft;
import gameengine.movements.MoveDownRight;
import gameengine.movements.MoveLeftDown;
import gameengine.movements.MoveLeftUp;
import gameengine.movements.MoveRightDown;
import gameengine.movements.MoveRightUp;
import gameengine.movements.MoveUpLeft;
import gameengine.movements.MoveUpRight;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Game extends Observable implements PlayersEnviroment {

    private Player[] players;
    private int turnIndicator;
    private Board board;
    private GameOverChecker gameOverChecker;

    public Game(Player playerOne, Player playerTwo) {
        this.players = new Player[2];
        this.players[0] = playerOne;
        this.players[1] = playerTwo;
        this.turnIndicator = 0;
        this.board = BoardFactory.getInitialState(players, turnIndicator);
        this.gameOverChecker = new GameOverChecker(this);
    }

    public void start() {
        while (true) {
            System.out.println("Let me thing");
            board = playNextTurn(board);
            notifyChangeInBoard();
            if (gameOverChecker.check(board)) break;
            toggleTurn();
            System.out.println("your turn");
            board = playNextTurn(board);
            notifyChangeInBoard();
            if (gameOverChecker.check(board)) break;
            toggleTurn();
        }
        System.out.println("Congratulations: " + players[turnIndicator].getName() + ", You Win");
    }

    private Board playNextTurn(Board currentState) {
        return players[turnIndicator].playTurn(currentState, this);
    }

    private void toggleTurn() {
        turnIndicator = (turnIndicator + 1) % 2;
    }

    private void notifyChangeInBoard() {
        setChanged();
        notifyObservers(board);
    }

    @Override
    public boolean isFinalState(State state) {
        return gameOverChecker.check((Board) state);
    }

    @Override
    public boolean isTurnOf(State state) {
        return (turnIndicator == ((Board) state).getTurnIndicator());
    }

    @Override
    public List getApplicableActions(State state) {
        Board currentBoard = (Board) state;
        List<Action> applicableActions = new ArrayList<>();
        for (Chip chipOnBoard : currentBoard.cloneChips())
            if (chipOnBoard.getOwner() == players[turnIndicator])
                applicableActions.addAll(getActionsFor(chipOnBoard, currentBoard));
        return applicableActions;
    }

    private List<Action> getActionsFor(Chip chipOnBoard, Board currentBoard) {
        List<Action> actionsForChip = new ArrayList<>();
        for (Action action : getActionList(chipOnBoard))
            if (action.isApplicable(currentBoard))
                actionsForChip.add(action);
        return actionsForChip;

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

    public Player[] getPlayers() {
        return players;
    }

    public int getTurnIndicator() {
        return turnIndicator;
    }

    public Board getBoard() {
        return board;
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
}
