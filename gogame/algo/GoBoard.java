package gogame.algo;

import gogame.board.GameBoard;
import java.awt.Color;

/**
 * Class which contains various methods to check for liberties, count and check
 * captures as well
 *
 * @author Michail & Joshua
 */
public class GoBoard {

    /**
     * The scratch board matrix consisting of bytes
     */
    public static byte byGoBoard[][] = new byte[19][19];

    /**
     * Initializes the scratch board
     */
    public GoBoard() {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                byGoBoard[x][y] = 0;
            }
        }
    }
    //Legend: 0-Empty cell
    //        1-Black stone
    //        2-White stone

    /**
     * Used for transferring the GUI form to scratchBoard
     *
     * @param board
     */
    public void toScratchBoard(GameBoard board) {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (board.arrayButtons[x][y].getBackground() == Color.yellow) {
                    byGoBoard[x][y] = 0;
                } else if (board.arrayButtons[x][y].getBackground() == Color.black) {
                    byGoBoard[x][y] = 1;
                } else {
                    byGoBoard[x][y] = 2;
                }
            }
        }
    }

    /**
     * Checks liberties on the scratch board
     *
     * @param a x-coordinate
     * @param b y-coordinate
     * @param List contains the cells traversed by the method
     * @param team player identity
     * @return
     */
    public static boolean checkLiberties(int a, int b, StackQueueList List, byte team) {
        boolean isLiberty = false;
        try {
            if (byGoBoard[a][b] == team) {
                if (!List.isInList(a, b)) {
                    List.add(a, b);
                    isLiberty = checkLiberties(a - 1, b, List, team) || checkLiberties(a + 1, b, List, team) || checkLiberties(a, b - 1, List, team) || checkLiberties(a, b + 1, List, team);
                    //Recursion for checking the liberty of a adjacent stone <in all directions direction>
                } else {
                    return false;
                }
            }
            if (byGoBoard[a][b] == 0) {
                isLiberty = true;
            }
            //Empty cell which denotes that the stones/group has at least 1 liberty
        } catch (Exception e) {
        }
        return isLiberty;//Checks if there is liberties
    }

    /**
     * Counts the number of capturable units
     * @param team
     * @return the number of capturable units
     */
    public static int checkCaptures(byte team) {
        StackQueueList List = new StackQueueList();
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (byGoBoard[x][y] == team && !checkLiberties(x, y, new StackQueueList(), team)) {
                    List.add(x, y);
                }
            }
        }
        return List.length();
    }
    
    /**
     * Removes from play the captured stones
     * @param team 
     */
    public static void capture(byte team) {
        StackQueueList List = new StackQueueList();
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (byGoBoard[x][y] == team && !checkLiberties(x, y, new StackQueueList(), team)) {
                    List.add(x, y);
                }
            }
        }
        for (ListNode util = List.head(); util != null; util = util.next) {
            byGoBoard[util.x][util.y] = 0;
        }
    }

    /**
     * Counting the number of pieces present
     * @param team Denotes what piece is being counted
     * @return 
     */
    public static int count(byte team) {
        int intCurrCount = 0;
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (GoBoard.byGoBoard[x][y] == team) {
                    intCurrCount++;
                }
            }
        }
        return intCurrCount;
    }
}
