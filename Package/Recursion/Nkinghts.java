package Recursion;

public class Nkinghts {
    public static void main(String[] args) {
        boolean[][] board = new boolean[4][4];
        knight(board, 0, 0, 8);
    }

    private static void knight(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            System.out.println();
            return;
        }
        if (row == board.length - 1 && col == board.length) {
            return;
        }
        if (col == board.length) {
            col = 0;
            row += 1;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knight(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }
        knight(board, row, col + 1, knights);
    }

    private static boolean isSafe(boolean[][] b, int row, int col) {
        if (isValid(b, row, col)) {
            if (b[row][col]) {
                return false;
            }
        }
        if (isValid(b, row - 2, col + 1)) {
            if (b[row - 2][col + 1]) {
                return false;
            }
        }
        if (isValid(b, row - 2, col - 1)) {
            if (b[row - 2][col - 1]) {
                return false;
            }
        }
        if (isValid(b, row - 1, col + 2)) {
            if (b[row - 1][col + 2]) {
                return false;
            }
        }
        if (isValid(b, row - 1, col - 2)) {
            if (b[row - 1][col - 2]) {
                return false;
            }
        }
        return true;
    }

    private static boolean isValid(boolean[][] b, int row, int col) {
        if (row >= 0 && row < b.length && col >= 0 && col < b.length) {
            return true;
        }
        return false;
    }

    private static void display(boolean[][] b) {
        int n = b.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (b[i][j]) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
