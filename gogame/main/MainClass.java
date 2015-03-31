
package gogame.main;
import gogame.board.GameBoardGUI;
import javax.swing.JFrame;

/**
 *
 * @author Michail & Josh
 */
public class MainClass {
    /**
     * Main class method
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GameBoardGUI.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new gogame.board.GameBoardGUI();
                Forms.center(frame, null);
                frame.setVisible(true);
            }
        });
    }
}
