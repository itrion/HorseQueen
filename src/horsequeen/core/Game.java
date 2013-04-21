package horsequeen.core;

public class Game implements TileSelectedListener {

    private final int QUEEN_BABIES = 5;
    private final int ONE = 0;
    private final int TWO = 1;
    private final int PLAYER_ONE_START_ROW;
    private final int PLAYER_ONE_START_COLUMN;
    private final int PLAYER_TWO_START_ROW;
    private final int PLAYER_TWO_START_COLUMN;
    private Player[] players;
    private Tile origin;
    private Tile target;
    private int playerTurnIndicator;
    private Board board;

    public Game(Player playerOne, Player playerTwo, Board board) {
        this.PLAYER_ONE_START_ROW = 0;
        this.PLAYER_ONE_START_COLUMN = board.getColumns() / 2 - 1;
        this.PLAYER_TWO_START_ROW = board.getRows() - 1;
        this.PLAYER_TWO_START_COLUMN = board.getColumns() / 2 + 1;
        this.players = new Player[]{playerOne, playerTwo};
        this.playerTurnIndicator = 0;
        this.board = board;
    }

    public void initializeGame() {
        board.putOccupant(new Queen(players[ONE], QUEEN_BABIES), PLAYER_ONE_START_ROW, PLAYER_ONE_START_COLUMN);
        board.putOccupant(new Queen(players[TWO], QUEEN_BABIES), PLAYER_TWO_START_ROW, PLAYER_TWO_START_COLUMN);
    }

    public void play() {
    }

    public Player getPlayerOne() {
        return players[0];
    }

    public Player getPlayerTwo() {
        return players[1];
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public void notifyTileSelected(Tile tile) {
        if (tile.isEmpty() && origin == null)
            return;
        if (origin == null) {
            if (tile.getOccupant().getOwner() != players[playerTurnIndicator]) return;
            origin = tile;
            return;
        } else if (target == null)
            target = tile;
        if (!movementIsValid(origin, target)) {
            origin = null;
            target = null;
        }
        move();
        playerTurnIndicator = (playerTurnIndicator + 1) % 2;
    }

    private boolean movementIsValid(Tile origin, Tile target) {
        //TODO verify the movement
        return true;
    }

    private void move() {
        target.putOccupant(origin.getOccupant());
        origin.clear();
        origin = null;
        target = null;
    }
}
