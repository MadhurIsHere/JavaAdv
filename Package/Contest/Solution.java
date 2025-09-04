package Contest;
import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;
class Result {
    public static int lonelyinteger(List<Integer> a) {
        int xor=0;
        for (int k : a) {
            xor ^= k;
        }
        return xor;
    }
}
public class Solution {
    public static void main(String[] args){
        List<Integer> lis=Arrays.asList(1,2,3,4,5,3,2,1,4);
        int res=Result.lonelyinteger(lis);
        System.out.println(res);
    }
}
