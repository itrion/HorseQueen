package horsequeen.players;

import core.ai.Heuristic;
import core.ai.PlayersEnviroment;
import core.ai.searches.MiniMax;
import horsequeen.Board;
import horsequeen.DefensiveHeuristic;
import horsequeen.Player;

public class AIplayer extends Player {

    private int maxDepth;

    public AIplayer(String name) {
        super(name);
    }

    @Override
    public Board play(Board currentState, PlayersEnviroment enviroment) {
        return (Board) new MiniMax(new DefensiveHeuristic(), enviroment).searchNextState(currentState, maxDepth);
    }
}
