package Leetcode;

public class RemoveNthNodeFromEndofList19 {
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

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode(0);
        temp.next=head;
        ListNode first=temp;
        ListNode second=temp;
        for(int i=0;i<=n;i++)
        {
            second=second.next;
        }
        while (second!=null)
        {
            first=first.next;
            second=second.next;
        }
        first.next=first.next.next;
        return temp.next;
    }
    static void display(ListNode head)
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
        ListNode list=new ListNode();
        list= new ListNode(10);
        list.next=new ListNode(20);
        ListNode list2=new ListNode(30);
        list.next.next=list2;
        ListNode list3=new ListNode(40);
        list2.next=list3;
        list3.next=new ListNode(50);
        display(list);

        ListNode node=removeNthFromEnd(list,2);
        display(node);
    }
}
