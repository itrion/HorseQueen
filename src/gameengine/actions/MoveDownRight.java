package gameengine.actions;

import gameengine.Chip;

public class MoveDownRight extends Movement {

    public MoveDownRight(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + TWO_ROWS_DOWN + ONE_COLUMN_RIGHT;
    }
}
