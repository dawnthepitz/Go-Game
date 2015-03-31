package gogame.main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Window;
import javax.swing.JFrame;

/**
 *
 * @author Michail
 */
public final class Forms {
    /**
     * Prevents an instance of this class
     */
    private Forms() {
        
    }
    /**
     * Centers <code>win</code> on your screen.
     * @param win
     * @param parent 
     */
    public static void center(Window win, Component parent) {
        Dimension parentDim;
        
        if(parent == null)
            parentDim = Toolkit.getDefaultToolkit().getScreenSize();
        else
            parentDim = parent.getSize();
        
        Dimension winDim = win.getSize();
        
        win.setLocation((parentDim.width-winDim.width)/2, (parentDim.height-winDim.height)/2);
    }
}
