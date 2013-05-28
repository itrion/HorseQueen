package gameengine.movements;

import gameengine.Movement;
import gameengine.Chip;

public class MoveLeftUp extends Movement {

    public MoveLeftUp(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + TWO_COLUMNS_LEFT + ONE_ROW_UP;
    }
}