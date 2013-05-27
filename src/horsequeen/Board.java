package horsequeen;

import core.ai.InformedState;
import core.ai.State;
import java.util.List;

public class Board extends InformedState {

    private List<Chip> chips;

    public Board() {
        super(null);
    }

    @Override
    public boolean equals(State otherState) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Chip> getChips() {
        return chips;
    }
}
