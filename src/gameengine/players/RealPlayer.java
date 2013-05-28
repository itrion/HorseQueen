package gameengine.players;

import core.ai.PlayersEnviroment;
import gameengine.Board;
import gameengine.Player;

public class RealPlayer extends Player{

    public RealPlayer(String name) {
        super(name);
    }

    @Override
    public Board play(Board currentState, PlayersEnviroment enviroment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
