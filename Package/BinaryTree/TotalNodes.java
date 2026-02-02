package BinaryTree;

public class TotalNodes {
    static int totalNode(TreeNode root)
    {
        if(root==null) return 0;

        return 1+totalNode(root.left)+totalNode(root.right);
    }
}
