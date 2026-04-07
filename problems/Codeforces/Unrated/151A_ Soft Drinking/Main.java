import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int k=in.nextInt();
        int l=in.nextInt();
        int c=in.nextInt();
        int d=in.nextInt();
        int p=in.nextInt();
        int nl=in.nextInt();
        int np=in.nextInt();

        int t=k*l/nl;
        c=c*d;
        p=p/np;
        System.out.println(Math.min(Math.min(t,c),p)/n);
    }
}

/*
n friends
k bottles
l mililiters per bottle
c limes
d slices / lime
p gram of salt

nl of drink
a slice of salt

constains
1<= n,k,l,c,d,p,nl,np<=1000
n,k,l ,c,d,p  ,nl,np
3,4,5,10,8,100,3 ,1
op =2
 */