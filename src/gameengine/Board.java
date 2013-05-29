package gameengine;

import core.ai.InformedState;
import core.ai.State;
import java.util.ArrayList;
import java.util.List;

public class Board extends InformedState implements Cloneable {

    private static int ROWS;
    private static int COLS;
    private List<Chip> chips;
    private int turnIndicator;

    public Board(int turnIndicator) {
        super(null);
        this.chips = new ArrayList<>();
        this.turnIndicator = turnIndicator;
    }

    public Board(int turnIndicator, List<Chip> chips) {
        super(null);
        this.chips = chips;
        this.turnIndicator = turnIndicator;
    }

    @Override
    public boolean equals(State otherState) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Chip> getChips() {
        List<Chip> clonedChips = new ArrayList<>();
        for (Chip chip : chips)
            clonedChips.add(chip.clone());
        return clonedChips;
    }

    public boolean addChip(Chip chip) {
        return chips.add(chip);
    }

    public Chip getChip(int index) {
        for (Chip chip : chips)
            if (chip.getPosition() == index) return chip;
        return null;
    }

    public void remove(int index) {
        for (Chip chip : chips)
            if (chip.getPosition() == index) {
                chips.remove(chip);
                return;
            }
    }

    public Chip getEnemyQueen(Chip chip) {
        for (Chip chipInBoard : chips)
            if (isEnemyQueen(chipInBoard, chip)) return chipInBoard;
        return null;
    }

    private boolean isEnemyQueen(Chip chipInBoard, Chip chip) {
        return (chip.getOwner() != chipInBoard.getOwner());
    }

    public int xDistnace(Chip chipA, Chip chipB) {
        return Math.abs(getRow(chipA) - getRow(chipB));
    }

    public int yDistnace(Chip chipA, Chip chipB) {
        return Math.abs(getCol(chipA) - getCol(chipB));
    }

    public int getRow(Chip chip) {
        return chip.getPosition() / ROWS;
    }

    public int getCol(Chip chip) {
        return chip.getPosition() % COLS;
    }

    public double getEuclideanDistance(Chip chipA, Chip chipB) {
        double xDistance = xDistnace(chipA, chipB);
        double yDistance = yDistnace(chipA, chipB);
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }

    public int getTurnIndicator() {
        return turnIndicator;
    }

    public static void setROWS(int ROWS) {
        Board.ROWS = ROWS;
    }

    public static void setCOLS(int COLS) {
        Board.COLS = COLS;
    }

    public boolean isEmpty(int newPosition) {
        return (getChip(newPosition) == null);
    }
}
