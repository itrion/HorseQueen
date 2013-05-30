package view;

import gameengine.model.Board;
import gameengine.Game;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
        boardPanel = new JPanel();
        add(boardPanel);
        setVisible(true);
        pack();
    }

    private void drawBoard(Board board) {
        boardPanel.removeAll();
        boardPanel.add(new JLabel(new TextBoardViewer(board).toString()));
        boardPanel.revalidate();
        boardPanel.repaint();
    }
}
