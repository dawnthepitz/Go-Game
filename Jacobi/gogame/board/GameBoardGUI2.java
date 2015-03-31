package gogame.board;

import gogame.algo.GoBoard;
import gogame.algo.ListNode;
import gogame.algo.StackQueueList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author Michail & Josh
 */
public class GameBoardGUI2 extends javax.swing.JFrame implements ActionListener {

    /**
     * Liberty and Capture checking
     */
    public static GoBoard gbScratchBoard = new GoBoard();
    /**
     * Checking for Ko or Board Repetitions
     */
    public static boolean boolKo = false;
    /**
     * Array for GUI Matrix
     */
    public static GameBoard gameBoard = new GameBoard();
    /**
     * Pass control states.
     */
    public static boolean boolPassed = false;
    /**
     * Counters of captures
     */
    public static int BScore = 0, WScore = 0;
    /**
     * Vital coordinates when there is a Ko
     */
    public static int xk = 19, yk = 19;

    /**
     * Constructor for GameBoardGUI class.
     */
    public GameBoardGUI2() {
        initComponents();
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                jpGameBoard.add(gameBoard.arrayButtons[x][y]);
                gameBoard.arrayButtons[x][y].setBackground(Color.yellow);
                gameBoard.arrayButtons[x][y].setBorderPainted(false);
                gameBoard.arrayButtons[x][y].addActionListener(this);
            }
        }
        jbPass.addActionListener(this);
        jbResign.addActionListener(this);
        jbReset.addActionListener(this);
        jbReset.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jpGameBoardLabels = new javax.swing.JPanel();
        jpGameBoard = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jbReset = new javax.swing.JButton();
        jbResign = new javax.swing.JButton();
        jbPass = new javax.swing.JButton();
        jlBackGround = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Go Game Implementation Engine");
        setResizable(false);
        java.awt.GridBagLayout layout = new java.awt.GridBagLayout();
        layout.columnWidths = new int[] {0, 10, 0};
        layout.rowHeights = new int[] {0, 10, 0};
        layout.columnWeights = new double[] {10.0, 10.0};
        layout.rowWeights = new double[] {10.1};
        getContentPane().setLayout(layout);

        jpGameBoardLabels.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(153, 51, 0)));
        jpGameBoardLabels.setOpaque(false);

        jpGameBoard.setOpaque(false);
        jpGameBoard.setLayout(new java.awt.GridLayout(19, 19));

        jbReset.setText("Reset");

        jbResign.setText("Resign");

        jbPass.setText("Pass");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbResign, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbReset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbResign)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbReset)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpGameBoardLabelsLayout = new javax.swing.GroupLayout(jpGameBoardLabels);
        jpGameBoardLabels.setLayout(jpGameBoardLabelsLayout);
        jpGameBoardLabelsLayout.setHorizontalGroup(
            jpGameBoardLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGameBoardLabelsLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jpGameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jpGameBoardLabelsLayout.setVerticalGroup(
            jpGameBoardLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGameBoardLabelsLayout.createSequentialGroup()
                .addGap(0, 5, Short.MAX_VALUE)
                .addGroup(jpGameBoardLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jpGameBoardLabelsLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jpGameBoard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        getContentPane().add(jpGameBoardLabels, gridBagConstraints);

        jlBackGround.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gogame/img/goBoard3.png"))); // NOI18N
        jlBackGround.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jlBackGround.setAlignmentY(0.0F);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 14, 4, 4);
        getContentPane().add(jlBackGround, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbPass;
    private javax.swing.JButton jbReset;
    private javax.swing.JButton jbResign;
    private javax.swing.JLabel jlBackGround;
    private javax.swing.JPanel jpGameBoard;
    private javax.swing.JPanel jpGameBoardLabels;
    // End of variables declaration//GEN-END:variables

    /**
     * Whenever a button is pressed, traces what button is pressed and executes
     * code block accordingly
     * @param e ActionEvent involved
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //Resign Button action
        if (e.getSource() == jbResign) {
            JOptionPane.showMessageDialog(null,
                    "AI Won Via Resignation");
            jbReset.setEnabled(true);
            jbPass.setEnabled(false);
            jbResign.setEnabled(false);
            for (int x = 0; x < 19; x++) {
                for (int y = 0; y < 19; y++) {
                    gameBoard.arrayButtons[x][y].setEnabled(false);
                }
            }
            WScore = BScore = 0;
            return;
        }

        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (e.getSource() == gameBoard.arrayButtons[x][y]) {
                    //Detecting when there is a piece already
                    if (gbScratchBoard.byGoBoard[x][y] != (byte) 0) {
                        JOptionPane.showMessageDialog(null,
                                "There is already a piece there");
                        return;
                    }
                    gbScratchBoard.byGoBoard[x][y] = 1;
                    // This denotes that the pass is not consecutive
                    // Legal move due to the move has liberties
                    if (gbScratchBoard.checkLiberties(x, y, new StackQueueList(), (byte) 1)) {
                        BScore += gbScratchBoard.checkCaptures((byte) 2);
                        gbScratchBoard.capture((byte) 2);
                        boolKo = false;
                        boolPassed = false;
                    } //Suicide Checking(When there is nothing to capture and no liberties)
                    else if (gbScratchBoard.checkCaptures((byte) 2) == 0) {
                        JOptionPane.showMessageDialog(null, "Illegal move due to Suicide");
                        gbScratchBoard.toScratchBoard(gameBoard);
                        return;
                    } //Detection of repetition of the previous board state
                    else if (boolKo && gbScratchBoard.checkCaptures((byte) 2) == 1 && (!gbScratchBoard.checkLiberties(xk, yk, new StackQueueList(), (byte) 2))) {
                        JOptionPane.showMessageDialog(null, "Illegal move due to Board Repetition");
                        gbScratchBoard.toScratchBoard(gameBoard);
                        return;
                    } //Checking when there is a potential Ko on next move and checking for Snapbacks
                    else {
                        boolKo = gbScratchBoard.checkCaptures((byte) 2) == 1;
                        BScore += gbScratchBoard.checkCaptures((byte) 2);
                        gbScratchBoard.capture((byte) 2);
                        xk = x;
                        yk = y;
                        boolPassed = false;
                    }
                }
            }
        }
        toGUI(gbScratchBoard);//Move of Player is ok
        AIMove();
        toGUI(gbScratchBoard);//Move of AI is ok
        // Pass Button
        if (e.getSource() == jbPass && boolPassed == false) {
            boolPassed = true;
            return;
        }// Note: This if statement is for the first "Pass"
        else if (e.getSource() == jbPass) {
            JOptionPane.showMessageDialog(
                    null,
                    "Number of Black Pieces:" + gbScratchBoard.count((byte) 1)
                    + "\nNumber of White Pieces:"
                    + gbScratchBoard.count((byte) 2)
                    + "\nNumber of White Pieces Captured:" + BScore
                    + "\nNumber of Black Pieces Captured:" + WScore);
            jbReset.setEnabled(true);
            WScore = BScore = 0;
        }// Note: This if statement is for the second "Pass" which is equivalent
        // to the endgame

        if (e.getSource() == jbReset) {
            clearScratchBoardAndGui();
            jbReset.setEnabled(false);
            jbPass.setEnabled(true);
            jbResign.setEnabled(true);
            for (int x = 0; x < 19; x++) {
                for (int y = 0; y < 19; y++) {
                    gameBoard.arrayButtons[x][y].setEnabled(true);
                }
            }
        }
    }

    /**
     * Transfers the scratch board into the visible matrix on the GUI
     * @param board 
     */
    public static void toGUI(GoBoard board) {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (GoBoard.byGoBoard[x][y] == 0) {
                    gameBoard.arrayButtons[x][y].setBackground(Color.yellow);
                } else if (GoBoard.byGoBoard[x][y] == 1) {
                    gameBoard.arrayButtons[x][y].setBackground(Color.black);
                } else {
                    gameBoard.arrayButtons[x][y].setBackground(Color.white);
                }
            }
        }
    }

    /**
     * AI Move method
     */
    private void AIMove() {
        StackQueueList AtkList = new StackQueueList();//Linked list for the liberties to invade
        StackQueueList RandList = new StackQueueList();//Linked list for the legal moves which are not attacking a stone or group liberties
        ListNode c;
        boolean boolAdjacent = false;
        if ((BScore + gbScratchBoard.count((byte) 1) - WScore - gbScratchBoard.count((byte) 2)) > 70) {
            JOptionPane.showMessageDialog(null, "The AI Resigned");
            jbReset.setEnabled(true);
            jbPass.setEnabled(false);
            jbResign.setEnabled(false);
            for (int x = 0; x < 19; x++) {
                for (int y = 0; y < 19; y++) {
                    gameBoard.arrayButtons[x][y].setEnabled(false);
                }
            }
            WScore = BScore = 0;
            return;
        }//Surrenders when game is not winnable by the AI
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (analyze(x, y) && gbScratchBoard.byGoBoard[x][y] == 0) {
                    try {
                        boolAdjacent = gbScratchBoard.byGoBoard[x - 1][y] == 1;
                    } catch (Exception e) {
                    }

                    try {
                        boolAdjacent = gbScratchBoard.byGoBoard[x + 1][y] == 1 || boolAdjacent;

                    } catch (Exception E) {
                    }

                    try {
                        boolAdjacent = gbScratchBoard.byGoBoard[x][y - 1] == 1 || boolAdjacent;

                    } catch (Exception E) {
                    }

                    try {
                        boolAdjacent = gbScratchBoard.byGoBoard[x][y + 1] == 1 || boolAdjacent;

                    } catch (Exception E) {
                    }
                    if (analyze(x, y) && gbScratchBoard.byGoBoard[x][y] == 0 || boolAdjacent) {
                        if (boolAdjacent) {
                            AtkList.add(x, y);
                        } else {
                            RandList.add(x, y);
                        }
                    }
                    boolAdjacent=false;

                }
            }
        }
        Random num = new Random();//Random number generation
        if ((AtkList.length() == 0 && RandList.length() == 0)) {
            JOptionPane.showMessageDialog(null, "The AI Passed");
            if (boolPassed) {
                JOptionPane.showMessageDialog(
                        null,
                        "Number of Black Pieces:" + gbScratchBoard.count((byte) 1)
                        + "\nNumber of White Pieces:"
                        + gbScratchBoard.count((byte) 2)
                        + "\nNumber of White Pieces Captured:" + BScore
                        + "\nNumber of Black Pieces Captured:" + WScore);
                jbReset.setEnabled(true);
                for(int x=0;x<19;x++){
                    for(int y=0;y<19;y++){
                        gameBoard.arrayButtons[x][y].setEnabled(false);
                        
                    }
                }
                jbResign.setEnabled(false);
                jbPass.setEnabled(false);
                WScore = BScore = 0;
            }
        }//When there are no legal moves anymore
        c = AtkList.length() > 0 ? AtkList.traverse(num.nextInt(AtkList.length())) : RandList.traverse(num.nextInt(RandList.length()));//Select wut LL to use
        for (; CheckMove(c.x, c.y);) {//Loop for move selection
            AtkList.delete(c.x, c.y);//Removes if move is illegal
            RandList.delete(c.x, c.y);//Same here bro
            c = AtkList.isEmpty() ? AtkList.traverse(num.nextInt(AtkList.length())) : RandList.traverse(num.nextInt(RandList.length()));//Uses for the selection of Random Cell
        }
    }
