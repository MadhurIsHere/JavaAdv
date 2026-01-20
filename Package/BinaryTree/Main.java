package BinaryTree;

public class Main {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        TreeNode.dfs1(node);
        System.out.println();
        System.out.println(Depth.maxDepth(node));
    }
}
