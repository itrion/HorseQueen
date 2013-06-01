package gameengine;

import gameengine.model.Player;
import gameengine.players.GuiPlayer;
import view.GameViewer;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }

    private void execute() {
        Player playerOne = new GuiPlayer("Mark Steere", 1);
        Player playerTwo = new GuiPlayer("Johan", 2);
        Game game = new Game(playerOne, playerTwo);
        GameViewer gameViewer = new GameViewer(game);
        gameViewer.view();
        game.start();
        gameViewer.dispose();
    }
}
