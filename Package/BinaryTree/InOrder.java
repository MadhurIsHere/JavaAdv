package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class InOrder {
    static void inOrder(TreeNode root)
    {
        if(root==null)
        {
            return;
        }
        inOrder(root.left);
        System.out.print(root.val+" ");
        inOrder(root.right);
    }
    static List<Integer> inOrderIterative(TreeNode root){
        List<Integer> res=new ArrayList<>();
        if(root==null) return res;

        TreeNode node=root;
        Deque<TreeNode> stack=new ArrayDeque<>();

        while (true)
        {
            if(node.left!=null)
            {
                stack.push(node);
                node=node.left;
            }
            else {
                if(stack.isEmpty()) break;
                node=stack.pop();
                res.add(node.val);
                node=node.right;
            }
        }
        return res;
    }
}
