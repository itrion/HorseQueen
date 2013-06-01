package gameengine.movements;

import gameengine.model.Chip;
import gameengine.model.Movement;

public class MoveLeftUp extends Movement {

    public MoveLeftUp(Chip chip) {
        super(chip);
    }

    @Override
    public int getNewPosition() {
        return chip.getPosition() + ONE_COLUMN_LEFT + TWO_ROWS_UP;
    }
}
