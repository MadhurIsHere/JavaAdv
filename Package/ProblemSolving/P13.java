package ProblemSolving;

public class P13 {
    public static void main(String[] args) {
        String s = "aaabbccce";
        if (s.charAt(0) != s.charAt(1)) {
            System.out.println(s.charAt(0));
        } else {
            int ind = -1;
            for (int i = 1; i < s.length() - 1; i++) {
                boolean left = (s.charAt(i) != s.charAt(i - 1));
                boolean right = (s.charAt(i) != s.charAt(i + 1));
                if (left && right) {
                    ind = i;
                    break;
                }
            }
            if (ind == -1) {
                s.charAt(s.length() - 1);
            } else {
                System.out.println(s.charAt(ind));
            }
        }
    }
}
