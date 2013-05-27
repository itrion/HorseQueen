package horsequeen.actions;

import horsequeen.Chip;

public class MoveUpLeft extends Movement {

    public MoveUpLeft(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() - TWO_ROWS_UP - ONE_COLUMN_LEFT;
    }
}