package horsequeen.actions;

import horsequeen.Chip;

public class MoveLeftDown extends Movement{

    public MoveLeftDown(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + TWO_COLUMNS_LEFT + ONE_ROW_DOWN;
    }
}
