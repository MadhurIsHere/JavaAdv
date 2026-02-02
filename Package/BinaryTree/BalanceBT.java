package BinaryTree;

public class BalanceBT {
    /*
    * A binary Tree is called to be balanced
    * if the difference of the height of the left subtree and the right subtree is <=1
    */
    static int balance(TreeNode root)
    {
        if(root==null) return 0;

        int left_tree=balance(root.left);
        if(left_tree==-1) return -1;
        int right_tree=balance(root.right);
        if(right_tree==-1) return -1;

        if(Math.abs(left_tree-right_tree)>1) return -1;
        return Math.max(left_tree,right_tree)+1;
    }

}
