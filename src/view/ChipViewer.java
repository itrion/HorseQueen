package view;

import gameengine.model.Chip;
import gameengine.model.Queen;
import gameengine.players.guiplayer.ChipSelectedListener;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ChipViewer extends JPanel implements MouseListener {

    private Chip chip;
    private ChipSelectedListener chipSelectedListener;
    private int index;
    private Color color;

    public ChipViewer(Chip chip, ChipSelectedListener chipSelectedListener, int index) {
        this.chip = chip;
        this.chipSelectedListener = chipSelectedListener;
        this.index = index;
        configurePanel();
    }

    private void configurePanel() {
        addMouseListener(this);
        setPreferredSize(new Dimension(60, 60));
        setBorder(new LineBorder(Color.BLACK));
        color = getBackground();
        if (chip == null) return;
        if (chip instanceof Queen) drawQueen();
        else drawMonkey();
        color = Color.decode("#D2B58D");
        if (chip.getOwner().getTurnIndicator() == 0)
            color = Color.decode("#FAEED8");
        setBackground(color);


    }

    private void drawQueen() {
        add(new JLabel("Q" + ((Queen) chip).getSons()));
        add(new JLabel("ID" + chip.getPosition()));
    }

    private void drawMonkey() {
        add(new JLabel("M"));
        add(new JLabel("ID" + chip.getPosition()));
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        chipSelectedListener.chipSelected(this);
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    public void fill() {
        setBackground(Color.cyan);
    }

    public Chip getChip() {
        return chip;
    }

    public int getIndex() {
        return index;
    }

    void clean() {
        setBackground(color);
    }
}
