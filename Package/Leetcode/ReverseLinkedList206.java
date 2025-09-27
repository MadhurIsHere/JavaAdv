package Leetcode;

import java.io.Flushable;

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
public class ReverseLinkedList206 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val)
        {
            this.val=val;
        }
        ListNode(int val,ListNode next)
        {
            this.val=val;
            this.next=next;
        }
    }
    public static ListNode reverseList(ListNode head) {
        ListNode curr=head;
        ListNode prev=null;

        while(curr!=null)
        {
            ListNode next=curr.next ;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    static void printList(ListNode head){
        ListNode temp=head;
        while(temp!=null)
        {
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        ListNode first=new ListNode(10);
        ListNode second=new ListNode(20);
        ListNode third =new ListNode(30);
        ListNode fourth=new ListNode(40);

        first.next=second;
        second.next=third;
        third.next=fourth;

        printList(first);

        ListNode newlist=reverseList(first);
        printList(newlist);
    }
}
