package Leetcode;
public class RemoveDuplicatesfromSortedList83 {
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
    public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    }
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr=head;
        while (curr!=null && curr.next!=null)
        {
            if(curr.val==curr.next.val)
            {
                curr.next=curr.next.next;
            }
            else
            {
                curr=curr.next;
            }
        }
        return head;
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
    public static void main(String[] args) {
        ListNode first =new ListNode(10);
        ListNode second =new ListNode(10);
        ListNode third =new ListNode(20);
        ListNode fourth =new ListNode(30);
        ListNode fifth =new ListNode(40);

        first.next=second;
        second.next=third;
        third.next=fourth;
        fourth.next=fifth;
        display(first);
        first=deleteDuplicates(first);
        display(first);
    }
}
