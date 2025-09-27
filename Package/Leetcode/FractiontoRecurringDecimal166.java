package Leetcode;

public class FractiontoRecurringDecimal166 {
    public static void main(String[] args) {
        System.out.println(fractionToDecimal(4,333));
    }
    public static String fractionToDecimal(int numerator, int denominator) {
        if (numerator==0) return "0";

        StringBuilder result=new StringBuilder();
        if((numerator<0)^(denominator<0)) result.append("-");

        long n=(long) Math.abs(numerator);
        long d=(long) Math.abs(denominator);

        result.append(n/d);
        long reminder=n%d;
        if(reminder==0) return result.toString();

        result.append(".");
        int[] arr=new int[(int)d+1];
        StringBuilder fraction=new StringBuilder();
        int index=0;

        while(reminder!=0)
        {
            if(arr[(int) reminder]!=0){
                int start=arr[(int) reminder]-1;
                fraction.insert(start,"(");

                fraction.append(")");
                break;
            }
            arr[(int) reminder]=index+1 ;
            reminder*=10;
            fraction.append(reminder/d);
            reminder%=d;
            index++;
        }
        result.append(fraction);
        return result.toString();
    }
}
