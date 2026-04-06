package Contest;

import java.util.*;

public class NumberofPrefixConnectedGroups {
    public static void main(String[] args) {
        System.out.println(prefixConnected(new String[]{"car","cat","cartoon"},3));
    }
    public static int prefixConnected(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(int j=0;j<words.length;j++)
        {

            String curr=words[j];
            if(curr.length()<k ) continue;

            curr=curr.substring(0,k);
            map.put(curr,map.getOrDefault(curr,0)+1);

        }
        int ans=0;
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            int n=entry.getValue();
            if(n>=2) ans++;
        }
        return ans;
    }
}
