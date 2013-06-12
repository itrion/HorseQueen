package view;

import gameengine.Game;
import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.players.guiplayer.ChipSelectedListener;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameViewer extends JFrame implements Observer, ChipSelectedListener {

    private Game game;
    private JPanel boardPanel;
    private Chip nextClickedChip;
    private BoardViewer boardViewer;
    private int nextPositionClick;

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
        boardViewer = null;
        boardViewer = new BoardViewer(board, this);
        boardPanel.add(boardViewer);
        boardPanel.revalidate();
        boardPanel.repaint();
    }

    @Override
    public void chipSelected(ChipViewer chipViewer) {
        this.nextClickedChip = chipViewer.getChip();
        this.nextPositionClick = chipViewer.getIndex();
    }

    public Chip getNextClickedChip() {
        nextClickedChip = null;
        while (nextClickedChip == null) waitForCLick();
        return nextClickedChip;
    }

    public int getNextClickedPosition() {
        nextPositionClick = -1;
        while (nextPositionClick < 0) waitForCLick();
        return nextPositionClick;
    }

    public void paintTile(int tilePosition) {
        boardViewer.paintTile(tilePosition);
    }

    private void waitForCLick() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ex) {
            Logger.getLogger(GameViewer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
