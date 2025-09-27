package Leetcode;

public class LargestTriangleArea812 {
    public static void main(String[] args) {
        System.out.println(largestTriangleArea(new int[][]{{0,0},{0,1},{1,0},{0,2},{2,0}}));
    }
    // 1/2 of mod of determinant
    public static double largestTriangleArea(int[][] points) {
        double ans=0;
        for(int i=0;i<points.length;i++)
        {
            for(int j=i+1;j<points.length;j++)
            {
                for(int k=j+1;k<points.length;k++)
                {
                    ans=Math.max(ans,area(points[i],points[j],points[k]));
                }
            }
        }
        return ans;
    }

    private static double area(int[] point, int[] point1, int[] point2) {
        return 0.5*Math.abs (point[0]*point1[1]+point1[0]*point2[1]+point2[0]*point[1]-point[1]*point1[0]-point1[1]*point2[0]-point2[1]*point[0]);
    }
}
