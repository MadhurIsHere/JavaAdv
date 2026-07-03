package Leetcode;

public class LemonadeChange860 {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[]{5, 5, 10, 20, 5, 5, 5, 5, 5, 5, 5, 5, 5, 10, 5, 5, 20, 5, 20, 5}));
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                five++;
            else if (bills[i] == 10) {
                ten++;
                five--;
                if (five < 0) return false;
            } else {
                if (five >= 3) {
                    five -= 3;
                } else {
                    five--;
                    ten--;
                }
            }
            if (ten < 0 || five < 0) return false;
        }
        return true;
    }
}
