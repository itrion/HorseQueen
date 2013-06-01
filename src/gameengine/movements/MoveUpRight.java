package gameengine.movements;

import gameengine.model.Chip;
import gameengine.model.Movement;

public class MoveUpRight extends Movement{

    public MoveUpRight(Chip chip) {
        super(chip);
    }

    @Override
    public int getNewPosition() {
        return chip.getPosition() + ONE_ROW_UP + TWO_COLUMNS_RIGHT;
    }
}
