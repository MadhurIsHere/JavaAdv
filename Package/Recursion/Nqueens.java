package Recursion;

import java.util.ArrayList;
import java.util.List;
public class Nqueens {
    public static void main(String[] args) {
        boolean[][] board = new boolean[6][6];
        System.out.println(queen(board, 0));
    }

    public static List<List<String>> queen(boolean[][] board, int row) {
        if (row == board.length) {
            ArrayList<List<String>> list = new ArrayList<>();
            list.add(display(board));
            return list;
        }
        ArrayList<List<String>> list = new ArrayList<>();
        for (int col = 0; col < board.length; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = true;
                list.addAll(queen(board, row + 1));
                board[row][col] = false;
            }
        }
        return list;
    }

    private static boolean isSafe(boolean[][] b, int row, int col) {
        // vertical rows
        for (int i = 0; i < row; i++) {
            if (b[i][col]) {
                return false;
            }
        }

        // left diagonal
        int left = Math.min(row, col);
        for (int i = 1; i <= left; i++) {
            if (b[row - i][col - i]) {
                return false;
            }
        }

        // right diagonal
        int right = Math.min(row, b.length - col - 1);
        for (int i = 1; i <= right; i++) {
            if (b[row - i][col + i]) {
                return false;
            }
        }
        return true;
    }

    private static List<String> display(boolean[][] board) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            StringBuilder ans = new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j]) {
                    ans.append("Q");
                } else {
                    ans.append(".");
                }
            }
            list.add(ans.toString());
        }
        return list;
    }
}
