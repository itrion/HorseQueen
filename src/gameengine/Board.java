package gameengine;

import core.ai.InformedState;
import core.ai.State;
import java.util.ArrayList;
import java.util.List;

public class Board extends InformedState implements Cloneable {

    private List<Chip> chips;

    public Board() {
        super(null);
        this.chips = new ArrayList<>();
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
        List<Chip> clonedChips = new ArrayList<>();
        for (Chip chip : chips)
            clonedChips.add(chip.clone());
        return clonedChips;
    }

    public boolean addChip(Chip chip) {
        return chips.add(chip);
    }

    public Chip getChip(int index) {
        for (Chip chip : chips)
            if (chip.getPosition() == index) return chip;
        return null;
    }
}
