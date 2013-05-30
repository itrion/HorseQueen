package gameengine.movements;

import gameengine.model.Chip;
import gameengine.model.Movement;

public class MoveDownRight extends Movement {

    public MoveDownRight(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + ONE_ROW_DOWN + TWO_COLUMNS_RIGHT;
    }
}
