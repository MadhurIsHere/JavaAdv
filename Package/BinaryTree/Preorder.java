package BinaryTree;
import java.util.*;
public class Preorder {
    static void preorder(TreeNode root)
    {
        if(root==null) return;

        System.out.print(root.val + " ");

        preorder(root.left);
        preorder(root.right);
    }

    static List<Integer> preIerative(TreeNode root)
    {
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        Deque<TreeNode> stack=new ArrayDeque<>();

        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode curr=stack.pop();
            if(curr.right!=null)
            {
                stack.push(curr.right);
            }
            if(curr.left!=null)
            {
                stack.push(curr.left);
            }
            res.add(curr.val);
        }
        return res;
    }
}
