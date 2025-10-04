package Leetcode;

public class RotateList61 {
    static class ListNode{
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val,ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static void display(ListNode head)
    {
        ListNode temp=head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    public static ListNode rotateRight(ListNode head, int k) {
        int size=sizeof(head);
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy;
        ListNode fast=dummy;
        for(int i=0;i<k%size;i++)
        {
            fast=fast.next;
        }

        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        fast.next=head;

        head=slow.next;

        slow.next=null;
        return head;
    }

    private static int sizeof(ListNode head) {
        ListNode temp=head;
        int size=0;
        while (temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        ListNode list1=new ListNode(10);
        ListNode list2=new ListNode(20);
        ListNode list3=new ListNode(30);
        ListNode list4=new ListNode(40);
        ListNode list5=new ListNode(50);
        ListNode list6=new ListNode(60);
        list1.next=list2;
        list2.next=list3;
        list3.next=list4;
        list4.next=list5;
        list5.next=list6;
        display(list1);
        ListNode node=rotateRight(list1,2);
        display(node);
    }
}
