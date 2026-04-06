package SegmentTree;

public class SegmentTree {
    private static class Node{
        int data,startInterval,endInterval;
        Node left,right;

        public Node(int startInterval, int endInterval) {
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, int startInterval, int endInterval) {
            this.data = data;
            this.startInterval = startInterval;
            endInterval = endInterval;
        }

        public Node(int data, int startInterval, int endInterval, Node left, Node right) {
            this.data = data;
            this.startInterval = startInterval;
            this.endInterval = endInterval;
            this.left = left;
            this.right = right;
        }
    }
    Node root;

    public SegmentTree(int[] arr) {
        this.root=constructTree(arr,0,arr.length-1);
    }
    public void display()
    {
        display(this.root);
    }
    private void display(Node root)
    {
        String str="";
        if(root.left!=null)
        {
            str+="Interval=["+root.left.startInterval+"-"+root.left.endInterval+"] and data: "+root.left.data+" => ";
        }
        else {
            str+="No left child";
        }
        str+="Interval=["+root.startInterval+"-"+root.endInterval+"] and data: "+root.data+" => ";
        if(root.right!=null)
        {
            str+="Interval=["+root.right.startInterval+"-"+root.right.endInterval+"] and data: "+root.right.data+" => ";
        }else
        {
            str=str+"No right child";
        }

        System.out.println(str);
        if(root.left!=null)
        {
            display(root.left);
        }
        if(root.right!=null)
        {
            display(root.right);
        }
    }
    private Node constructTree(int[] arr, int start, int end) {
        if(start==end){
            Node leaf=new Node(start,end);
            leaf.data=arr[start];
            return leaf;
        }
        Node node =new Node(start,end);
        int mid=start+(end-start)/2;
        node.left=constructTree(arr,start,mid);
        node.right=constructTree(arr,mid+1,end);
        node.data=node.left.data+node.right.data;
        return node;
    }
    public int query(int qsi,int qei)
    {
        return this.query(this.root,qsi,qei);
    }
    private int query(Node node,int sqi,int qei)
    {
        if(node.startInterval>=sqi && node.endInterval<=qei)
        {
            return node.data;
        }
        else if(node.startInterval<=sqi && node.endInterval>=qei)
        {
            return this.query(node.left,sqi,qei)+this.query(node.right,sqi,qei);
        }
        else {
            return 0;
        }
    }
    public void update(int index,int value)
    {
        this.root.data=update(this.root,index,value);
    }

    private int update(Node root, int index, int value) {
        if(root.startInterval<=index && root.endInterval>=index)
        {
            if(index==root.startInterval && index==root.endInterval)
            {
                root.data=value;
                return root.data;
            }
            else
            {
                return root.data=update(root.left,index,value)+update(root.right,index,value);
            }
        }
        else
        {
            return root.data;
        }
    }

}
