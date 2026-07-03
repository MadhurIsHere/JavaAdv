package BinaryTree;

import java.util.Scanner;

public class TreeNode {

    static Scanner in = new Scanner(System.in);
    public int val;
    public TreeNode left, right;

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


    public static TreeNode create() {
        int val;
        System.out.println("Enter any number as val and -1 to end up");
        val = in.nextInt();
        if (val == -1) return null;

        TreeNode node = new TreeNode(val);
        System.out.println("Enter the left node");
        node.left = create();
        System.out.println("Enter the right node");
        node.right = create();

        return node;
    }
}
