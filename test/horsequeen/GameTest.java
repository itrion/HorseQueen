package horsequeen;

import horsequeen.core.Board;
import horsequeen.core.Chip;
import horsequeen.core.Game;
import horsequeen.core.HorseQueenPlayer;
import horsequeen.core.Movement;
import horsequeen.core.Queen;
import horsequeen.core.Tile;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class GameTest {

    @Test
    public void testMovementOfPlayerInInvalidOrder() {
        Game game = getGame();
        HorseQueenPlayer player = game.getPlayerTwo();
        Chip queen = player.getQueen();
        Assert.assertFalse(game.executeMovement(new Movement(queen, game.getBoard().getTiles().get(0))));
    }
    
    @Test
    public void testMovementOfPlayerInValidOrder(){
        Game game = getGame();
        HorseQueenPlayer playerOne = game.getPlayerOne();
        Chip queen = playerOne.getQueen();
        Assert.assertTrue(game.executeMovement(new Movement(queen, game.getBoard().getTiles().get(0))));
    }

    private Game getGame() {
        return new Game(new HorseQueenPlayer("ivory"), new HorseQueenPlayer("cigar"), new Board(8, 8));
    }
}