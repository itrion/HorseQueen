package view;

import gameengine.Game;
import gameengine.model.Board;
import gameengine.model.Chip;
import gameengine.players.guiplayer.ChipSelectedListener;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameViewer extends JFrame implements Observer, ChipSelectedListener {

    private Game game;
    private JPanel boardPanel;
    private Chip lastClickedChip;
    private BoardViewer boardViewer;

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
        removeAllMouseListeners();
        boardPanel.removeAll();
        boardViewer = null;
        boardViewer = new BoardViewer(board, this);
        addAllMouseListeners(boardViewer);
        boardPanel.add(boardViewer);
        boardPanel.revalidate();
        boardPanel.repaint();
    }

    @Override
    public void chipSelected(Chip chip) {
        this.lastClickedChip = chip;
    }

    public Chip getLastClickedChip() {
        while (lastClickedChip == null);
        return lastClickedChip;
    }

    public void paintTile(int tilePosition) {
        boardViewer.paintTile(tilePosition);
    }

    private void removeAllMouseListeners() {
        for (MouseListener mouseListener : getMouseListeners())
            removeMouseListener(mouseListener);
    }

    private void addAllMouseListeners(BoardViewer boardViewer) {
        for (ChipViewer chipViewer : boardViewer.getChipViewers()) {
            addMouseListener(chipViewer);
        }
    }
}
