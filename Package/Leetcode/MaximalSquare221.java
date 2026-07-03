package Leetcode;

import java.util.Stack;

public class MaximalSquare221 {
    public static void main(String[] args) {
        System.out.println(maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        }));
    }

    public static int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int area = 0;
        int cols = matrix[0].length;
        int[] height = new int[cols];

        for (char[] row : matrix) {
            for (int c = 0; c < cols; c++) {
                if (row[c] == '1') {
                    height[c] += 1;
                } else {
                    height[c] = 0;
                }
            }
            area = Math.max(area, square(height));
        }
        return area;
    }

    private static int square(int[] height) {
        int area = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= height.length; i++) {
            int cur_height = i == height.length ? 0 : height[i];

            while (!stack.isEmpty() && cur_height < height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                int min = Math.min(h, w);
                area = Math.max(area, min * min);
            }
            stack.push(i);
        }
        return area;
    }
}
