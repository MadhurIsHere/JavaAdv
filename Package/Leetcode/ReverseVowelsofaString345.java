package Leetcode;

public class ReverseVowelsofaString345 {
    public static void main(String[] args) {
        System.out.println(reverseVowels("IceCreAm"));
    }
    public static String reverseVowels(String s) {
        StringBuilder result=new StringBuilder(s);

        int i=0;
        int j=s.length()-1;
        while(i<=j)
        {
            char ch1=result.charAt(i);
            char ch2=result.charAt(j);
            if((ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o'|| ch1=='u'|| ch1=='A'|| ch1=='E'|| ch1=='I' || ch1=='O'|| ch1=='U')&& (ch2=='a' || ch2=='e' || ch2=='i' || ch2=='o'|| ch2=='u'|| ch2=='A'|| ch2=='E'|| ch2=='I' || ch2=='O'|| ch2=='U'))
            {
                result.setCharAt(i,ch2);
                result.setCharAt(j,ch1);
                j--;
                i++;
            }
            else
            {
                if(!(ch1=='a' || ch1=='e' || ch1=='i' || ch1=='o'|| ch1=='u'|| ch1=='A'|| ch1=='E'|| ch1=='I' || ch1=='O'|| ch1=='U'))
                {
                    i++;
                }
                else
                    j--;
            }
        }
        return result.toString();
    }
}