/**
 * Determines if the move is legal or not, false if legal and true if not to repeat for loop without not Operator
 * @param x x-coordinate
 * @param y y-coordinate
 * @return <code>true</code> if there is a deficiency, else <code>false</code>
 */
    private static boolean CheckMove(int x, int y) {
        if (gbScratchBoard.byGoBoard[x][y] != (byte) 0) {
            return true;
        }//When there is piece, though its impossible
        else {
            GoBoard.byGoBoard[x][y] = 2;
        }
        if (GoBoard.checkLiberties(x, y, new StackQueueList(), (byte) 2)) {
            WScore += gbScratchBoard.checkCaptures((byte) 1);
            gbScratchBoard.capture((byte) 1);
            boolKo = false;
            boolPassed = false;
            return false;
        }// This denotes that the pass is not consecutive, plus move is legal since it has liberties
        else if (gbScratchBoard.checkCaptures((byte) 1) == 0) {
            gbScratchBoard.toScratchBoard(gameBoard);
            return true;
        }//When Suicide
        else if (boolKo && gbScratchBoard.checkCaptures((byte) 1) == 1
                && !gbScratchBoard.checkLiberties(xk, yk, new StackQueueList(), (byte) 1)) {
            gbScratchBoard.toScratchBoard(gameBoard);
            return true;
        }//When Ko
        else {
            boolKo = gbScratchBoard.checkCaptures((byte) 2) == 1;
            WScore += gbScratchBoard.checkCaptures((byte) 1);
            gbScratchBoard.capture((byte) 1);
            xk = x;
            yk = y;
            boolPassed = false;
            return false;
        }//SnapBack and potential ko check
    }

    /**
     * Determines if AIMove is feasible to play
     * @param x x-coordinate
     * @param y y-coordinate
     * @return <code>true</code> if feasible, else <code>false</code>
     */
    private static boolean analyze(int x, int y) {
        gbScratchBoard.byGoBoard[x][y] = 2;
        if ((gbScratchBoard.checkLiberties(x, y, new StackQueueList(), (byte) 2) || gbScratchBoard.checkCaptures((byte) 1) != 0)) {
            gbScratchBoard.toScratchBoard(gameBoard);
            return true;
        }
        gbScratchBoard.toScratchBoard(gameBoard);
        return false;
    }
    /**
     * The method to clear the scratchBoard, and incidentally the GUI as well
     */
    private void clearScratchBoardAndGui() {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                gbScratchBoard.byGoBoard[x][y] = 0;
            }
        }
        toGUI(gbScratchBoard);
    }
}
