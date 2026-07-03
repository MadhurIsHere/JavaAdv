package Practice;

public class Height {
    static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    static int leaf(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }
        return leaf(root.left) + leaf(root.right);
    }

    static boolean balance(TreeNode root) {
        return isBalance(root) != -1;
    }

    static int isBalance(TreeNode root) {
        if (root == null) return 0;

        int l = isBalance(root.left);
        if (l == -1) return -1;

        int r = isBalance(root.right);
        if (r == -1) return -1;

        if (Math.abs(l - r) > 1) return -1;

        return 1 + Math.max(l, r);
    }
}
