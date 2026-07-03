package Recursion;

import java.util.ArrayList;

public class SubSequence {
    public static void main(String[] args) {
        subseq("", "abc");
        System.out.println(subSeq("", "abc"));
    }

    private static void subseq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }
        char ch = up.charAt(0);
        subseq(p + ch, up.substring(1));
        subseq(p, up.substring(1));
    }

    private static ArrayList<String> subSeq(String p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        ArrayList<String> left = subSeq(p + up.charAt(0), up.substring(1));
        ArrayList<String> right = subSeq(p, up.substring(1));
        left.addAll(right);
        return left;
    }
}
    