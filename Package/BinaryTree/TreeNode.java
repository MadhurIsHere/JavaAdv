package BinaryTree;
import java.util.*;
public class TreeNode {
    static Scanner in = new Scanner(System.in);

        public int val;
        public TreeNode left,right;

        public TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
        static TreeNode create()
        {
            int val;
            System.out.println("Enter any number as val and -1 to end up");
            val=in.nextInt();
            if(val==-1) return null;

            TreeNode node=new TreeNode(val);
            System.out.println("Enter the left node");
            node.left=create();
            System.out.println("Enter the right node");
            node.right=create();

            return node;
        }

        // DFS iterative
        // Inorder -> This uses stack
        static List<Integer> dfs4(TreeNode root)
        {
            List<Integer> list=new ArrayList<>();
            if(root==null) return list;
            Deque<TreeNode> stack=new ArrayDeque<>();
            TreeNode node=root;
            while(true)
            {
                if(node!=null)
                {
                    stack.push(node);
                    node=node.left;
                }
                else
                {
                    if(stack.isEmpty()) break;
                    node=stack.pop();
                    list.add(node.val);
                    node=node.right;
                }
            }
            return list;
        }
}
