package view;

import gameengine.Board;
import gameengine.Chip;

public class TextBoardViewer {

    private Board board;

    public TextBoardViewer(Board board) {
        this.board = board;
    }

    public void view() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= 8; j++) {
                Chip chip = board.getChip((i * 8) + j);
                if (chip == null) System.out.print("# ");
                else System.out.print(new ChipViewer(chip).toString() + " ");
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }
}
