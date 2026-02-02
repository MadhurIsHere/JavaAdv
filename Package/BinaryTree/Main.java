package BinaryTree;

import java.util.Scanner;

public class Main {
    /*
    *         1            1
    *       /   \
    *      2     3         2
    *     / \   / \
    *    4   5 6   7       3
    */

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right=new TreeNode(5);
        node.right.left=new TreeNode(6);
        node.right.right=new TreeNode(7);



        System.out.println(BoundaryNodes.boundary(node));


        int[] dia=new int[1];
        Diameter.diameter(node,dia);
        System.out.println("The dia of the tree is :"+dia[0]);
        System.out.println("PreORDER");
        Preorder.preorder(node);
        System.out.println("postORDER");
        PostOrder.postOrder(node);
        System.out.println("InORDER");
        InOrder.inOrder(node);
        System.out.println("\nTotal number of Nodes :"+TotalNodes.totalNode(node));

        System.out.println("\nLevel wise traversal :"+BFS.bfs(node));
        System.out.println("\nTotal Number of leaf nodes :"+Leaves.totalLeaf(node));

        System.out.println("\nBinary Search Tree :"+BST.dst(node,3));

        node.right.right.right=new TreeNode(8);
        node.right.right.right.right=new TreeNode(9);
        node.right.right.right.right.right=new TreeNode(10);
        System.out.println("\nBalance tree or not :"+(BalanceBT.balance(node)!=-1));

        int[] pathSum=new int[1];
        MaxPathSum.pathSum(node,pathSum);
        System.out.println("Maximum sum is :"+pathSum[0]);
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the size of bts");
        int n=in.nextInt();
        int[] arr=new int[n];
        System.out.println("Enter the values of the tree one by one");
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextInt();
        }

        TreeNode root=BST.buildBts(null,arr);

        Preorder.preorder(root);

//        System.out.println();
//        System.out.println("Height of the tree is "+Height.height(node));
//        System.out.println("Max depth of the tree is "+Depth.maxDepth(node));
//        System.out.println("Min depth of the tree is "+Depth.minDepth(node));
    }
}
