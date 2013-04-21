package horsequeen.control;

import horsequeen.core.Board;
import horsequeen.core.Game;
import horsequeen.core.Player;
import horsequeen.core.Queen;
import horsequeen.core.Tile;
import horsequeen.view.BoardViewer;
import horsequeen.view.TileViewer;

public class Main {

    private final int ROWS = 8;
    private final int COLUMNS = 8;
    private final int QUEEN_BABIES = 5;
    

    public static void main(String... args) {
        Main main = new Main();
        main.init();
    }

    private void init() {
        Player playerOne = new Player("ivory");
        Player playerTwo = new Player("cigar");
        Queen ivoryQueen = new Queen(playerOne, QUEEN_BABIES);
        Queen cigarQueen = new Queen(playerTwo, QUEEN_BABIES);
        Board board = new Board(ROWS, COLUMNS);
        board.initializeBoard(ivoryQueen, cigarQueen);
        Game game = new Game(playerOne, playerTwo, board);

        BoardViewer horseQueenViewer = new BoardViewer(board.getRows(), board.getColumns());
        for (Tile boardTile : board.getTiles())
            horseQueenViewer.add(new TileViewer(boardTile, game));
        
        horseQueenViewer.pack();
    }
}
