package Lambda;

import Recursion.Soduku;

public class P02 {
    public static void main(String[] args) {

        Operation sum=(a,b)-> a + b;
        Operation prod=(a,b)->a*b;
        Operation division =(a,b)-> b!=0 ? a/b :0;
        Operation modulo=(a,b)-> a%b;
        P02 fun=new P02();
        System.out.println(fun.operate(10,2,prod));
        sum.interfce();
    }

    private int operate(int a,int b,Operation op)
    {
        return op.operation(a,b);
    }
}
interface Operation{
    int operation(int a,int b);
    default void interfce()
    {
        System.out.println("I m in interface");
    }
}