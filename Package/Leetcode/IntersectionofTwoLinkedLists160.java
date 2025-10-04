package Leetcode;

public class IntersectionofTwoLinkedLists160 {
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
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a=headA;
        ListNode b=headB;
        while(a!=b)
        {
            a= (a==null) ? headB : a.next;
            b= (b==null) ? headA : b.next;
        }
        return a;
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
        ListNode one=new ListNode(10);
        ListNode two=new ListNode(20);
        ListNode three=new ListNode(30);
        ListNode fourth=new ListNode(40);
        ListNode fifth=new ListNode(50);
        ListNode sixth=new ListNode(60);
        ListNode seventh=new ListNode(70);
        ListNode eighth=new ListNode(80);

        one.next=two;
        two.next=three;
        three.next=fourth;
        fourth.next=eighth;

        fifth.next=sixth;
        sixth.next=seventh;
        seventh.next=fourth;
        fourth.next=eighth;
        display(one);
        display(fifth);

        System.out.println(getIntersectionNode(one,fifth).val);
    }
}
