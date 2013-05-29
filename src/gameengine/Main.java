package gameengine;

import gameengine.players.AIplayer;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }

    private void execute() {
        Player playerOne = new AIplayer("Mark Steere");
        Player playerTwo = new AIplayer("Johan");
        Game game = new Game(playerOne, playerTwo);
        game.start();
    }
}
