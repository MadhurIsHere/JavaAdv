package BinaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class PostOrder {
    static void postOrder(TreeNode root)
    {
        if(root==null) return;

        postOrder(root.left);
        postOrder(root.right);

        System.out.print(root.val + " ");
    }

    static List<Integer> postIterative(TreeNode root)
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
            res.addFirst(curr.val);
        }
        return res;
    }
}
