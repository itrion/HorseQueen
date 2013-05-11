package horsequeen;

import horsequeen.core.Board;
import horsequeen.core.Game;
import horsequeen.core.HorseQueenPlayer;
import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;


public class GameTest {

    private HorseQueenPlayer getMockedPlayer() {
        HorseQueenPlayer mockedPlayer = mock(HorseQueenPlayer.class);
        when(mockedPlayer.getMovement()).thenReturn(null);
        return mockedPlayer;
    }

    @Test
    public void testMovementOfInvalidPlayer() {
        Game game = getGame();
        HorseQueenPlayer player = getMockedPlayer();
        Assert.assertFalse(game.executeMovement(player.getMovement()));
    }

    private Game getGame() {
        return new Game(new HorseQueenPlayer("ivor"), new HorseQueenPlayer("cigar"), new Board(8, 8));
    }
}