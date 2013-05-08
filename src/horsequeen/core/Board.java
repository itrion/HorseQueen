package horsequeen.core;

import java.util.ArrayList;

public class Board {
    //TODO improve the board: use only the busy tiles to represent the board

    private int rows;
    private int columns;
    private int numberOfTiles;
    private ArrayList<Tile> tiles;

    public Board(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.numberOfTiles = columns * rows;
        initTiles();
    }

    public void putChip(Chip chip, int row, int column) {
        tiles.get(getIndexOfTileIn(row, column)).putChip(chip);
    }

    public boolean isTileEmpty(int row, int column) {
        return tiles.get(getIndexOfTileIn(row, column)).isEmpty();
    }

    public int getNumberOfTiles() {
        return numberOfTiles;
    }

    public ArrayList<Tile> getTiles() {
        return tiles;
    }

    private void initTiles() {
        tiles = new ArrayList<>();
        for (int i = 0; i < numberOfTiles; i++)
            tiles.add(new Tile());
    }

    public int getIndexOfTileIn(int row, int column) {
        return row * columns + column;
    }

    public int getFirstRow() {
        return 0;
    }

    public int getLastRow() {
        return rows - 1;
    }

    public int getFirstColumn() {
        return 0;
    }

    public int getLastColumn() {
        return columns - 1;
    }

    public int getMiddleRow() {
        return rows / 2;
    }

    public int getMiddleColumn() {
        return columns / 2;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public void initializeBoard(Queen playerOneQueen, Queen playerTwoQueen) {
        putChip(playerOneQueen, getFirstRow(), getMiddleColumn() - 1);
        putChip(playerTwoQueen, getLastRow(), getMiddleColumn());
    }

    public int getRow(Tile origin) {
        return tiles.indexOf(origin) / columns;
    }

    public int getColumn(Tile origin) {
        return tiles.lastIndexOf(origin) - getRow(origin) * columns;
    }
}
