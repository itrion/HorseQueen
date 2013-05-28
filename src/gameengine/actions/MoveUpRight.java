package gameengine.actions;

import gameengine.Chip;

public class MoveUpRight extends Movement{

    public MoveUpRight(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + TWO_ROWS_UP + ONE_COLUMN_RIGHT;
    }
}
