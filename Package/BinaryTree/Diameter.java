package BinaryTree;

public class Diameter {
    /*
    * The diameter of a tree is the max distance between two nodes (max number of edges)
    */

    static int diameter(TreeNode root,int[] max)
    {
        if(root==null) return 0;

        int l_tree=diameter(root.left,max);
        int r_tree=diameter(root.right,max);

        max[0]=Math.max(max[0],l_tree+r_tree);
        return Math.max(l_tree,r_tree)+1;
    }
}
