package horsequeen.core;
import java.util.Observable;

public class Tile extends Observable{

    private boolean isEmpty;
    private Chip occupant;

    public Tile() {
        this.isEmpty = true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void putChip(Chip occupant) {
        this.occupant = occupant;
        this.isEmpty = false;
        setChanged();
        notifyObservers(occupant);
    }

    public Chip getOccupant() {
        return occupant;
    }

    public void clear() {
        setChanged();
        notifyObservers();
        this.occupant = null;
        this.isEmpty = true;
    }
}
