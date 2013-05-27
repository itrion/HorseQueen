package horsequeen;

import core.ai.InformedState;
import core.ai.State;
import java.util.ArrayList;
import java.util.List;

public class Board extends InformedState {

    private List<Chip> chips;

    public Board() {
        super(null);
    }

    public Board(List<Chip> chips) {
        super(null);
        this.chips = chips;
    }

    @Override
    public boolean equals(State otherState) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<Chip> getChips() {
        return chips;
    }

    public boolean addChip(Chip e) {
        return chips.add(e);
    }
}
