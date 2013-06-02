package gameengine.players;

import core.ai.Action;
import core.ai.PlayersEnviroment;
import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.model.Movement;
import gameengine.model.Player;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuiPlayer extends Player {

    public GuiPlayer(String name, int turnIndicator) {
        super(name, turnIndicator);
    }

    @Override
    public Board playTurn(Board currentState, PlayersEnviroment enviroment) {
        try {
            List<Action> applicableActions = enviroment.getApplicableActions(currentState);
            int index = 0;
            System.out.println("Chose movement");
            for (Iterator<Action> it = applicableActions.iterator(); it.hasNext();) {
                Movement movement = (Movement) it.next();
                Chip chip = movement.getChip();
                System.out.println(index++ + ") " + chip.getPosition() + " ID " + movementName(movement));
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String readLine = br.readLine();
            return (Board) applicableActions.get(Integer.valueOf(readLine)).execute(currentState);
        } catch (IOException ex) {
            Logger.getLogger(GuiPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private String movementName(Movement movement) {
        String name = movement.getClass().getName();
        return name.substring(name.lastIndexOf(".") + 1);
    }
}
