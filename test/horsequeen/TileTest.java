package horsequeen;

import horsequeen.core.Horse;
import horsequeen.core.Player;
import horsequeen.core.Queen;
import horsequeen.core.Tile;
import org.junit.Assert;
import org.junit.Test;

public class TileTest {

    @Test
    public void testEmptyTile(){
        Tile tile = new Tile();
        Assert.assertFalse(tile.hasHorse());
        Assert.assertFalse(tile.hasQueen());
        Assert.assertTrue(tile.isEmpty());
    }
    
    @Test
    public void testTileWithQueen(){
        Tile tile = new Tile();
        tile.putOccupant(getQueen());
        Assert.assertFalse(tile.hasHorse());
        Assert.assertTrue(tile.hasQueen());
        Assert.assertFalse(tile.isEmpty());
    }
    
    @Test
    public void testTileWithHorse(){
        Tile tile = new Tile();
        tile.putOccupant(new Horse(getQueen()));
        Assert.assertTrue(tile.hasHorse());
        Assert.assertFalse(tile.hasQueen());
        Assert.assertFalse(tile.isEmpty());
    }
    @Test
    public void testClearTile(){
        Tile tile = new Tile();
        tile.putOccupant(new Horse(getQueen()));
        Assert.assertTrue(tile.hasHorse());
        Assert.assertFalse(tile.hasQueen());
        Assert.assertFalse(tile.isEmpty());
        tile.clear();
        Assert.assertFalse(tile.hasHorse());
        Assert.assertFalse(tile.hasQueen());
        Assert.assertTrue(tile.isEmpty());
    }

    private Queen getQueen() {
        return new Queen(new Player("mock"),5);
    }
}
