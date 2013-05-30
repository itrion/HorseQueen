package gameengine.movements;

import gameengine.Chip;
import gameengine.Movement;

public class MoveDownLeft extends Movement {

    public MoveDownLeft(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + ONE_ROW_DOWN + TWO_COLUMNS_LEFT;
    }
}
