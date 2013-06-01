package view;

import gameengine.Game;
import gameengine.model.Board;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameViewer extends JFrame implements Observer {

    private Game game;
    private JPanel boardPanel;

    public GameViewer(Game game) {
        this.game = game;
        configureWindow();
    }

    public void view() {
        drawBoard(game.getBoard());
    }

    @Override
    public void update(Observable o, Object board) {
        drawBoard((Board) board);
        pack();
    }

    private void configureWindow() {
        game.addObserver(this);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(500, 500));
        boardPanel = new JPanel();
        add(boardPanel);
        setVisible(true);
        pack();
    }

    private void drawBoard(Board board) {
        boardPanel.removeAll();
        boardPanel.add(new BoardViewer(board));
        boardPanel.revalidate();
        boardPanel.repaint();
    }
}
