package horsequeen.core;

import java.util.ArrayList;
import java.util.List;

public class HorseQueenPlayer {

    private String name;
    private List<Chip> myChips;

    public HorseQueenPlayer(String name) {
        this.name = name;
        this.myChips = new ArrayList<>();
        this.myChips.add(new Queen(this));
    }
    
    public Chip getQueen(){
        return myChips.get(0);
    }

    public String getName() {
        return name;
    }

    public Movement getMovement() {
        return null;
    }
}
