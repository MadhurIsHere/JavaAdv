package Leetcode;

public class FindClosestPerson3516 {
    public static void main(String[] args) {
        System.out.println(findClosest(2,2,1));
    }
    public static int findClosest(int x, int y, int z) {
        int a=z-x;
        int b=z-y;
        if(Math.abs(a)>Math.abs(b))
        {
            return 2;
        }
        else if(Math.abs(a)<Math.abs(b))
        {
            return 1;
        }
        else return 0;
    }
}
