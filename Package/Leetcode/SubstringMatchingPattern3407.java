package Leetcode;

public class SubstringMatchingPattern3407 {
    public static void main(String[] args) {
        System.out.println(hasMatch("rrerhehhhh","h*r"));
    }
    // task is that given two string s and p, p has one *
    // now break the p in two parts p1 and p2 such that p1 has the substring from 0 to *th index,
    // p2 contains the substring from *th index+1 to n-1;
    // now check weather both p1 and p2 are of same equal;
    // if no then just check and return the answer that return (s.contains(p1) && s.contains(p2))
    // if yes then
    public static boolean hasMatch(String s, String p) {
        int index=p.indexOf("*");
        String p1=p.substring(0,index);
        String p2=p.substring(index+1);
        if (p2.equals(p1))
        {
            StringBuilder k=new StringBuilder(s);
            int loc=k.indexOf(p1);
            k.delete(loc,loc+p1.length());
            s=k.toString();
            return s.contains(p2);
        }
        else {
            int locp1=s.indexOf(p1);
            int locp2=s.indexOf(p2,locp1+p.length());

            return locp2!=-1;
        }
    }
}
