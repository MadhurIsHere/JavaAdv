package Recursion;
import java.util.ArrayList;
import java.util.List;

public class SumOfSubset {
    public static void main(String[] args) {
        int[] nums={10,20,30,40};
        int sum=50;
        List<List<Integer>> subset=new ArrayList<>();
        helper(nums,subset,new ArrayList<>(),0,sum);
        System.out.println(subset);
    }
    private static void helper(int[] nums,List<List<Integer>> subset,List<Integer> list,int index,int sum)
    {
        if(sum==0){
            subset.add(new ArrayList<>(list));
            return;
        }
        if(index==nums.length || sum<=0)
        {
            return;
        }
        int k=nums[index];
        sum-=k;
        list.add(nums[index]);
        helper(nums,subset,list,index+1,sum);
        list.remove(list.size()-1);
        sum+=k;
        helper(nums,subset,list,index+1,sum);
    }
}
