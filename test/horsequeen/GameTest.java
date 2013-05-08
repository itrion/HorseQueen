package horsequeen;

import horsequeen.core.Game;
import horsequeen.core.HorseQueenPlayer;
import org.junit.Test;

public class GameTest {
    
    @Test
    public void testMove(){
        Game game = getGame();
        HorseQueenPlayer player = getPlayer();
        game.executeMovement(player.getMovement());
    }

    private Game getGame() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private HorseQueenPlayer getPlayer() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}