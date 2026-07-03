package Codeforce;

import java.util.Scanner;

public class TheNewYearMeetingFriends {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x, y, z;
        x = in.nextInt();
        y = in.nextInt();
        z = in.nextInt();

        int mid = -1;
        if ((y >= x && x >= z) || (z >= x && x >= y)) mid = x;
        else if ((z >= y && y >= x) || (x >= y && y >= z)) mid = y;
        else mid = z;
        System.out.println(Math.abs(mid - x) + Math.abs(mid - y) + Math.abs(mid - z));
    }
}
