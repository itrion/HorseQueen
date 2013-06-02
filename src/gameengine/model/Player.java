package gameengine.model;

import core.ai.PlayersEnviroment;

public abstract class Player {

    private String name;
    private int turnIndicator;

    public Player(String name, int turnIndicator) {
        this.name = name;
        this.turnIndicator = turnIndicator;
    }

    public String getName() {
        return name;
    }

    public int getTurnIndicator() {
        return turnIndicator;
    }

    public abstract Board playTurn(Board currentState, PlayersEnviroment enviroment);
}
