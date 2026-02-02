package BinaryTree;

public class BST {
    /*
    *                 12
    *              /      \
    *            9           16
    *          /   \        /   \
    *        6       10    14      60
    *       / \     / \  / \      / \
    *      5   7   8  11 13 15   20  100
    * */
    static boolean dst(TreeNode root,int target)
    {
        if(root==null) return false;

        if(root.val==target) return true;
        else if(root.val<target) return dst(root.right,target);
        else return dst(root.left,target);

    }
    static TreeNode create(TreeNode root,int val)
    {
        if(root==null)
        {
            return new TreeNode(val);
        }
        if(root.val>val)
        {
            root.left=create(root.left,val);
        }
        else {
            root.right = create(root.right, val);
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

    static TreeNode delete(TreeNode root,int val)
    {
        if(root==null) return null;
        else if(root.val>val)
        {
            delete(root.left,val);
        }
        else if(root.val<val){
            delete(root.right,val);
        }
        else
        {
            if(root.left==null && root.right==null) // not child
            {
                return null;
            }

            else if(root.left==null || root.right==null) // one child
            {
                return root.left!=null ? root.left : root.right;
            }

            else { // 2 child

            }
        }

        return root;
    }
    static TreeNode find(TreeNode node)
    {
        while (node!=null)
        {
            node=node.left;
        }
        return node;
    }
}
