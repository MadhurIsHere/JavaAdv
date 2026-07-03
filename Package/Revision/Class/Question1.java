package Revision.Class;
import java.util.*;
public class Question1 {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the total vehicle");
        int vehicle =in.nextInt();
        System.out.println("Enter the number of tyre");
        int tyre=in.nextInt();
        int car=0;
        if(tyre>=2)
        {
            car=-vehicle+tyre/2;
        }
        int bike=2*vehicle-tyre/2;

        car = (car > vehicle) ? vehicle : car;
        System.out.println("Cars:"+car);

        bike= Math.max(bike, 0);
        System.out.println("Bike:"+bike);

        // max and min type of vehicle
        int maxC=tyre/4;
        int maxB=tyre/2;
        System.out.println("max bike= "+maxB +" and max car= "+maxC);
        int minC=(tyre-2*maxB)/4;
        int minB=(tyre-4*maxC)/2;
        System.out.println("min bike= "+minB +" and min car= "+minC);

    }
}
