package Revision.Class;

import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] arr={-5,-1,2,3,4,2,8,4};
        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<arr.length;i++)
        {
            int mod=arr[i]%3;
            map.put(mod,map.getOrDefault(mod,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
}
