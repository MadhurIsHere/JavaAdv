package ArithmeticBasicReasoning;
import java.util.*;
public class SelfDividingNumbers {
    public static void main(String[] args) {
        System.out.println(selfDividingNumbers(1,22));
    }
    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list=new ArrayList<>();

        for(int i=left;i<=right;i++)
        {
            if(helper(i))
            {
                list.add(i);
            }
        }
        return list;
    }
    private static boolean helper(int x)
    {
        List<Integer> digits=new ArrayList<>();
        int copy=x;
        while(copy>0)
        {
            int digit=copy%10;
            if(digit==0) return false;
            digits.add(digit);
            copy/=10;
        }
        System.out.println(digits);
        for(int digit:digits)
        {
            if(x%digit!=0) return false;
        }
        return true;
    }
}
