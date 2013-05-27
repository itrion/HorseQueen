package horsequeen;

import core.ai.PlayersEnviroment;

public abstract class Player {

    private String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    public abstract Board play(Board currentState, PlayersEnviroment enviroment);
}
