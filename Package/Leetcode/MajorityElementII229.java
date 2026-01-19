package Leetcode;
import java.util.*;
public class MajorityElementII229 {
    public static void main(String[] args) {
        int[] arr={3,2,3};
        System.out.println(majorityElement(arr));
    }
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> list=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums)
        {
            map.put(num,map.getOrDefault(num,0)+1);
        }
        map.forEach((key,value)->{
            if(value>nums.length/3)
            {
                list.add(key);
            }
        });
        return list;
    }
}
