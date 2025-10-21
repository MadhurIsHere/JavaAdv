package Leetcode;

public class MergekSortedLists23 {
    public static class ListNode {
       int val;
       ListNode next;
//       ListNode() {}
       ListNode(int val) { this.val = val; }
//       ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    static ListNode MergeTwo(ListNode first,ListNode second)
    {
        ListNode node=new ListNode(-1);
        ListNode temp=node;
        while (first!=null && second!=null)
        {
            if(first.val<second.val)
            {
                temp.next=first;
                temp=temp.next;
                first=first.next;
            }
            else {
                temp.next=second;
                second=second.next;
                temp=temp.next;
            }
        }
        while (first!=null)
        {
            temp.next=first;
            temp=temp.next;
            first=first.next;
        }
        while (second!=null)
        {
            temp.next=second;
            second=second.next;
            temp=temp.next;
        }
        return node.next;
    }
    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0) return null;
        ListNode head=lists[0];
        for(int i=1;i<lists.length;i++)
        {
            head=MergeTwo(lists[i],head);
        }
        return head;
    }

    public static void display(ListNode head)
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
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(4);
        ListNode c=new ListNode(5);
        ListNode d=new ListNode(1);
        ListNode e=new ListNode(3);
        ListNode f=new ListNode(4);
        ListNode g=new ListNode(2);
        ListNode h=new ListNode(6);
        a.next=b;
        b.next=c;
        d.next=e;
        e.next=f;
        g.next=h;
        ListNode[] arr={a,d,g};
        ListNode head=mergeKLists(arr);
        display(head);
    }
}
