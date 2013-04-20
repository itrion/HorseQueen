package horsequeen.view;

import horsequeen.core.Tile;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class TileViewer extends JPanel implements Observer {

    private static final int DEFAULT_WIDTH = 50;
    private static final int DEFAULT_HEIGHT = 50;
    private Tile tile;

    public TileViewer(Tile tile) {
        this.tile = tile;
        configurePanel();
    }

    private void configurePanel() {
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
        if (arg == null) return;
        System.out.println("You put a " + arg.getClass().getSimpleName());
    }
}
