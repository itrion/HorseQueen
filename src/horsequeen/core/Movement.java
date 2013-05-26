package horsequeen.core;

public class Movement {

    private Chip chipt;
    private Tile target;

    public Movement(Chip chipt, Tile target) {
        this.chipt = chipt;
        this.target = target;
    }

    public HorseQueenPlayer getOwner() {
        return chipt.getOwner();
    }

    public Chip getChipt() {
        return chipt;
    }

    public Tile getTarget() {
        return target;
    }
}
