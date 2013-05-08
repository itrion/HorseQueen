package horsequeen;

import horsequeen.core.Board;
import horsequeen.core.HorseQueenPlayer;
import horsequeen.core.Queen;
import horsequeen.core.Tile;
import junit.framework.Assert;
import org.junit.Test;

public class BoardTest {

    @Test
    public void testNumberOfTiles() {
        Board board = getBoard();
        Assert.assertEquals(64, board.getNumberOfTiles());
        Assert.assertEquals(8, board.getRows());
        Assert.assertEquals(8, board.getColumns());
    }

    @Test
    public void testBoardWithoutQueens() {
        Board board = getBoard();
        for (Tile tile : board.getTiles()) {
            Assert.assertTrue(tile.isEmpty());
        }
    }

    @Test
    public void testIndexOf() {
        Board board = getBoard();
        Assert.assertEquals(0, board.getIndexOfTileIn(0, 0));
        Assert.assertEquals(8, board.getIndexOfTileIn(1, 0));
        Assert.assertEquals(63, board.getIndexOfTileIn(7, 7));
    }

    @Test
    public void testPutOccupant() {
        Board board = getBoard();
        board.putChip(new Queen(new HorseQueenPlayer("mock"), 5), 0, 0);
        Assert.assertFalse(board.isTileEmpty(0, 0));
    }

    private Board getBoard() {
        return new Board(8, 8);
    }
}
