package gameengine;

public class BoardIndexTranslator {

    private int rows;
    private int cols;

    public BoardIndexTranslator(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public double getEuclideanDistance(Chip chipA, Chip chipB) {
        double xDistance = xDistnace(chipA, chipB);
        double yDistance = yDistnace(chipA, chipB);
        return Math.sqrt((xDistance * xDistance) + (yDistance * yDistance));
    }

    public int xDistnace(Chip chipA, Chip chipB) {
        return Math.abs(getRow(chipA) - getRow(chipB));
    }

    public int yDistnace(Chip chipA, Chip chipB) {
        return Math.abs(getCol(chipA) - getCol(chipB));
    }

    public int getRow(Chip chip) {
        return chip.getPosition() / rows;
    }

    public int getCol(Chip chip) {
        return chip.getPosition() % cols;
    }
}
