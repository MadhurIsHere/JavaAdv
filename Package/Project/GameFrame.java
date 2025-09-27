package Project;

// File: GameFrame.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameFrame extends JFrame {
    private Board board;
    private JLabel statusLabel;
    private JButton resetBtn;

    public GameFrame() {
        setTitle("Tic Tac Toe");
        setSize(400, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Status label at top
        statusLabel = new JLabel("Player X's Turn", SwingConstants.CENTER);
        statusLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(statusLabel, BorderLayout.NORTH);

        // Board in center
        board = new Board(this);
        add(board, BorderLayout.CENTER);

        // Reset button at bottom
        resetBtn = new JButton("Reset Game");
        resetBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        add(resetBtn, BorderLayout.SOUTH);

        // Reset button listener
        resetBtn.addActionListener(e -> resetGame());

        setVisible(true);
    }

    public void setStatus(String text) {
        statusLabel.setText(text);
    }

    public void resetGame() {
        board.resetBoard();
        setStatus("Player X's Turn");
    }
}
