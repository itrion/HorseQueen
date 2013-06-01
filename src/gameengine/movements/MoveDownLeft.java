package gameengine.movements;

import gameengine.model.Chip;
import gameengine.model.Movement;

public class MoveDownLeft extends Movement {

    public MoveDownLeft(Chip chip) {
        super(chip);
    }

    @Override
    public int getNewPosition() {
        return chip.getPosition() + ONE_ROW_DOWN + TWO_COLUMNS_LEFT;
    }
}
