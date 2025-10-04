package Leetcode;

public class ReverseLinkedListII92 {
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
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(left==right) return head;
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode prev=dummy;

        for (int i=1;i<left;i++)
        {
            prev=prev.next;
        }
        ListNode curr=prev.next;
        ListNode next=null;
        ListNode last = curr;  // store start of sublist

        for (int i = left; i <= right; i++) {
            next = curr.next;
            curr.next = prev.next; // insert at beginning of sublist
            prev.next = curr;      // prev stays fixed
            curr = next;
        }

        last.next = curr;  // connect tail

        return dummy.next;
    }
    public static void display(ListNode head)
    {
        ListNode temp=head;
        while (temp!=null)
        {
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("End");
    }
    public static void main(String[] args) {
        ListNode list1=new ListNode(1);
        ListNode list2=new ListNode(2);
        ListNode list3=new ListNode(3);
        ListNode list4=new ListNode(4);
        ListNode list5=new ListNode(5);
//        ListNode list6=new ListNode(50);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
//        list5.next=list6;
        display(reverseBetween(list1,2,4));
    }
}
