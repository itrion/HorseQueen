package horsequeen.view;

import horsequeen.core.Board;
import java.awt.GridLayout;
import javax.swing.JFrame;

public class HorseQueenViewer extends JFrame {

    private Board board;
    
    public HorseQueenViewer(Board board) {
        this.board = board;
        init();
    }

    private void init() {
        getContentPane().setLayout(new GridLayout(board.getRows(), board.getColumns()));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
