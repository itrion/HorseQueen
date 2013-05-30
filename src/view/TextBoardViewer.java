package view;

import gameengine.model.Board;
import gameengine.model.Chip;

public class TextBoardViewer {

    private Board board;

    public TextBoardViewer(Board board) {
        this.board = board;
    }

    @Override
    public String toString() {
        String out = new String();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= 8; j++) {
                Chip chip = board.getChip((i * 8) + j);
                if (chip == null) out += "# ";
                else out += new ChipViewer(chip).toString() + " ";
            }
            out += "\n";
        }
        out += "\n\n";
        return out;
    }
}
