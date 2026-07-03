package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class BoundaryNodes {
    private static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    private static List<Integer> right(TreeNode root) {
        List<Integer> right = new ArrayList<>();
        while (root != null) {
            if (!isLeaf(root)) right.add(root.val);
            if (root.right == null) root = root.left;
            else root = root.right;
        }
        return right.reversed();
    }

    private static List<Integer> left(TreeNode root) {
        List<Integer> left = new ArrayList<>();
        while (root != null) {
            if (!isLeaf(root)) left.add(root.val);
            if (root.left != null) root = root.left;
            else root = root.right;
        }
        return left;
    }

    private static List<Integer> leaf(TreeNode root) {
        List<Integer> leaf = new ArrayList<>();
        if (isLeaf(root)) {
            leaf.add(root.val);
            return leaf;
        }
        if (root.left != null) leaf.addAll(leaf(root.left));
        if (root.right != null) leaf.addAll(leaf(root.right));
        return leaf;
    }

    public static List<Integer> boundary(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        res.add(root.val);
        res.addAll(left(root.left));
        res.addAll(leaf(root));
        res.addAll(right(root.right));
        return res;
    }
}
