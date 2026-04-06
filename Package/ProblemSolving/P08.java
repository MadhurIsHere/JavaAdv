package ProblemSolving;

public class P08 {
    public static void main(String[] args) {
        int l=10;
        int r=20;

        while(l<=r)
        {
            if(l==2)
            {
                System.out.println(l);
                l++;
                continue;

            }
            int count=0;
            for(int i=2;i*i<=l;i++)
            {
                if(l%i==0)
                {
                    count++;
                    break;
                }
            }
            if(count==0)
            {
                int n=l;
                int rev=0;
                while(n>0)
                {
                    rev=rev*10+n%10;
                    n/=10;
                }
                System.out.println(rev);
            }
            l++;
        }
    }

}
