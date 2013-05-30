package gameengine.movements;

import gameengine.model.Chip;
import gameengine.model.Movement;

public class MoveLeftDown extends Movement{

    public MoveLeftDown(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + ONE_COLUMN_LEFT + TWO_ROWS_DOWN;
    }
}
