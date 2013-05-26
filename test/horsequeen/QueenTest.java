package horsequeen;

import horsequeen.core.HorseQueenPlayer;
import horsequeen.core.Queen;
import junit.framework.Assert;
import org.junit.Test;

public class QueenTest {

    @Test
    public void testNewQueen() {
        Queen ivoryQueen = new Queen(new HorseQueenPlayer("mock"));
        Assert.assertEquals(5, ivoryQueen.getRemainingBabies());
    }

    @Test
    public void testDecreaseBabies() {
        Queen ivoryQueen = new Queen(new HorseQueenPlayer("mock"));
        ivoryQueen.decreaseBabies();
        Assert.assertEquals(4, ivoryQueen.getRemainingBabies());
        ivoryQueen.decreaseBabies();
        Assert.assertEquals(3, ivoryQueen.getRemainingBabies());
    }
}
