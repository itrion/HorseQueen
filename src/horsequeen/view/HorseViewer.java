package horsequeen.view;

import horsequeen.core.Chip;
import horsequeen.core.Horse;
import java.awt.Component;
import javax.swing.JLabel;

public class HorseViewer implements ChipViewer{

    private Horse horse;
    
    public HorseViewer() {
    }

    @Override
    public Component update() {
        return new JLabel("H");
    }

    @Override
    public void setChip(Chip chip) {
        this.horse = (Horse) chip;
    }

}
