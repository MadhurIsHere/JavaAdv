package Leetcode;

public class CalculateDelayedArrivalTime2651 {
    public static void main(String[] args) {
        System.out.println(findDelayedArrivalTime(19,100));
    }
    public static int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime+delayedTime)%24;
    }

}
