package gameengine;

import gameengine.model.Player;
import gameengine.players.AIplayer;
import gameengine.players.GuiPlayer;
import view.GameViewer;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }

    private void execute() {
        Player playerOne = new AIplayer("Mark Steere", 0);
        GuiPlayer playerTwo = new GuiPlayer("Johan", 1);
        Game game = new Game(playerOne, playerTwo);
        GameViewer gameViewer = new GameViewer(game);
        playerTwo.setGameViewer(gameViewer);
        gameViewer.view();
        game.start();
    }
}
