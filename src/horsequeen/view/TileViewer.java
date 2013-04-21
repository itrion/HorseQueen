package horsequeen.view;

import horsequeen.core.Chip;
import horsequeen.core.Horse;
import horsequeen.core.Queen;
import horsequeen.core.Tile;
import horsequeen.core.TileSelectedListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TileViewer extends JPanel implements Observer, MouseListener {

    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 50;
    private TileSelectedListener tileSelectedListener;
    private JLabel text;
    private final Tile tile;

    public TileViewer(Tile tile) {
        this.tile = tile;
        configurePanel();
    }

    private void configurePanel() {
        tile.addObserver(this);
        text = new JLabel();
        addMouseListener(this);
        setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));
        setBackground(Color.WHITE);
        setBorder(new LineBorder(Color.black));
        add(text);
    }

    public Dimension getTileSize() {
        return getPreferredSize();
    }

    public void setTileSize(Dimension tileSize) {
        setPreferredSize(tileSize);
    }

    public void setTileSelectedListener(TileSelectedListener tileSelectedListener) {
        this.tileSelectedListener = tileSelectedListener;
    }

    @Override
    public void update(Observable o, Object arg) {
        //TODO create the chipviewer or somethig to draw the tile
        Chip occupant = (Chip) arg;
        if (occupant instanceof Queen)
            text.setText("Q");
        else if (occupant instanceof Horse)
            text.setText("M");
        else
            text.setText("");
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
