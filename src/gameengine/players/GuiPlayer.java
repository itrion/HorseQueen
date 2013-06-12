package gameengine.players;

import gameengine.players.guiplayer.ChipSelectedListener;
import core.ai.Action;
import core.ai.PlayersEnviroment;
import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.model.Movement;
import gameengine.model.Player;
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
        Chip selectedChip = getSelectedChip();
        Map<Integer, Movement> positions = new HashMap<>();
        List<Action> applicableActions = enviroment.getApplicableActions(currentState);
        for (Iterator<Action> it = applicableActions.iterator(); it.hasNext();) {
            Movement movement = (Movement) it.next();
            if (selectedChip == movement.getChip()) {
                showTip(movement);
                positions.put(movement.getNewPosition(), movement);
            }
        }
        int selectedPosition = -1;
        while (!validPosition(selectedPosition, positions))
            selectedPosition = getSelectedPosition();
        return positions.get(selectedPosition).execute(currentState);
    }

    private Chip getSelectedChip() {
        //TODO surely there will not be time to select the chip
        return gameViewer.getLastClickedChip();
    }

    private void showTip(Movement movement) {
        gameViewer.paintTile(movement.getNewPosition());
    }

    private int getSelectedPosition() {
        return 18;
    }

    public void setGameViewer(GameViewer gameViewer) {
        this.gameViewer = gameViewer;
    }

    private boolean validPosition(int selectedPosition, Map<Integer, Movement> positions) {
        return true;
    }
}
