package ProblemSolving;

public class P12 {
    public static void main(String[] args) {
        int[] arr=new int[26];

        String s="hello";
        for(int i=0;i<s.length();i++)
        {
            int x=(int)s.charAt(i)-'a';
            System.out.println(x);
            arr[x]++;
        }
        boolean[] visited=new boolean[26];

        for(int i=0;i<s.length();i++)
        {
                int x = (int) s.charAt(i) - 'a';
                if(visited[x]) continue;
                char c = s.charAt(i);
                visited[x] = true;
                System.out.print(c + "" + arr[x]);
        }

        System.out.println();

        int[] arr1=new int[26];
        int[] arr2=new int[26];

        String s1="silent";
        String s2="listen";
        if(s1.length()==s2.length())
        {
            for(int i=0;i<s1.length();i++)
            {
                int x=(int)s1.charAt(i)-'a';
                int y=(int)s2.charAt(i)-'a';
                arr1[x]++;
                arr2[y]++;
            }

            int index=0;
            boolean flag=true;
            while (index<26)
            {
                if(arr1[index]!=arr2[index])
                {
                    flag=false;
                    break;
                }
                index++;
            }
            System.out.println("The string are anagram ?: "+flag);
        }
    }
}
