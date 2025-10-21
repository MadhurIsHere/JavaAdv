package Leetcode;

public class IntegertoRoman12 {
    public static void main(String[] args) {
        System.out.println(intToRoman(3749));
    }
    public static String intToRoman(int num) {
        StringBuilder ans=new StringBuilder();
        int[] val={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        for(int i=0;i<13;i++)
        {
            if(num<1) break;
            int times=num/val[i];
            while (times>0)
            {
                ans.append(symbol[i]);
                times--;
            }
            num%=val[i];
        }
        return ans.toString();
    }
}
