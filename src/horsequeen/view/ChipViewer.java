package horsequeen.view;

import horsequeen.core.Chip;
import java.awt.Component;

public interface ChipViewer {
    public Component update(); 
    public void setChip(Chip chip);
}
