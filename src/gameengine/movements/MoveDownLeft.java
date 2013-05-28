package gameengine.movements;

import gameengine.Movement;
import gameengine.Chip;

public class MoveDownLeft extends Movement {

    public MoveDownLeft(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + TWO_ROWS_DOWN + ONE_COLUMN_LEFT;
    }
}
