package gameengine.movements;

import gameengine.Chip;
import gameengine.Movement;

public class MoveUpLeft extends Movement {

    public MoveUpLeft(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + ONE_ROW_UP + TWO_COLUMNS_LEFT;
    }
}
