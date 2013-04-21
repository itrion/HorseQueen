package horsequeen.view;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class HorseQueenViewer extends JFrame {

    private int rows;
    private int columns;
    public HorseQueenViewer(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        init();
    }
    
    private void init() {
        getContentPane().setLayout(new GridLayout(rows, columns));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
