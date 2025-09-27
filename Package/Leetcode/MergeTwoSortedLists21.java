package Leetcode;

public class MergeTwoSortedLists21 {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {
        }
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode();
        ListNode cur=dummy;
        while(list1!=null && list2!=null)
        {
            if(list1.val<list2.val)
            {
                cur.next=list1;
                list1=list1.next;
            }
            else
            {
                cur.next=list2;
                list2=list2.next;
            }
        }
        cur.next=(list1==null) ? list2 :list1;
        return dummy.next;
    }
    static void display(ListNode head)
    {
        ListNode node=head;
        while (node!=null)
        {
            System.out.print(node.val+" -> ");
            node=node.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args) {
        ListNode first=new ListNode(10);
        ListNode second=new ListNode(20);
        ListNode third=new ListNode(30);
        ListNode fourth=new ListNode(40);
        ListNode fifth=new ListNode(5);
        ListNode sixth=new ListNode(15);
        ListNode seventh=new ListNode(25);

        first.next=second;
        second.next=third;
        third.next=fourth;

        fifth.next=sixth;
        sixth.next=seventh;

        display(first);
        display(fifth);
        ListNode node=mergeTwoLists(first,fifth);
        display(node);
    }
}
