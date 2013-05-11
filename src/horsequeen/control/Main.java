package horsequeen.control;

import horsequeen.core.Board;
import horsequeen.core.Game;
import horsequeen.core.HorseQueenPlayer;
import horsequeen.core.Queen;
import horsequeen.core.Tile;
import horsequeen.view.BoardViewer;
import horsequeen.view.TileViewer;

public class Main {

    private final int ROWS = 8;
    private final int COLUMNS = 8;

    public static void main(String... args) {
        Main main = new Main();
        main.init();
    }

    private void init() {
        HorseQueenPlayer playerOne = new HorseQueenPlayer("ivory");
        HorseQueenPlayer playerTwo = new HorseQueenPlayer("cigar");
        Queen ivoryQueen = new Queen(playerOne);
        Queen cigarQueen = new Queen(playerTwo);
        Board board = new Board(ROWS, COLUMNS);
        Game game = new Game(playerOne, playerTwo, board);
        BoardViewer boardViewer = new BoardViewer(board.getRows(), board.getColumns());
        for (Tile boardTile : board.getTiles())
            boardViewer.add(new TileViewer(boardTile));
        board.initializeBoard(ivoryQueen, cigarQueen);
        boardViewer.pack();
    }
}
