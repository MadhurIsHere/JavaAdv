package BinaryTree;

public class MaxPathSum {
    static int pathSum(TreeNode root,int[] max)
    {
        if(root==null) return 0;

        int leftSum=Math.max(0,pathSum(root.left,max));
        int rightSum=Math.max(0,pathSum(root.right,max));
        max[0]=Math.max(max[0],leftSum+rightSum+root.val);

        return root.val+Math.max(leftSum,rightSum);
    }
}
