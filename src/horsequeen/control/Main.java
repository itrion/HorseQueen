package horsequeen.control;

import horsequeen.core.Board;
import horsequeen.core.Game;
import horsequeen.core.Player;
import horsequeen.core.Tile;
import horsequeen.view.HorseQueenViewer;
import horsequeen.view.TileViewer;
import java.util.ArrayList;

public class Main {

    private final int ROWS = 8;
    private final int COLUMNS = 8;

    public static void main(String... args) {
        Main main = new Main();
        main.init();
    }

    private void init() {
        Player ivory = new Player("ivory");
        Player cigar = new Player("cigar");
        Board board = new Board(ROWS, COLUMNS);

        Game game = new Game(ivory, cigar, board);
        HorseQueenViewer horseQueenViewer = new HorseQueenViewer(board);
        for (Tile boardTile : board.getTiles()) {
            TileViewer tileViewer = new TileViewer(boardTile);
            boardTile.addObserver(tileViewer);
            horseQueenViewer.add(tileViewer);
        }
        horseQueenViewer.setVisible(true);
        horseQueenViewer.pack();
    }
}
