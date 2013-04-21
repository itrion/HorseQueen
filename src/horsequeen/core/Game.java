package horsequeen.core;

public class Game implements TileSelectedListener {

    private final int ONE = 0;
    private final int TWO = 1;
    
    private Player[] players;
    private Tile origin;
    private Tile target;
    private int playerTurnIndicator;
    private Board board;

    public Game(Player playerOne, Player playerTwo, Board board) {
        this.players = new Player[]{playerOne, playerTwo};
        this.playerTurnIndicator = 0;
        this.board = board;
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
        if (origin == null) {
            if (tileIsValidForOrigin(tile))
                origin = tile;
            return;
        } else if (target == null)
            target = tile;
        if (!movementIsValid()) {
            resetMovement();
        } else {
            move();
            playerTurnIndicator = (playerTurnIndicator + 1) % 2;
        }
    }

    private boolean movementIsValid() {
        //TODO verify the movement
        return true;
    }

    private void move() {
        target.putOccupant(origin.getOccupant());
        origin.clear();
        resetMovement();
    }

    private boolean tileIsValidForOrigin(Tile tile) {
        if (tile.isEmpty()) return false;
        else if (tile.getOccupant().getOwner() != players[playerTurnIndicator]) return false;
        else return true;
    }

    private void resetMovement() {
        origin = null;
        target = null;
    }
}
