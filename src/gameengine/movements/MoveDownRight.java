package gameengine.movements;

import gameengine.Chip;
import gameengine.Movement;

public class MoveDownRight extends Movement {

    public MoveDownRight(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + ONE_ROW_DOWN + TWO_COLUMNS_RIGHT;
    }
}
