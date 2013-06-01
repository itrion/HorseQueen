package gameengine.movements;

import gameengine.model.Chip;
import gameengine.model.Movement;

public class MoveRightDown extends Movement{

    public MoveRightDown(Chip chip) {
        super(chip);
    }

    @Override
    public int getNewPosition() {
        return chip.getPosition() + ONE_COLUMN_RIGHT + TWO_ROWS_DOWN;
    }
}
