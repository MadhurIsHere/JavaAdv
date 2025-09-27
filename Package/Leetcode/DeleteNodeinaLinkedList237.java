package Leetcode;

public class DeleteNodeinaLinkedList237 {
    public static class ListNode
    {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
       }
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(10);
        ListNode b=new ListNode(20);
        ListNode c=new ListNode(30);
        ListNode d=new ListNode(40);
        a.next=b;
        b.next=c;
        c.next=d;

        display(a);
        deleteNode(b);
        display(a);
    }
    public static void deleteNode(ListNode node) {
        while(node.next.next!=null)
        {
            node.val=node.next.val;
            node=node.next;
        }
        node.val=node.next.val;
        node.next=null;
    }
    private static void display(ListNode a) {
        ListNode temp=a;
        while(temp!=null)
        {
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
}
