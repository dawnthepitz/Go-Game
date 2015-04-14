package gogame.board;

import gogame.algo.GoBoard;
import gogame.algo.StackQueueList;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Michail & Josh
 */
public class GameBoardGUI extends javax.swing.JFrame implements ActionListener {

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
    public static boolean boolTurnState=true;
    public GameBoardGUI() {
        initComponents();
        lblTurnState.setText(boolTurnState?"Black Move":"White Move");
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                jpGameBoard.add(gameBoard.arrayButtons[x][y]);
                gameBoard.arrayButtons[x][y].setBackground(Color.yellow);
                gameBoard.arrayButtons[x][y].setBorderPainted(false);
                gameBoard.arrayButtons[x][y].addActionListener(this);
            }
        }
        this.setTitle("Game of Go");
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
        lblBlack = new javax.swing.JLabel();
        lblWhite = new javax.swing.JLabel();
        blackPieces = new javax.swing.JLabel();
        blackCaptures = new javax.swing.JLabel();
        whitePieces = new javax.swing.JLabel();
        whiteCaptures = new javax.swing.JLabel();
        blackScore = new javax.swing.JLabel();
        whiteScore = new javax.swing.JLabel();
        lblTurnState = new javax.swing.JLabel();
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

        lblBlack.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblBlack.setText("Black Score:");

        lblWhite.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblWhite.setText("White Score:");

        blackPieces.setText("Live Pieces: 0 ");

        blackCaptures.setText("Captures: 0");

        whitePieces.setText("Live Pieces: 0");

        whiteCaptures.setText("Captures: 0");

        blackScore.setText("Total Score: 0");

        whiteScore.setText("Total Score: 0");

        lblTurnState.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTurnState.setText("Game State");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTurnState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbReset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbResign, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbPass, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblBlack, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblWhite, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(blackPieces)
                            .addComponent(blackCaptures)
                            .addComponent(whitePieces)
                            .addComponent(whiteCaptures)
                            .addComponent(blackScore)
                            .addComponent(whiteScore))
                        .addGap(0, 0, Short.MAX_VALUE)))
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
                .addGap(26, 26, 26)
                .addComponent(lblBlack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(blackPieces)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blackCaptures)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(blackScore)
                .addGap(41, 41, 41)
                .addComponent(lblWhite)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(whitePieces)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(whiteCaptures)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(whiteScore)
                .addGap(79, 79, 79)
                .addComponent(lblTurnState, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jpGameBoardLabelsLayout = new javax.swing.GroupLayout(jpGameBoardLabels);
        jpGameBoardLabels.setLayout(jpGameBoardLabelsLayout);
        jpGameBoardLabelsLayout.setHorizontalGroup(
            jpGameBoardLabelsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpGameBoardLabelsLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jpGameBoard, javax.swing.GroupLayout.DEFAULT_SIZE, 711, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                    .addComponent(jpGameBoard, javax.swing.GroupLayout.PREFERRED_SIZE, 701, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
    private javax.swing.JLabel blackCaptures;
    private javax.swing.JLabel blackPieces;
    private javax.swing.JLabel blackScore;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbPass;
    private javax.swing.JButton jbReset;
    private javax.swing.JButton jbResign;
    private javax.swing.JLabel jlBackGround;
    private javax.swing.JPanel jpGameBoard;
    private javax.swing.JPanel jpGameBoardLabels;
    private javax.swing.JLabel lblBlack;
    private javax.swing.JLabel lblTurnState;
    private javax.swing.JLabel lblWhite;
    private javax.swing.JLabel whiteCaptures;
    private javax.swing.JLabel whitePieces;
    private javax.swing.JLabel whiteScore;
    // End of variables declaration//GEN-END:variables

    /**
     * Whenever a button is pressed, traces what button is pressed and executes
     * code block accordingly
     * @param e ActionEvent involved
     */
        public void actionPerformed(ActionEvent e) {
        //Resign Button action
        if (e.getSource() == jbResign) {
            if(boolTurnState){
                JOptionPane.showMessageDialog(null,
                        "White won via Resignation");
            }
            else{
                JOptionPane.showMessageDialog(null,
                        "Black won via Resignation");
            }
            jbReset.setEnabled(true);
            jbPass.setEnabled(false);
            jbResign.setEnabled(false);
            for (int x = 0; x < 19; x++) {
                for (int y = 0; y < 19; y++) {
                    gameBoard.arrayButtons[x][y].setEnabled(false);
                }
            }
            WScore = BScore = 0;
            lblTurnState.setText("Game Over");
            return;
        }

        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (e.getSource() == gameBoard.arrayButtons[x][y]&&boolTurnState) {
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
                        this.blackCaptures.setText("Captures: "+BScore);
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
                        this.blackCaptures.setText("Captures: "+BScore);
                        gbScratchBoard.capture((byte) 2);
                        xk = x;
                        yk = y;
                        boolPassed = false;
                    }
                }
                else if(e.getSource() == gameBoard.arrayButtons[x][y]){
                    if(gbScratchBoard.byGoBoard[x][y]!=(byte)0){
                        JOptionPane.showMessageDialog(null,"There is already a piece there");
                        return;
                    }
                    else GoBoard.byGoBoard[x][y]=2;
                    if(GoBoard.checkLiberties(x,y,new StackQueueList(),(byte)2)){
                        WScore+=gbScratchBoard.checkCaptures((byte)1);
                        this.whiteCaptures.setText("Captures: "+WScore);
                        gbScratchBoard.capture((byte)1);
                        boolPassed=false;
                        boolKo=false;
                    }// This denotes that the pass is not consecutive
                    else if(gbScratchBoard.checkCaptures((byte)1)==0){
                        JOptionPane.showMessageDialog(null,"Illegal move due to Suicide");
                        gbScratchBoard.toScratchBoard(gameBoard);
                        return;
                    }
                    else if(boolKo&&gbScratchBoard.checkCaptures((byte)1)==1&&!gbScratchBoard.checkLiberties(xk,yk,new StackQueueList(),(byte)1)){
                        JOptionPane.showMessageDialog(null,"Illegal move due to Board Repetition");
                        gbScratchBoard.toScratchBoard(gameBoard);
                        return;
                    }
                    else{
                        boolKo=gbScratchBoard.checkCaptures((byte)2)==1;
                        WScore+=gbScratchBoard.checkCaptures((byte)1);
                        this.whiteCaptures.setText("Captures: "+WScore);
                        gbScratchBoard.capture((byte)1);
                        xk=x;
                        yk=y;
                        boolPassed=false;
                    }
                }
                this.blackPieces.setText("Total Pieces: "+gbScratchBoard.count((byte)1));
                this.blackScore.setText("Total Score:"+(BScore+gbScratchBoard.count((byte)1)));
                this.whitePieces.setText("Total Pieces: "+gbScratchBoard.count((byte)2));
                this.whiteScore.setText("Total Score:"+(WScore+gbScratchBoard.count((byte)2)));
            }
        }
        toGUI(gbScratchBoard);//Move of Player is ok
        // Pass Button
        if (e.getSource() == jbPass && boolPassed == false) {
            boolPassed = true;
            boolTurnState=!boolTurnState;
            lblTurnState.setText(boolTurnState?"Black Move":"White Move");
            return;
        }// Note: This if statement is for the first "Pass"
        else if (e.getSource() == jbPass) {
            JOptionPane.showMessageDialog(
                    null,
                    "Number of Black Pieces:" + gbScratchBoard.count((byte) 1)
                    + "\nNumber of White Pieces:"
                    + gbScratchBoard.count((byte) 2)
                    + "\nNumber of White Pieces Captured:" + BScore
                    + "\nNumber of Black Pieces Captured:" + WScore
                    + "\n"+winner());
            jbReset.setEnabled(true);
            jbPass.setEnabled(false);
            jbResign.setEnabled(false);
            for (int x = 0; x < 19; x++) {
                for (int y = 0; y < 19; y++) {
                    gameBoard.arrayButtons[x][y].setEnabled(false);
                }
            }
            lblTurnState.setText("Game Over");
            WScore = BScore = 0;
            return;
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
            lblTurnState.setText(boolTurnState?"Black Move":"White Move");
            this.blackCaptures.setText("Captures: "+0);
            this.blackPieces.setText("Live Pieces: "+0);
            this.blackScore.setText("Total Score: "+0);
            this.whiteCaptures.setText("Captures: "+0);
            this.whitePieces.setText("Live Pieces: "+0);
            this.whiteScore.setText("Total Score: "+0);
            return;
        }
        boolTurnState=!boolTurnState;
        lblTurnState.setText(boolTurnState?"Black Move":"White Move");
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
    private void clearScratchBoardAndGui() {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                gbScratchBoard.byGoBoard[x][y] = 0;
            }
        }
        toGUI(gbScratchBoard);
        boolTurnState=true;
    }
    private String winner(){
        if(BScore+gbScratchBoard.count((byte)1)>WScore+gbScratchBoard.count((byte)2)){
            return "Black won via "+(BScore+gbScratchBoard.count((byte)1)-(WScore+gbScratchBoard.count((byte)2)))+" points";
        }
        else if(BScore+gbScratchBoard.count((byte)1)<WScore+gbScratchBoard.count((byte)2)){
            return "White won via "+(WScore+gbScratchBoard.count((byte)2)-(BScore+gbScratchBoard.count((byte)1)))+" points";
        }
        return "Tie";
    }
}
