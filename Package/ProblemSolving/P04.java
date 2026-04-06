package ProblemSolving;

public class P04 {
    // prime or not using recursion

    public static void main(String[] args) {
        System.out.println(prime(27,2)==0);
    }
    static int prime(int n,int index)
    {
        if(index*index>n)
        {
            return 0;
        }
        if(n%index==0)
        {
            return 1;
        }
        else
        {
            return prime(n, index + 1);
        }
    }
}
