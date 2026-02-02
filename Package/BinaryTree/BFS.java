package BinaryTree;
import java.util.*;
public class BFS {
    static List<List<Integer>> bfs(TreeNode root)
    {
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;

        Queue<TreeNode> q=new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> level=new ArrayList<>();

            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr.left!=null)
                {
                    q.offer(curr.left);
                }
                if(curr.right!=null)
                {
                    q.offer(curr.right);
                }
                level.add(curr.val);
            }
            res.add(new ArrayList<>(level));
        }
        return res;
    }

}
