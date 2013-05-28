package gameengine;

public class RuleChecker {

    public static boolean chechRules(Chip chip, int newPositions, Board state) {
        //TODO check all the rules
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
