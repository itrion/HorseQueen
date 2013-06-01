package gameengine.movements;

import gameengine.model.Chip;
import gameengine.model.Movement;

public class MoveRightUp extends Movement {

    public MoveRightUp(Chip chip) {
        super(chip);
    }

    @Override
    public int getNewPosition() {
        return chip.getPosition() + ONE_COLUMN_RIGHT + TWO_ROWS_UP;
    }

}
