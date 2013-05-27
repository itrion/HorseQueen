package horsequeen.actions;

import horsequeen.Chip;

public class MoveDownLeft extends Movement {

    public MoveDownLeft(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + TWO_ROWS_DOWN + ONE_COLUMN_LEFT;
    }
}