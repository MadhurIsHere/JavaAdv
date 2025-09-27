package LinkedList;

public class CountingNode {
    static class Node{
        int val;
        Node next;
        Node() {}
        Node(int val){ this.val=val;}
        Node(int val,Node next) { this.val=val; this.next=next;}
    }
    public static int counting(Node head)
    {
        int counting=0;
        Node temp=head;
        while(temp!=null)
        {
            counting++;
            temp=temp.next;
        }
        return counting;
    }

    public static void main(String[] args) {
        Node first =new Node(10);
        Node second =new Node(20);
        Node third=new Node(30);

        first.next=second;
        second.next=third;
        System.out.println(counting(first));
    }
}
