package horsequeen.view;

import horsequeen.core.Chip;
import horsequeen.core.Horse;
import horsequeen.core.Queen;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

class ChipViewerFactory {

    private static final HashMap<String, Class<?extends ChipViewer>> chipViewers;
    static{
        chipViewers = new HashMap<>();
        chipViewers.put(Queen.class.getSimpleName(), QueenViewer.class);
        chipViewers.put(Horse.class.getSimpleName(), HorseViewer.class);
    }
    static ChipViewer getChipViewer(Chip chip) {
        try {
            ChipViewer newChipViewer = chipViewers.get(chip.getClass().getSimpleName()).newInstance();
            newChipViewer.setChip(chip);
            return newChipViewer;
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(ChipViewerFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
