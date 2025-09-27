package Project;

// File: Board.java
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {
    private JButton[][] buttons;
    private char[][] boardState;
    private char currentPlayer;
    private GameFrame parent;

    public Board(GameFrame parent) {
        this.parent = parent;
        this.currentPlayer = 'X';

        setLayout(new GridLayout(3, 3));
        buttons = new JButton[3][3];
        boardState = new char[3][3];

        // Initialize buttons + add listeners
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = new JButton("");
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 40));
                buttons[i][j].setFocusPainted(false);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
                boardState[i][j] = '-';
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clicked = (JButton) e.getSource();

        // Find button position
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j] == clicked && boardState[i][j] == '-') {
                    boardState[i][j] = currentPlayer;
                    buttons[i][j].setText(String.valueOf(currentPlayer));

                    if (checkWinner()) {
                        parent.setStatus("Player " + currentPlayer + " Wins!");
                        disableBoard();
                        return;
                    } else if (isDraw()) {
                        parent.setStatus("Draw!");
                        return;
                    }

                    switchPlayer();
                    return;
                }
            }
        }
    }

    private boolean checkWinner() {
        // Rows + Columns
        for (int i = 0; i < 3; i++) {
            if (boardState[i][0] == currentPlayer &&
                    boardState[i][1] == currentPlayer &&
                    boardState[i][2] == currentPlayer) return true;

            if (boardState[0][i] == currentPlayer &&
                    boardState[1][i] == currentPlayer &&
                    boardState[2][i] == currentPlayer) return true;
        }

        // Diagonals
        if (boardState[0][0] == currentPlayer &&
                boardState[1][1] == currentPlayer &&
                boardState[2][2] == currentPlayer) return true;

        if (boardState[0][2] == currentPlayer &&
                boardState[1][1] == currentPlayer &&
                boardState[2][0] == currentPlayer) return true;

        return false;
    }

    private boolean isDraw() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (boardState[i][j] == '-') return false;
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        parent.setStatus("Player " + currentPlayer + "'s Turn");
    }

    private void disableBoard() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                buttons[i][j].setEnabled(false);
    }

    public void resetBoard() {
        currentPlayer = 'X';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardState[i][j] = '-';
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }
    }
}

