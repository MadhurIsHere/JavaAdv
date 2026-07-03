package Leetcode;

public class GasStation134 {
    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        boolean flag = false;
        int n = gas.length;
        int max = Integer.MIN_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if (max < gas[i] - cost[i]) {
                max = gas[i] - cost[i];
                start = i;
            }
        }
//        System.out.println(start);
        int total = 0;
        int prev = 0;
        for (int i = start; i < n; i++) {
            total += gas[i] - prev;
            if (total < 0) {
                flag = true;
            }
            prev = cost[i];
        }
        if (!flag) {
            for (int i = 0; i < start; i++) {
                total += gas[i] - prev;
                if (total < 0) {
                    break;
                }
                prev = cost[i];
            }
            total -= prev;
            if (total >= 0) {
                return start;
            } else return -1;
        } else {
            return -1;
        }
    }
}
