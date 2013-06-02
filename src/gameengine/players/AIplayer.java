package gameengine.players;

import core.ai.Action;
import core.ai.PlayersEnviroment;
import core.ai.searches.MiniMax;
import gameengine.model.Board;
import gameengine.model.Movement;
import gameengine.model.Player;
import java.util.List;

public class AIplayer extends Player {

    private int maxDepth;

    public AIplayer(String name, int turnIndicator) {
        super(name, turnIndicator);
        this.maxDepth = 5;
    }

    @Override
    public Board playTurn(Board currentState, PlayersEnviroment enviroment) {
        if (isFirstTurn(currentState)) return randomizeFirstTurn(currentState, enviroment);
        System.out.println("Ai movements");
        List<Action> applicableActions = enviroment.getApplicableActions(currentState);
        for (Action action : applicableActions) {
            String actionName = action.getClass().getName();
            actionName = actionName.substring(actionName.lastIndexOf(".") + 1);
            System.out.println(((Movement) action).getChip().getPosition() + " " + actionName);
        }
        return (Board) new MiniMax(new DefensiveHeuristic(), enviroment).searchNextState(currentState, maxDepth);
    }

    private boolean isFirstTurn(Board currentState) {
        return currentState.getChips().size() == 2;
    }

    private Board randomizeFirstTurn(Board currentState, PlayersEnviroment enviroment) {
        List<Action> applicableActions = enviroment.getApplicableActions(currentState);
        return (Board) applicableActions.get(randomNumber(applicableActions.size())).execute(currentState);
    }

    private int randomNumber(int size) {
        return (int) ((Math.random() * size));
    }
}
