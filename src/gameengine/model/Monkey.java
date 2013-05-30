package gameengine.model;
public class Monkey extends Chip{

    public Monkey(Player owner, int position) {
        super(owner, position);
    }

    @Override
    public Monkey clone(){
        return new Monkey(getOwner(), getPosition());
    }
}
