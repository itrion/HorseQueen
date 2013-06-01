package gameengine.movements;

import gameengine.model.Chip;
import gameengine.model.Movement;

public class MoveUpLeft extends Movement {

    public MoveUpLeft(Chip chip) {
        super(chip);
    }

    @Override
    public int getNewPosition() {
        return chip.getPosition() + ONE_ROW_UP + TWO_COLUMNS_LEFT;
    }
}
