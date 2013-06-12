package view;

import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.players.guiplayer.ChipSelectedListener;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class BoardViewer extends JPanel {

    private Board board;
    private ChipSelectedListener chipSelectedListener;

    public BoardViewer(Board board, ChipSelectedListener chipSelectedListener) {
        this.board = board;
        this.chipSelectedListener = chipSelectedListener;
        configurePanel();
    }

    private void configurePanel() {
        setLayout(new GridLayout(Board.ROWS, Board.COLS));
        for (int i = 0; i < board.getSize(); i++) {
            Chip chip = board.getChip(i);
            add(new ChipViewer(chip, chipSelectedListener, i));
        }
    }

    void paintTile(int tilePosition) {
        ((ChipViewer) getComponent(tilePosition)).fill();
    }

    public List<ChipViewer> getChipViewers() {
        ArrayList<ChipViewer> chipViewers = new ArrayList<>();
        for (Component component : getComponents()) {
            if (component instanceof ChipViewer) chipViewers.add((ChipViewer)component);
        }
        return chipViewers;
    }
}
