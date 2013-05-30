package gameengine.players;

import core.ai.PlayersEnviroment;
import core.ai.searches.MiniMax;
import gameengine.Board;
import gameengine.DefensiveHeuristic;
import gameengine.Player;

public class AIplayer extends Player {

    private int maxDepth;

    public AIplayer(String name) {
        super(name);
        this.maxDepth = 3;
    }

    @Override
    public Board play(Board currentState, PlayersEnviroment enviroment) {
        return (Board) new MiniMax(new DefensiveHeuristic(), enviroment).searchNextState(currentState, maxDepth);
    }
}
