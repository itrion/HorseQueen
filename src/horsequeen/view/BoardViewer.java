package horsequeen.view;

import java.awt.GridLayout;
import javax.swing.JFrame;

public class BoardViewer extends JFrame {

    private int rows;
    private int columns;

    public BoardViewer(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        init();
    }

    private void init() {
        setVisible(true);
        getContentPane().setLayout(new GridLayout(rows, columns));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
