package gameengine.players;

import core.ai.Action;
import core.ai.PlayersEnviroment;
import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.model.Movement;
import gameengine.model.Player;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import view.GameViewer;

public class GuiPlayer extends Player {

    private GameViewer gameViewer;

    public GuiPlayer(String name, int turnIndicator) {
        super(name, turnIndicator);
    }

    @Override
    public Board playTurn(Board currentState, PlayersEnviroment enviroment) {
        Map<Integer, Movement> positions = new HashMap<>();
        ArrayList<Integer> tips = new ArrayList<>();
        int selectedPosition = -1;
        while (true) {
            Chip selectedChip = getSelectedChip();
            List<Action> applicableActions = enviroment.getApplicableActions(currentState);
            for (Iterator<Action> it = applicableActions.iterator(); it.hasNext();) {
                Movement movement = (Movement) it.next();
                if (selectedChip.getPosition() == movement.getChip().getPosition()) {
                    showTip(movement);
                    tips.add(movement.getNewPosition());
                    positions.put(movement.getNewPosition(), movement);
                }
            }
            selectedPosition = getSelectedPosition();
            if (!validPosition(selectedPosition, positions)) {
                cleanTips(tips);
                continue;
            } else break;
        }
        return positions.get(selectedPosition).execute(currentState);
    }

    private Chip getSelectedChip() {
        //TODO surely there will not be time to select the chip
        return gameViewer.getNextClickedChip();
    }

    private void showTip(Movement movement) {
        gameViewer.paintTile(movement.getNewPosition());
    }

    private int getSelectedPosition() {
        return gameViewer.getNextClickedPosition();
    }

    public void setGameViewer(GameViewer gameViewer) {
        this.gameViewer = gameViewer;
    }

    private boolean validPosition(int selectedPosition, Map<Integer, Movement> positions) {
        return positions.containsKey(selectedPosition);
    }

    private void cleanTips(List<Integer> tips) {
        for (Integer tip : tips) {
            gameViewer.cleanTile(tip);
        }
    }
}
