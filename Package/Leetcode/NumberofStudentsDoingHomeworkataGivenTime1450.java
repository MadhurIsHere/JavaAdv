package Leetcode;

public class NumberofStudentsDoingHomeworkataGivenTime1450 {
    public static void main(String[] args) {
        System.out.println(busyStudent(new int[]{1,2,3},new int[] {3,2,7},4));
    }
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int count =0;
        for(int i=0;i<startTime.length;i++)
        {
            if(startTime[i]<=queryTime && queryTime<=endTime[i])
            {
                count++;
            }
        }
        return count;
    }
}
