package horsequeen.players;

import core.ai.PlayersEnviroment;
import horsequeen.Board;
import horsequeen.Player;

public class RealPlayer extends Player{

    public RealPlayer(String name) {
        super(name);
    }

    @Override
    public Board play(Board currentState, PlayersEnviroment enviroment) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
