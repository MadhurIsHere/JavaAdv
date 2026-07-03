import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        int m=in.nextInt();

        int dir=1;
        int index=0;
        while(index<n)
        {
            if(index%2==0) // move on x axis
            {
                for(int i=0;i<m;i++)
                {
                    System.out.print("#");
                }
            }
            else if(dir==1 && index%2!=0)// move on y axis from last
            {
                dir*=-1;
                for(int i=0;i<m;i++)
                {
                    if(i+1==m) {
                        System.out.print("#");
                    }
                    else
                    {
                        System.out.print(".");
                    }
                }
            }
            else // move on y axis from start
            {
                dir*=-1;
                for(int i=0;i<m;i++)
                {
                    if(i==0) {
                        System.out.print("#");
                    }
                    else
                    {
                        System.out.print(".");
                    }
                }
            }
            index++;
            System.out.println();
        }
    }
}