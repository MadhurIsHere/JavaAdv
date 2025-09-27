package Leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers2 {
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

    static void display(ListNode head)
    {
        ListNode temp=head;
        while (temp!=null)
        {
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public static ListNode addTwoNumbers(ListNode head1,ListNode head2)
    {
        ListNode node=new ListNode(0);
        ListNode curr=node;
        int carry=0;
        while(head1!=null || head2!=null || carry!=0)
        {
            int x= head1!=null ? head1.val : 0;
            int y= head2!=null ? head2.val : 0;
            int sum=x+y+carry;
            carry=sum/10;
            curr.next=new ListNode(sum%10);
            curr=curr.next;

            if (head1!=null) head1=head1.next;
            if(head2!=null) head2=head2.next;
        }
        return node.next;
    }
    public static void main(String[] args) {
        ListNode first=new ListNode(2);
        ListNode second=new ListNode(4);
        ListNode third=new ListNode(3);
        first.next=second;
        second.next=third;
        display(first);

        ListNode fourth=new ListNode(5);
        ListNode fifth=new ListNode(6);
        ListNode sixth=new ListNode(4);
        fourth.next=fifth;
        fifth.next=sixth;
        display(fourth);

        ListNode result=addTwoNumbers(first,fourth);
        display(result);
    }
}
