package horsequeen.view;

import horsequeen.core.Chip;
import horsequeen.core.Queen;
import java.awt.Component;
import javax.swing.JLabel;

public class QueenViewer extends JLabel implements ChipViewer {

    private Queen queen;

    public QueenViewer() {
    }

    @Override
    public Component update() {
        return new JLabel("Q" + queen.getRemainingBabies());
    }

    @Override
    public void setChip(Chip chip) {
        this.queen = (Queen) chip;
    }
}
