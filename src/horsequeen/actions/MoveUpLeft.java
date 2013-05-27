package horsequeen.actions;

import core.ai.Action;
import core.ai.State;
import horsequeen.Chip;

public class MoveUpLeft implements Action {

    private Chip chip;

    public MoveUpLeft(Chip chip) {
        this.chip = chip;
    }

    @Override
    public State execute(State state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isApplicable(State state) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
