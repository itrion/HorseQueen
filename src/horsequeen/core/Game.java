package horsequeen.core;

public class Game implements TileSelectedListener {

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

    @Override
    public void notifyTileSelected(Tile tile) {
        if (origin == null) {
            if (tileIsValidForOrigin(tile))
                origin = tile;
            return;
        } else if (target == null)
            target = tile;
        if (movementIsValid()) move();
        else resetMovement();
    }

    private boolean movementIsValid() {
        MovementValidator validator= new MovementValidator(board, origin, target);
        return validator.validate();
    }

    private void move() {
        if (origin.getOccupant() instanceof Queen) moveQueen();
        else moveHorse();
        resetMovement();
        toggleTurn();
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

    private void toggleTurn() {
        playerTurnIndicator = (playerTurnIndicator + 1) % 2;
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

    private void moveQueen() {
        Queen queen = (Queen) origin.getOccupant();
        queen.decreaseBabies();
        origin.clear();
        origin.putChip(new Horse(queen));
        if (!target.isEmpty()) target.clear();
        target.putChip(queen);
    }

    private void moveHorse() {
        if (!target.isEmpty()) target.clear();
        target.putChip(origin.getOccupant());
        origin.clear();
    }
}
