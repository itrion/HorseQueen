package gameengine.players;

import core.ai.Action;
import core.ai.InformedState;
import core.ai.PlayersEnviroment;
import core.ai.SearchMetrics;
import core.ai.searches.MiniMax;
import gameengine.model.Board;
import gameengine.model.Player;
import java.util.List;

public class AIplayer extends Player {

    private int maxDepth;

    public AIplayer(String name, int turnIndicator) {
        super(name, turnIndicator);
        this.maxDepth = 6;
    }

    @Override
    public Board playTurn(Board currentState, PlayersEnviroment enviroment) {
        if (isFirstTurn(currentState)) return randomizeFirstTurn(currentState, enviroment);
        MiniMax miniMax = new MiniMax(new DefensiveHeuristic(), enviroment);
        Board nextState = (Board) miniMax.searchNextState(currentState, maxDepth);
        SearchMetrics searchMetrics = miniMax.getSearchMetrics();
        System.out.println("search time: "+searchMetrics.getSearchTime());
        System.out.println("nodes visited: "+searchMetrics.getStatesExpanded());
        return nextState;
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
