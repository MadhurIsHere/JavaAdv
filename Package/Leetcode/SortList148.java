package Leetcode;

public class SortList148 {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode middleNode=middleNode(head);
        ListNode right=middleNode.next;
        ListNode left=head;
        middleNode.next=null;
        left=sortList(left);
        right=sortList(right);
        return merge(left,right);
    }
    static ListNode merge(ListNode first, ListNode second)
    {
        ListNode dummy=new ListNode(-1);
        ListNode temp=dummy;
        while (first!=null && second!=null)
        {
            if(first.val<second.val)
            {
                temp.next=first;
                temp=temp.next;
                first=first.next;
            }else {
                temp.next=second;
                second=second.next;
                temp=temp.next;
            }
        }
        while (first!=null)
        {
            temp.next=first;
            first=first.next;
            temp=temp.next;
        }
        while(second!=null)
        {
            temp.next=second;
            second=second.next;
            temp=temp.next;
        }
        return dummy.next;
    }
    public static ListNode middleNode(ListNode head)
    {
        ListNode fast=head.next;
        ListNode slow=head;
        while (  fast!=null && fast.next!=null )
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        return slow;
    }
    static void display(ListNode head)
    {
        ListNode temp=head;
        while (temp!=null)
        {
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        ListNode a=new ListNode(4);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(1);
        ListNode d=new ListNode(3);
        a.next=b;
        b.next=c;
        c.next=d;
        display(a);
        a=sortList(a);
        display(a);
    }
}
