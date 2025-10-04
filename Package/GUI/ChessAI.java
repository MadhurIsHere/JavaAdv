package GUI;


import javax.swing.*;
        import java.awt.*;
        import java.awt.event.*;
        import java.util.*;
        import java.util.List;

/**
 * ChessAI.java
 *
 * Single-file 2D Chess with a Minimax+Alpha-Beta AI.
 *
 * Compile:
 *   javac ChessAI.java
 * Run:
 *   java ChessAI
 *
 * Controls:
 *   - Click a piece to select, click a destination to move.
 *   - Use "AI Move" to have AI play the side to move.
 *   - Use "Depth" spinner to adjust AI search depth (2-6 recommended).
 *
 * Notes:
 *  - No castling or en-passant.
 *  - Pawn promotion -> Queen automatically.
 */
public class ChessAI extends JFrame {
    static final int TILE_SIZE = 80;
    static final int BOARD_SIZE = 8;
    Board board;
    ChessPanel chessPanel;
    JLabel statusLabel;
    JButton aiMoveBtn;
    JSpinner depthSpinner;

    public ChessAI() {
        setTitle("Chess (Minimax + Alpha-Beta)");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board = new Board();
        chessPanel = new ChessPanel(board);
        statusLabel = new JLabel("White to move");
        aiMoveBtn = new JButton("AI Move");
        depthSpinner = new JSpinner(new SpinnerNumberModel(3, 1, 6, 1));

        aiMoveBtn.addActionListener(e -> {
            int depth = (Integer) depthSpinner.getValue();
            Runnable r = () -> {
                setControlsEnabled(false);
                Move best = AI.findBestMove(board, depth);
                if (best != null) {
                    board.makeMove(best);
                    board.switchTurn();
                    updateStatus();
                }
                setControlsEnabled(true);
                chessPanel.repaint();
            };
            new Thread(r).start();
        });

        JPanel top = new JPanel();
        top.add(new JLabel("AI Depth:"));
        top.add(depthSpinner);
        top.add(aiMoveBtn);
        top.add(statusLabel);

        add(top, BorderLayout.NORTH);
        add(chessPanel, BorderLayout.CENTER);
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    void setControlsEnabled(boolean v) {
        aiMoveBtn.setEnabled(v);
        depthSpinner.setEnabled(v);
    }

    void updateStatus() {
        if (board.isCheckmate()) {
            statusLabel.setText((board.whiteToMove ? "White" : "Black") + " is checkmated. " + (board.whiteToMove ? "Black" : "White") + " wins.");
        } else if (board.isStalemate()) {
            statusLabel.setText("Stalemate.");
        } else {
            statusLabel.setText((board.whiteToMove ? "White" : "Black") + " to move" + (board.inCheck(board.whiteToMove) ? " — CHECK!" : ""));
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ChessAI());
    }

    // --------------------------
    // ChessPanel: GUI and mouse handling
    // --------------------------
    class ChessPanel extends JPanel implements MouseListener {
        Board board;
        int selRow = -1, selCol = -1;
        List<Move> legalFromSelection = new ArrayList<>();

        public ChessPanel(Board board) {
            this.board = board;
            setPreferredSize(new Dimension(TILE_SIZE * BOARD_SIZE, TILE_SIZE * BOARD_SIZE));
            addMouseListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // draw board
            for (int r = 0; r < BOARD_SIZE; r++) {
                for (int c = 0; c < BOARD_SIZE; c++) {
                    boolean light = (r + c) % 2 == 0;
                    g.setColor(light ? new Color(240, 217, 181) : new Color(181, 136, 99));
                    g.fillRect(c * TILE_SIZE, r * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                }
            }
            // highlight possible moves
            g.setColor(new Color(0, 255, 0, 80));
            for (Move m : legalFromSelection) {
                g.fillOval(m.toCol * TILE_SIZE + TILE_SIZE / 3, m.toRow * TILE_SIZE + TILE_SIZE / 3, TILE_SIZE / 3, TILE_SIZE / 3);
            }
            // highlight selected
            if (selRow != -1) {
                g.setColor(new Color(255, 255, 0, 140));
                g.fillRect(selCol * TILE_SIZE, selRow * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }
            // draw pieces (simple text)
            for (int r = 0; r < BOARD_SIZE; r++) {
                for (int c = 0; c < BOARD_SIZE; c++) {
                    int p = board.pieceAt(r, c);
                    if (p != Board.EMPTY) {
                        drawPiece(g, p, c * TILE_SIZE, r * TILE_SIZE);
                    }
                }
            }
        }

        void drawPiece(Graphics g, int piece, int x, int y) {
            String s = Board.pieceToChar(piece);
            g.setFont(new Font("SansSerif", Font.BOLD, 36));
            boolean white = Board.isWhite(piece);
            g.setColor(white ? Color.WHITE : Color.BLACK);
            // drop shadow
            g.setColor(new Color(0, 0, 0, 180));
            g.drawString(s, x + 17 + 1, y + 50 + 1);
            g.setColor(white ? Color.WHITE : Color.BLACK);
            g.drawString(s, x + 17, y + 50);
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            int col = e.getX() / TILE_SIZE;
            int row = e.getY() / TILE_SIZE;
            if (row < 0 || row >= BOARD_SIZE || col < 0 || col >= BOARD_SIZE) return;

            int clickedPiece = board.pieceAt(row, col);
            if (selRow == -1) {
                // select if piece of color to move
                if (clickedPiece != Board.EMPTY && Board.isWhite(clickedPiece) == board.whiteToMove) {
                    selRow = row; selCol = col;
                    legalFromSelection = board.generateLegalMovesFor(selRow, selCol);
                }
            } else {
                // attempt move
                Move chosen = null;
                for (Move m : legalFromSelection) {
                    if (m.toRow == row && m.toCol == col) {
                        chosen = m; break;
                    }
                }
                if (chosen != null) {
                    board.makeMove(chosen);
                    board.switchTurn();
                    updateStatus();
                } else {
                    // reselect if clicking another of player's pieces
                    if (clickedPiece != Board.EMPTY && Board.isWhite(clickedPiece) == board.whiteToMove) {
                        selRow = row; selCol = col;
                        legalFromSelection = board.generateLegalMovesFor(selRow, selCol);
                        repaint();
                        return;
                    } else {
                        // deselect
                        selRow = -1; selCol = -1; legalFromSelection.clear();
                    }
                }
                selRow = -1; selCol = -1; legalFromSelection.clear();
            }
            repaint();
        }
        // unused:
        public void mousePressed(MouseEvent e) {}
        public void mouseReleased(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    // --------------------------
    // Board representation & move generation
    // --------------------------
    static class Board {
        static final int EMPTY = 0;
        // pieces
        static final int wP=1, wN=2, wB=3, wR=4, wQ=5, wK=6;
        static final int bP= -1, bN=-2, bB=-3, bR=-4, bQ=-5, bK=-6;

        int[][] board; // [row][col], row 0 is top (black's back rank)
        boolean whiteToMove = true;
        // Keep last move? (not used)
        Board() {
            board = new int[8][8];
            setupStart();
        }

        void setupStart() {
            // black back rank
            board[0] = new int[]{bR,bN,bB,bQ,bK,bB,bN,bR};
            board[1] = new int[]{bP,bP,bP,bP,bP,bP,bP,bP};
            for (int r=2;r<6;r++) Arrays.fill(board[r], EMPTY);
            board[6] = new int[]{wP,wP,wP,wP,wP,wP,wP,wP};
            board[7] = new int[]{wR,wN,wB,wQ,wK,wB,wN,wR};
            whiteToMove = true;
        }

        int pieceAt(int r, int c) {
            return board[r][c];
        }

        static boolean isWhite(int p) { return p>0; }
        static boolean isBlack(int p) { return p<0; }

        static String pieceToChar(int p) {
            if (p == wP) return "♙";
            if (p == wN) return "♘";
            if (p == wB) return "♗";
            if (p == wR) return "♖";
            if (p == wQ) return "♕";
            if (p == wK) return "♔";
            if (p == bP) return "♟";
            if (p == bN) return "♞";
            if (p == bB) return "♝";
            if (p == bR) return "♜";
            if (p == bQ) return "♛";
            if (p == bK) return "♚";
            return "?";
        }

        List<Move> generateAllLegalMoves() {
            List<Move> moves = new ArrayList<>();
            for (int r=0;r<8;r++) for (int c=0;c<8;c++) {
                int p = board[r][c];
                if (p == EMPTY) continue;
                if (whiteToMove && p>0) moves.addAll(generateLegalMovesFor(r,c));
                if (!whiteToMove && p<0) moves.addAll(generateLegalMovesFor(r,c));
            }
            return moves;
        }

        List<Move> generateLegalMovesFor(int r, int c) {
            int p = board[r][c];
            if (p == EMPTY) return Collections.emptyList();
            List<Move> raw = generatePseudoLegalMovesFor(r, c);
            List<Move> legal = new ArrayList<>();
            // filter out moves that leave own king in check
            for (Move m : raw) {
                Board copy = this.copy();
                copy.makeMove(m);
                // if move causes own king to be in check, illegal
                boolean kingInCheck = copy.inCheck( (Board.isWhite(p)) );
                if (!kingInCheck) legal.add(m);
            }
            return legal;
        }

        List<Move> generatePseudoLegalMovesFor(int r, int c) {
            int p = board[r][c];
            List<Move> moves = new ArrayList<>();
            if (p == EMPTY) return moves;
            boolean white = p>0;
            int dir = white ? -1 : 1; // pawn forward direction (white moves up in array)
            int absP = Math.abs(p);

            if (absP == 1) { // pawn
                int nr = r + dir;
                if (inBounds(nr,c) && board[nr][c] == EMPTY) {
                    // single forward
                    moves.add(new Move(r,c,nr,c,false));
                    // promotion check handled on makeMove
                    // double
                    if ((white && r==6) || (!white && r==1)) {
                        int br = r + 2*dir;
                        if (board[br][c]==EMPTY) moves.add(new Move(r,c,br,c,false));
                    }
                }
                // captures
                for (int dc : new int[]{-1,1}) {
                    int nc = c + dc;
                    if (inBounds(nr,nc) && board[nr][nc]!=EMPTY && Board.isWhite(board[nr][nc])!=white) {
                        moves.add(new Move(r,c,nr,nc,true));
                    }
                }
            } else if (absP == 2) { // knight
                int[] dr = {-2,-2,-1,-1,1,1,2,2};
                int[] dc = {-1,1,-2,2,-2,2,-1,1};
                for (int i=0;i<8;i++) {
                    int nr = r+dr[i], nc = c+dc[i];
                    if (!inBounds(nr,nc)) continue;
                    if (board[nr][nc]==EMPTY || Board.isWhite(board[nr][nc])!=white)
                        moves.add(new Move(r,c,nr,nc, board[nr][nc]!=EMPTY));
                }
            } else if (absP == 3 || absP == 5) { // bishop or queen (diagonals)
                int[] dr = {-1,-1,1,1};
                int[] dc = {-1,1,-1,1};
                for (int i=0;i<4;i++) {
                    int nr=r+dr[i], nc=c+dc[i];
                    while (inBounds(nr,nc)) {
                        if (board[nr][nc]==EMPTY) {
                            moves.add(new Move(r,c,nr,nc,false));
                        } else {
                            if (Board.isWhite(board[nr][nc])!=white) moves.add(new Move(r,c,nr,nc,true));
                            break;
                        }
                        nr += dr[i]; nc += dc[i];
                    }
                }
                if (absP==3) { /*bishop only*/ }
                // queen handled here too
            }
            if (absP == 4 || absP == 5) { // rook or queen (orthogonals)
                int[] dr = {-1,1,0,0};
                int[] dc = {0,0,-1,1};
                for (int i=0;i<4;i++) {
                    int nr=r+dr[i], nc=c+dc[i];
                    while (inBounds(nr,nc)) {
                        if (board[nr][nc]==EMPTY) {
                            moves.add(new Move(r,c,nr,nc,false));
                        } else {
                            if (Board.isWhite(board[nr][nc])!=white) moves.add(new Move(r,c,nr,nc,true));
                            break;
                        }
                        nr += dr[i]; nc += dc[i];
                    }
                }
            }
            if (absP == 6) { // king
                for (int dr=-1; dr<=1; dr++) for (int dc=-1; dc<=1; dc++) {
                    if (dr==0 && dc==0) continue;
                    int nr = r+dr, nc = c+dc;
                    if (!inBounds(nr,nc)) continue;
                    if (board[nr][nc]==EMPTY || Board.isWhite(board[nr][nc])!=white)
                        moves.add(new Move(r,c,nr,nc, board[nr][nc]!=EMPTY));
                }
            }
            return moves;
        }

        boolean inBounds(int r, int c) { return r>=0 && r<8 && c>=0 && c<8; }

        Board copy() {
            Board b = new Board();
            for (int r=0;r<8;r++) b.board[r] = Arrays.copyOf(this.board[r], 8);
            b.whiteToMove = this.whiteToMove;
            return b;
        }

        void makeMove(Move m) {
            int p = board[m.fromRow][m.fromCol];
            board[m.toRow][m.toCol] = p;
            board[m.fromRow][m.fromCol] = EMPTY;
            // pawn promotion
            if (Math.abs(p) == 1) {
                if ((p>0 && m.toRow==0) || (p<0 && m.toRow==7)) {
                    board[m.toRow][m.toCol] = (p>0 ? wQ : bQ); // promote to queen
                }
            }
        }

        void switchTurn() { whiteToMove = !whiteToMove; }

        // check detection: is color 'white' in check?
        boolean inCheck(boolean white) {
            // find king
            int king = white? wK : bK;
            int kr=-1,kc=-1;
            for (int r=0;r<8;r++) for (int c=0;c<8;c++) if (board[r][c]==king) { kr=r; kc=c; }
            if (kr==-1) return true; // no king found (shouldn't happen)
            // generate opponent pseudo-legal moves and see if any attack king square
            boolean oppWhite = !white;
            for (int r=0;r<8;r++) for (int c=0;c<8;c++) {
                int p = board[r][c];
                if (p==EMPTY) continue;
                if (Board.isWhite(p) != oppWhite) continue;
                List<Move> movs = generatePseudoLegalMovesFor(r,c);
                for (Move m : movs) {
                    if (m.toRow==kr && m.toCol==kc) return true;
                }
            }
            return false;
        }

        boolean isCheckmate() {
            if (!inCheck(whiteToMove)) return false;
            List<Move> moves = generateAllLegalMoves();
            return moves.isEmpty();
        }

        boolean isStalemate() {
            if (inCheck(whiteToMove)) return false;
            List<Move> moves = generateAllLegalMoves();
            return moves.isEmpty();
        }

        // Simple material evaluation + tiny positional heuristics
        int evaluate() {
            int score = 0;
            for (int r=0;r<8;r++) for (int c=0;c<8;c++) {
                int p = board[r][c];
                if (p==EMPTY) continue;
                int val = pieceValue(Math.abs(p));
                if (p>0) score += val; else score -= val;
                // small pawn advancement bonus
                if (p==wP) score += (6 - r); // white pawns closer to 0 get bonus
                if (p==bP) score -= (r - 1); // black pawns closer to 7 get bonus negative for black
            }
            return score;
        }

        int pieceValue(int absP) {
            switch(absP) {
                case 1: return 100;
                case 2: return 320;
                case 3: return 330;
                case 4: return 500;
                case 5: return 900;
                case 6: return 20000;
            }
            return 0;
        }
    }

    // --------------------------
    // Move representation
    // --------------------------
    static class Move {
        int fromRow, fromCol, toRow, toCol;
        boolean capture;
        Move(int fr,int fc,int tr,int tc, boolean capture) {
            this.fromRow=fr; this.fromCol=fc; this.toRow=tr; this.toCol=tc; this.capture=capture;
        }
        public String toString() { return ""+fromRow+fromCol+"->"+toRow+toCol+(capture?"x":""); }
    }

    // --------------------------
    // AI: Minimax with alpha-beta
    // --------------------------
    static class AI {
        static Move findBestMove(Board board, int depth) {
            boolean maximizingWhite = board.whiteToMove;
            int alpha = Integer.MIN_VALUE/2, beta = Integer.MAX_VALUE/2;
            Move best = null;
            int bestScore = maximizingWhite ? Integer.MIN_VALUE/2 : Integer.MAX_VALUE/2;
            List<Move> moves = board.generateAllLegalMoves();
            // simple move ordering: captures first
            moves.sort((a,b) -> Boolean.compare(b.capture, a.capture));
            for (Move m : moves) {
                Board copy = board.copy();
                copy.makeMove(m);
                copy.switchTurn();
                int val = alphabeta(copy, depth-1, alpha, beta, !maximizingWhite);
                if (maximizingWhite) {
                    if (val > bestScore) { bestScore = val; best = m; alpha = Math.max(alpha, val); }
                } else {
                    if (val < bestScore) { bestScore = val; best = m; beta = Math.min(beta, val); }
                }
                // alpha-beta cutoff
                if (alpha >= beta) break;
            }
            return best;
        }

        static int alphabeta(Board board, int depth, int alpha, int beta, boolean maximizing) {
            if (depth==0) {
                return board.evaluate() * (board.whiteToMove ? 1 : 1); // evaluate from white perspective
            }
            if (board.isCheckmate()) {
                // if side to move is checkmated, bad for them
                return board.whiteToMove ? -100000 : 100000;
            }
            if (board.isStalemate()) return 0;
            List<Move> moves = board.generateAllLegalMoves();
            if (moves.isEmpty()) {
                // no legal moves
                return board.inCheck(board.whiteToMove) ? (board.whiteToMove ? -100000 : 100000) : 0;
            }
            // move ordering: captures first
            moves.sort((a,b) -> Boolean.compare(b.capture, a.capture));
            if (maximizing) {
                int value = Integer.MIN_VALUE/2;
                for (Move m : moves) {
                    Board copy = board.copy();
                    copy.makeMove(m);
                    copy.switchTurn();
                    int v = alphabeta(copy, depth-1, alpha, beta, false);
                    value = Math.max(value, v);
                    alpha = Math.max(alpha, value);
                    if (alpha >= beta) break;
                }
                return value;
            } else {
                int value = Integer.MAX_VALUE/2;
                for (Move m : moves) {
                    Board copy = board.copy();
                    copy.makeMove(m);
                    copy.switchTurn();
                    int v = alphabeta(copy, depth-1, alpha, beta, true);
                    value = Math.min(value, v);
                    beta = Math.min(beta, value);
                    if (alpha >= beta) break;
                }
                return value;
            }
        }
    }
}
