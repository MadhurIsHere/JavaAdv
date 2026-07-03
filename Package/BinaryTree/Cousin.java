package BinaryTree;

import java.util.ArrayDeque;
import java.util.Deque;

public class Cousin {
    private int three(String s) {
        int len = 0;
        StringBuilder x = new StringBuilder(s);
        String a = "abc";
        while (s.contains(a)) {
            s = s.replace(a, "");
            len += 3;
        }
        return len;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode();
        tree = TreeNode.create();

        isCousins(tree, 2, 3);
    }

    public static boolean isCousins(TreeNode root, int x, int y) {
        Deque<TreeNode> q = new ArrayDeque<>();

        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            boolean yfound = false;
            boolean xfound = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.val == x) xfound = true;
                if (curr.val == y) yfound = true;

                if (curr.left != null && curr.right != null) {
                    if ((curr.left.val == x && curr.right.val == y) || curr.right.val == x && curr.left.val == y) {
                        return false;
                    }
                }
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            if (xfound && yfound) return true;
        }
        return false;
    }
}
