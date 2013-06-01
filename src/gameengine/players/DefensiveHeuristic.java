package gameengine.players;

import gameengine.model.Board;
import core.ai.Heuristic;

public class DefensiveHeuristic implements Heuristic<Board> {

    @Override
    public double evaluate(Board state) {
        //TODO fix the evaluation of the heuristic
        return 10;
    }
}
