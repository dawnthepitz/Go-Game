package gogame.img;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import javax.swing.JButton;

/**
 * Utility Class that enables the production of Rounded Buttons
 * @author Michail
 */
public class RoundButton extends JButton {

    /**
     * These statements enlarge the button so that it becomes a circle rather
     * than an oval.
     */
    public RoundButton() {
        super();
        Dimension size = getPreferredSize();
        size.width = size.height = Math.max(size.width, size.height);
        setPreferredSize(size);
        setContentAreaFilled(false);
    }

    /**
     * Paint the round background and label
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(getBackground());
        if (!(getBackground() == Color.yellow))
            g2d.fillOval(0, 0, getSize().width - 1, getSize().height - 1);

        super.paintComponent(g);
    }
/**
 * Hit detection.
 */
    Shape shape;
/**
 * If the button has changed size, make a new shape object.
 * @param x x-size
 * @param y y-size
 * @return 
 */
    public boolean contains(int x, int y) {

        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
        }
        return shape.contains(x, y);
    }
}