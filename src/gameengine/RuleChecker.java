package gameengine;

public class RuleChecker {

    public static boolean chechRules(Chip chip, int newPositions, Board state) {
        //TODO A queen of height two may not make a non-capturing move.
        //TODO A queen may not give birth to its own baby and kill an enemy baby in the same move.
        
        //TODO When not capturing, a baby must move toward the enemy queen
        
        if (chip instanceof Queen) {
            Queen queen = (Queen) chip;
            if (queen.getSons() <= 2 && !isCapturingMovement()) return false;
        }
        return false;
    }

    private static boolean isCapturingMovement() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
