package ProblemSolving;

public class P01 {
    public static void main(String[] args) {
        /*
        *  489 -> 21 -> 3
        */
        int n=489;
        if(n<9)
        {
            System.out.println(n);
        }
        else if (n%9==0)
        {
            System.out.println(9);
        }
        else
        {
            System.out.println(n%9);
        }

        while(true)
        {
            if(n<9)
            {
                break;
            }
            int count=0;
            while(n>0)
            {
                count+=n%10;
                n/=10;
            }
            n=count;
        }
        System.out.println(n);
    }
}
