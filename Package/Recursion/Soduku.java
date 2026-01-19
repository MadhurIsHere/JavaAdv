package Recursion;

public class Soduku {
    public static void main(String[] args) {
        int[][] board={
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };
        solveSudoku(board);
        display(board);
    }
    public static boolean solveSudoku(int[][] board) {
        int n=board.length;
        int row=-1;
        int col=-1;
        boolean flag=true;

        // to check which one is empty
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==0)
                {
                    row=i;
                    col=j;
                    flag=false;
                    break;
                }
            }
            if(!flag)
            {
                break;
            }
        }
        if(flag)
        {
            return true;
        }

        //backtrack
        for(int number=1;number<=n;number++)
        {
            if(isSafe(board,row,col,number))
            {
                board[row][col]=number;
                if(solveSudoku(board))
                {
                    return true;
                }
                else {
                    board[row][col]=0;
                }
            }
        }
        return false;
    }
    public static boolean isSafe(int[][] board,int row,int col,int num)
    {
        int n= board.length;
        // row
        for(int i=0;i<n;i++)
        {
            if(num==board[row][i]){
                return false;
            }
        }

        // col
        for(int i=0;i<n;i++)
        {
            if(board[i][col]==num)
            {
                return false;
            }
        }

        // square box
        int sqrt=(int)Math.sqrt(n);
        int rowStart=row-row%sqrt;
        int colStart=col-col%sqrt;
        for(int i=rowStart;i<rowStart+sqrt;i++)
        {
            for(int j=colStart;j<colStart+sqrt;j++)
            {
                if(board[i][j]==num)
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void display(int[][]board)
    {
        for(int[] row:board)
        {
            for(int elem:row)
            {
                System.out.print(elem+" ");
            }
            System.out.println();
        }
    }

}
