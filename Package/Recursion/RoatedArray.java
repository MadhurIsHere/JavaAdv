package Recursion;

public class RoatedArray {
    public static void main(String[] args) {
        System.out.println(binarySearch(new int[] {5,6,1,2,3,4},0,5,4));
    }
    static int binarySearch(int[] arr,int start,int end,int target)
    {
        if(start>end) return -1;
        int mid=start+(end-start)/2;
        if(arr[mid]==target) return mid;
        if(arr[start]<=arr[mid])
        {
            if(arr[start]<=target && target<arr[mid])
            {
                return binarySearch(arr,start,mid-1,target);
            }
            else {
                return binarySearch(arr,mid+1,end,target);
            }
        }
        else
        {
            if(arr[mid]<target && target<=arr[end])
            {
                return binarySearch(arr,mid+1,end,target);
            }
            else {
                return binarySearch(arr,start,mid-1,target);
            }
        }
    }
}
