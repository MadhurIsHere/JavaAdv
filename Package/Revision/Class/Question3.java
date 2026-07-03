package Revision.Class;

public class Question3 {
    public static void main(String[] args) {
        // find the max and second max element in array also give the index of both
        int[] arr={1,10,21,1,99,87,66};

        int max=Integer.MIN_VALUE;
        int secondMax=Integer.MIN_VALUE;

        int index=-1;
        int secondIndex=-1;

        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]>max)
            {
                secondMax=max;
                max=arr[i];
                secondIndex=index;
                index=i;
            }
            else if(arr[i]>secondMax)
            {
                secondMax=arr[i];
                secondIndex=i;
            }
        }
        System.out.println("Max number is "+max+ " and its index is "+index);
        System.out.println("Second max Index is "+secondMax+" and its index is "+secondIndex);
    }
}
