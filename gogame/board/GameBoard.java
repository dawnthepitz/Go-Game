package gogame.board;

import gogame.img.RoundButton;
import javax.swing.JButton;

/**
 *
 * @author Michail & Josh
 */
public class GameBoard extends JButton {
    /**
     * Array of buttons used in the GUI matrix
     */
    public JButton arrayButtons[][] = new RoundButton[19][19];

    /**
     * Instantiates the panels on the game board.
     */
    public GameBoard() {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                arrayButtons[x][y] = new RoundButton();
            }
        }
    }
}