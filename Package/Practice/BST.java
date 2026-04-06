package Practice;

public class BST {
    static class TreeNode{
        int val;
        TreeNode left, right;
        TreeNode(){}

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    static void inorder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    static void preOrder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void postOrder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val+" ");
    }
    static TreeNode create(TreeNode root,int val)
    {
        if(root==null) {
            TreeNode node=new TreeNode(val);
            root=node;
            return root;
        }
        else if(root.val>val)
        {
            root.left=create(root.left,val);
        }
        else {
            root.right=create(root.right,val);
        }
        return root;
    }
    static TreeNode buildBts(TreeNode root, int[] arr)
    {
        TreeNode temp=root;
        for(int i=0;i<arr.length;i++)
        {
            temp=create(temp,arr[i]);
        }
        return temp;
    }

    public static void main(String[] args) {
        TreeNode root=new TreeNode(8);
        int[] arr={1,2,3,7,4,5,6,9,10};
        buildBts(root,arr);
        inorder(root);
    }
}
