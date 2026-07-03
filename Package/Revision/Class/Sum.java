package Revision.Class;

public class Sum {
    public static void main(String[] args) {
        int a=5;
        int b=7;
        int sum=0,carry=-1;
        while (carry!=0)
        {
            sum=a^b;
            carry=a&b;
            a=sum;
            b=carry<<1;
        }
        System.out.println(sum);
    }

}
