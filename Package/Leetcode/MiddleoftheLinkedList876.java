package Leetcode;

public class MiddleoftheLinkedList876 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode middleNode(ListNode head) {
        int size=sizeOf(head)/2;
        int count=0;
        ListNode temp=head;
        while (count<size)
        {
            temp=temp.next;
            count++;
        }
        head=temp;
        return head;
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
    public static int sizeOf(ListNode head)
    {
        int size=0;
        ListNode node=head;
        while (node!=null)
        {
            size++;
            node=node.next;
        }
        return size;
    }
    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        a.next=b;
        b.next=c;
        c.next=d;
        display(a);
        ListNode head=middleNode(a);
        display(head);
    }
}
