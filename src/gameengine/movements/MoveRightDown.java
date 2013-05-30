package gameengine.movements;

import gameengine.Chip;
import gameengine.Movement;

public class MoveRightDown extends Movement{

    public MoveRightDown(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + ONE_COLUMN_RIGHT + TWO_ROWS_DOWN;
    }
}
