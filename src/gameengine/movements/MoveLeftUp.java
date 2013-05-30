package gameengine.movements;

import gameengine.Chip;
import gameengine.Movement;

public class MoveLeftUp extends Movement {

    public MoveLeftUp(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + ONE_COLUMN_LEFT + TWO_ROWS_UP;
    }
}
