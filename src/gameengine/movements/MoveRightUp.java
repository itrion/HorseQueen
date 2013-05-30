package gameengine.movements;

import gameengine.Chip;
import gameengine.Movement;

public class MoveRightUp extends Movement {

    public MoveRightUp(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + ONE_COLUMN_RIGHT + TWO_ROWS_UP;
    }

}
