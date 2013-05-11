package horsequeen.core;

public class Game {

    private HorseQueenPlayer[] players;
    private int playerTurnIndicator;
    private Board board;
    private final RulesChecker rulesChecker;

    public Game(HorseQueenPlayer playerOne, HorseQueenPlayer playerTwo, Board board) {
        this.players = new HorseQueenPlayer[]{playerOne, playerTwo};
        this.playerTurnIndicator = 0;
        this.board = board;
        this.rulesChecker = new RulesChecker(board);
    }

    public boolean executeMovement(Movement movement) {
        if (movement.getOwner() != players[playerTurnIndicator]) return false;
        if (!rulesChecker.validate(movement)) return false;
        toggleTurn();
        return true;
    }

    private void toggleTurn() {
        playerTurnIndicator = (playerTurnIndicator + 1) % 2;
    }

    public HorseQueenPlayer getPlayerOne() {
        return players[0];
    }

    public HorseQueenPlayer getPlayerTwo() {
        return players[1];
    }

    public Board getBoard() {
        return board;
    }
}
