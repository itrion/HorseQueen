package view;

import gameengine.model.Board;
import gameengine.model.Chip;
import java.awt.GridLayout;
import javax.swing.JPanel;

public class BoardViewer extends JPanel {

    private Board board;

    public BoardViewer(Board board) {
        this.board = board;
        configurePanel();
    }

    private void configurePanel() {
        setLayout(new GridLayout(Board.ROWS, Board.COLS));
        for (int i = 0; i < board.getSize(); i++) {
            Chip chip = board.getChip(i);
            add(new ChipViewer(chip));
        }
    }
}
