package BinaryTree;

public class Height {
    public static int height(TreeNode root)
    {
        if(root==null) return 0;

        int l=height(root.left);
        int r=height(root.right);
        return Math.max(l,r)+1;
    }
}
