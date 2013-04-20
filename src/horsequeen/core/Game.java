package horsequeen.core;

public class Game {

    private final int QUEEN_BABIES = 5;
    private final int PLAYER_ONE_START_ROW;
    private final int PLAYER_ONE_START_COLUMN;
    private final int PLAYER_TWO_START_ROW;
    private final int PLAYER_TWO_START_COLUMN;
    private Player playerOne;
    private Player playerTwo;
    private Board board;

    public Game(Player playerOne, Player playerTwo, Board board) {
        PLAYER_ONE_START_ROW = 0;
        PLAYER_ONE_START_COLUMN = board.getColumns() / 2 - 1;
        PLAYER_TWO_START_ROW = board.getRows()-1;
        PLAYER_TWO_START_COLUMN = board.getColumns() / 2 + 1;
        
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.board = board;
        board.putOccupant(new Queen(playerOne, QUEEN_BABIES), PLAYER_ONE_START_ROW, PLAYER_ONE_START_COLUMN);
        board.putOccupant(new Queen(playerTwo, QUEEN_BABIES), PLAYER_TWO_START_ROW, PLAYER_TWO_START_COLUMN);
    }

    public void play() {
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Board getBoard() {
        return board;
    }
}
