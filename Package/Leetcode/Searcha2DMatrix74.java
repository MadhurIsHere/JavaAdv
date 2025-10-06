package Leetcode;

public class Searcha2DMatrix74 {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][] {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        },60));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int rowStart=0;
        int rowLast=matrix.length-1;
        int rowMid;
        while (rowStart<=rowLast)
        {
            rowMid=rowStart+(rowLast-rowStart)/2;
            int colStart=0;
            int colLast=matrix[0].length-1;
            int colMid;
            while (colStart<=colLast)
            {
                colMid=colStart+(colLast-colStart)/2;
                if(matrix[rowMid][colMid]==target)
                    return true;
                if(matrix[rowMid][colMid]<target)
                {
                    rowStart=rowMid+1;
                    colStart=colMid+1;
                }
                else {
                    rowLast=rowMid-1;
                    colLast=colMid-1;
                }
            }

        }
        return false;
    }
}
