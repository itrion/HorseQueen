package horsequeen;

import horsequeen.players.AIplayer;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.execute();
    }

    private void execute() {
        Player playerOne = new AIplayer("Johan");
        Player playerTwo = new AIplayer("Machine");
        Game game = new Game(playerOne, playerTwo);
        game.start();
    }
}
