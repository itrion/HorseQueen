package horsequeen.actions;

import horsequeen.Chip;

public class MoveRightDown extends Movement{

    public MoveRightDown(Chip chip) {
        super(chip);
    }

    @Override
    protected int getNewPosition() {
        return chip.getPosition() + TWO_COLUMNS_RIGHT + ONE_ROW_DOWN;
    }
}
