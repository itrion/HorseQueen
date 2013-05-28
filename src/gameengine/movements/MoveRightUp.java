package gameengine.movements;

import gameengine.Movement;
import core.ai.Action;
import core.ai.State;
import gameengine.Chip;

public class MoveRightUp extends Movement {

    public MoveRightUp(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + TWO_COLUMNS_RIGHT + ONE_ROW_UP;
    }

}
