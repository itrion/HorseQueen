package gameengine;

import gameengine.model.Player;
import gameengine.players.AIplayer;
import view.GameViewer;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }

    private void execute() {
        Player playerOne = new AIplayer("Mark Steere");
        Player playerTwo = new AIplayer("Johan");
        Game game = new Game(playerOne, playerTwo);
        GameViewer gameViewer = new GameViewer(game);
        gameViewer.view();
        game.start();
    }
}
