package view;

import gameengine.model.Chip;
import gameengine.model.Queen;

public class ChipViewer {

    private Chip chip;

    public ChipViewer(Chip chip) {
        this.chip = chip;
    }

    @Override
    public String toString() {
        if (chip instanceof Queen)
            return "Q";
        else
            return "M";
    }
}
