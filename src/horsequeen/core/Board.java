package horsequeen.core;

import java.util.ArrayList;

public class Board {

    private int rows;
    private int columns;
    private int numberOfTiles;
    private ArrayList<Tile> tiles;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfTiles = columns * rows;
        this.tiles = createTiles();
    }

    public void putOccupant(Chip occupant, int row, int column) {
        tiles.get(getIndexOfTileIn(row, column)).putOccupant(occupant);
    }
    
    public boolean isEmpty(int row, int column){
        return tiles.get(getIndexOfTileIn(row, column)).isEmpty();
    }
    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public int getNumberOfTiles() {
        return numberOfTiles;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    private ArrayList<Tile> createTiles() {
        ArrayList<Tile> tileList = new ArrayList<>();
        for (int i = 0; i < numberOfTiles; i++) {
            tileList.add(new Tile());
        }
        return tileList;
    }

    public int getIndexOfTileIn(int row, int column) {
        return row * columns + column;
    }
}
