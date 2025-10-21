package Leetcode;

import java.util.Arrays;

public class MaximumMatchingofPlayersWithTrainers2410 {
    public static void main(String[] args) {
        System.out.println(matchPlayersAndTrainers(new int[]{1,1,1},new int[] {10}));
    }
    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int i=0,j=0;
        while (i<players.length && j<trainers.length)
        {
            if(players[i]<=trainers[j]) i++;
            j++;
        }
        return i;
    }
}
