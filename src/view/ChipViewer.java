package view;

import gameengine.model.Chip;
import gameengine.model.Queen;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ChipViewer extends JPanel {

    private Chip chip;

    public ChipViewer(Chip chip) {
        this.chip = chip;
        configurePanel();
    }

    private void configurePanel() {
        setPreferredSize(new Dimension(60, 60));
        setBorder(new LineBorder(Color.BLACK));
        if (chip == null) return;
        if (chip instanceof Queen) drawQueen();
        else drawMonkey();

    }

    private void drawQueen() {
        add(new JLabel("Q"+ ((Queen) chip).getSons()));
        add(new JLabel("pos" + chip.getPosition()));
    }

    private void drawMonkey() {
        add(new JLabel("M"));
        add(new JLabel("pos" + chip.getPosition()));
    }
}
