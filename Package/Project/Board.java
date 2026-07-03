package Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (buttons[i][j] == clicked && boardState[i][j] == '-') {

                    boardState[i][j] = 'X';
                    buttons[i][j].setText("X");

                    if (checkWinnerFor('X')) {
                        parent.setStatus("Player X Wins!");
                        disableBoard();
                        return;
                    }

                    if (isDraw()) {
                        parent.setStatus("Draw!");
                        return;
                    }

                    parent.setStatus("Computer Thinking...");
                    aiMove();

                    return;
                }
            }
        }
    }

    private void aiMove() {

        int bestScore = Integer.MIN_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (boardState[i][j] == '-') {

                    boardState[i][j] = 'O';

                    int score = minimax(false);

                    boardState[i][j] = '-';

                    if (score > bestScore) {
                        bestScore = score;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }

        boardState[bestRow][bestCol] = 'O';
        buttons[bestRow][bestCol].setText("O");

        if (checkWinnerFor('O')) {
            parent.setStatus("Computer Wins!");
            disableBoard();
            return;
        }

        if (isDraw()) {
            parent.setStatus("Draw!");
            return;
        }

        parent.setStatus("Player X's Turn");
    }

    private int minimax(boolean isMaximizing) {

        if (checkWinnerFor('O'))
            return 10;

        if (checkWinnerFor('X'))
            return -10;

        if (isDraw())
            return 0;

        if (isMaximizing) {

            int bestScore = Integer.MIN_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (boardState[i][j] == '-') {

                        boardState[i][j] = 'O';

                        int score = minimax(false);

                        boardState[i][j] = '-';

                        bestScore = Math.max(bestScore, score);
                    }
                }
            }

            return bestScore;

        } else {

            int bestScore = Integer.MAX_VALUE;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (boardState[i][j] == '-') {

                        boardState[i][j] = 'X';

                        int score = minimax(true);

                        boardState[i][j] = '-';

                        bestScore = Math.min(bestScore, score);
                    }
                }
            }

            return bestScore;
        }
    }

    private boolean checkWinnerFor(char player) {

        for (int i = 0; i < 3; i++) {

            if (boardState[i][0] == player &&
                    boardState[i][1] == player &&
                    boardState[i][2] == player)
                return true;

            if (boardState[0][i] == player &&
                    boardState[1][i] == player &&
                    boardState[2][i] == player)
                return true;
        }

        if (boardState[0][0] == player &&
                boardState[1][1] == player &&
                boardState[2][2] == player)
            return true;

        if (boardState[0][2] == player &&
                boardState[1][1] == player &&
                boardState[2][0] == player)
            return true;

        return false;
    }

    private boolean isDraw() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (boardState[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    private void disableBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                buttons[i][j].setEnabled(false);
            }
        }
    }

    public void resetBoard() {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                boardState[i][j] = '-';
                buttons[i][j].setText("");
                buttons[i][j].setEnabled(true);
            }
        }

        parent.setStatus("Player X's Turn");
    }
}