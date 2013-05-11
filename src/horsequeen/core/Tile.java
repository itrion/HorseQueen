package horsequeen.core;
import java.util.Observable;

public class Tile extends Observable implements ChipPlace{

    private boolean isEmpty;
    private Chip occupant;

    public Tile() {
        this.isEmpty = true;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }

    @Override
    public void putChip(Chip occupant) {
        this.occupant = occupant;
        this.isEmpty = false;
        setChanged();
        notifyObservers(occupant);
    }

    @Override
    public Chip getChip() {
        return occupant;
    }

    @Override
    public void cleanPlace() {
        this.occupant = null;
        this.isEmpty = true;
        setChanged();
        notifyObservers();
    }
}
