package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
//        System.out.println(maze(3,3));
//        System.out.println(maze("",3,3));

        boolean[][] maze={
                {true,false,true},
                {true,false,true},
                {true,true,true}
        };
        int[][] path=new int[maze.length][maze[0].length];
        printThepath("",0,0,maze,path,1);
//        System.out.println(mazeRiver("",0,0,maze));
//        System.out.println(backTrack("",0,0,maze)) ;
    }
    static int maze(int row,int col)
    {
        if(row==1 || col==1) {
            return 1;
        }
        int mid=0;
        if(row>1 && col>1)
        {
            mid=maze(row-1,col-1);
        }
        int left=maze(row-1,col);
        int right=maze(row,col-1);
        return left+right+mid;
    }

    static List<String> maze(String p, int row, int col)
    {
        if(row==1 && col==1)
        {
            List<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        List<String> list=new ArrayList<>();
        if(row>1 && col>1)
        {
            list.addAll(maze(p+"D",row-1,col-1));
        }
        if(row>1)
        {
            list.addAll(maze(p+'V',row-1,col));
        }
        if(col>1)
        {
            list.addAll(maze(p+"H",row,col-1));
        }
        return list;
    }

    static List<String> mazeRiver(String p,int row,int col,boolean[][]maze)
    {
        if(row==maze.length-1 && col== maze[0].length-1)
        {
            ArrayList<String>list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(!maze[row][col])
        {
            return list;
        }
        if(row<maze.length-1 && col<maze[0].length-1)
        {
            list.addAll(mazeRiver(p+"D",row+1,col+1,maze));
        }
        if(row<maze.length-1)
        {
            list.addAll(mazeRiver(p+"V",row+1,col,maze));
        }
        if(col<maze[0].length-1){
            list.addAll(mazeRiver(p+"H",row,col+1,maze));
        }
        return list;
    }

    // lets have all 5 ways of solving the maze and for the ease let all the points be true at the first so
    public static List<String> backTrack(String p,int r,int c,boolean[][] maze){
        int rl=maze.length;
        int cl=maze[0].length;
        if(r==rl-1 && c==cl-1)
        {
            ArrayList<String> list=new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> list=new ArrayList<>();
        if(!maze[r][c])
        {
            return list;
        }

        maze[r][c]=false;
        if(r<rl-1)
        {
            list.addAll(backTrack(p+"D",r+1,c,maze));
        }
        if(c<cl-1)
        {
            list.addAll(backTrack(p+"R",r,c+1,maze));
        }
        if(r>0)
        {
            list.addAll(backTrack(p+"U",r-1,c,maze));
        }
        if(c>0)
        {
            list.addAll(backTrack(p+"L",r,c-1,maze));
        }
        maze[r][c]=true;
        return list;
    }

    public static void printThepath(String p,int r,int c,boolean[][] maze, int[][] path,int step)
    {

        int rl=maze.length;
        int cl=maze[0].length;
        if(!maze[r][c])
        {
            return;
        }
        path[r][c]=step;
        if(r==rl-1 && c==cl-1){
            for(int i=0;i<rl;i++)
            {
                System.out.println(Arrays.toString(path[i]));
            }
            System.out.println(p);
            System.out.println();
            return;
        }
        maze[r][c] = false;
        if (r > 0) {
            printThepath(p + "U", r - 1, c, maze, path, step + 1);
        }
        if (r < rl - 1) {
            printThepath(p + "D", r + 1, c, maze, path, step + 1);
        }
        if (c > 0) {
            printThepath(p + "L", r, c - 1, maze, path, step + 1);
        }
        if (c < cl - 1) {
            printThepath(p + "R", r, c + 1, maze, path, step + 1);
        }
        path[r][c] = 0;
        maze[r][c] = true;

    }
}
