import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int nb = in.nextInt();
        int ns = in.nextInt();
        int nc = in.nextInt();


        int pb = in.nextInt();
        int ps = in.nextInt();
        int pc = in.nextInt();

        long r = in.nextLong();


        int[] freq=new int[3];

        for(int i=0;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(ch=='B')
            {
                freq[0]++;
            }
            else if(ch=='S')
            {
                freq[1]++;
            }
            else
            {
                freq[2]++;
            }
        }

        int[] stock=new int[3];
        stock[0]=nb/freq[0];
        stock[1]=ns/freq[1];
        stock[2]=nc/freq[2];

        long low=0;
        long high=1_000_000_000_007L;
        while (low<=high)
        {
            long mid=low+(high-low)/2;
            long needB=Math.min(mid*pb);
            long needC=mid*pc;
            long needS=mid*ns;
        }
    }
}