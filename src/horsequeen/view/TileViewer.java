package horsequeen.view;

import horsequeen.core.Chip;
import horsequeen.core.Tile;
import horsequeen.core.TileSelectedListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TileViewer extends JPanel implements Observer, MouseListener {

    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 50;
    private TileSelectedListener tileSelectedListener;
    private final Tile tile;

    public TileViewer(Tile tile, TileSelectedListener tileSelectedListener) {
        this.tile = tile;
        this.tileSelectedListener = tileSelectedListener;
        configurePanel();
    }

    private void configurePanel() {
        tile.addObserver(this);
        addMouseListener(this);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.black));
    }

    public Dimension getTileSize() {
        return getPreferredSize();
    }

    public void setTileSize(Dimension tileSize) {
        setPreferredSize(tileSize);
    }

    @Override
    public void update(Observable o, Object arg) {
        Chip chip = (Chip) arg;
        if (chip == null) removeAll();
        else {
            ChipViewer chipViewer = ChipViewerFactory.getChipViewer(chip);
            add(chipViewer.update());
        }
        revalidate();
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        tileSelectedListener.notifyTileSelected(tile);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
