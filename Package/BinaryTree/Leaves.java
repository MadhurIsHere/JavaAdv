package BinaryTree;

public class Leaves {
    static int count = 0;

    static int totalLeaf(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null)
            return 1;
        return totalLeaf(root.left) + totalLeaf(root.right);
    }
}
