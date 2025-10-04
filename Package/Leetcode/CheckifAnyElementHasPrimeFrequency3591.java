    package Leetcode;

    public class CheckifAnyElementHasPrimeFrequency3591 {
        public static void main(String[] args) {
            System.out.println(checkPrimeFrequency(new int []{1,2,3,4,5}));
    //        System.out.println(prime(32));
    //        System.out.println(prime(23));
        }
        public static boolean checkPrimeFrequency(int[] nums) {
            int max=max(nums);
            int[] arr=new int[max+1];
            for(int i=0;i<=max;i++)
            {
                arr[i]=0;
            }
            for (int i=0;i<nums.length;i++)
            {
                arr[nums[i]]++;
            }
            for(int i: arr)
            {
                boolean prime=prime(i);
                if(prime) return true;
            }
            return false;
        }
        public static boolean prime(int n)
        {
            if(n<2) return false;
            if(n==2) return true;
            int count=0;
            for(int i=2;i<n;i++)
            {
                if(n%i==0)
                {
                    count++;
                }
            }
            if(count==0) return true;
            return false;
        }
        public static int max(int[] nums)
        {
            int max=Integer.MIN_VALUE;
            for (int i=0;i<nums.length;i++)
            {
                if(max<nums[i])
                {
                    max=nums[i];
                }
            }
            return max;
        }
    }
