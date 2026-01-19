package Leetcode;

public class FourDivisors1390 {
    public static void main(String[] args) {
        System.out.println(sumFourDivisors(new int[]{21,4,7}));
    }
    public static int sumFourDivisors(int[] nums) {
        int sum=0;
        for(int element: nums)
        {
            int count=0;
            int temp_sum=0;
            for(int i=2;i*i<=element;i++)
            {
                if(element%i==0)
                {
                    count++;
                    temp_sum+=i;
                }
            }
            if(count==2)
            {
                temp_sum+=element+1;
                sum+=temp_sum;
            }
        }
        return sum;
    }
}
