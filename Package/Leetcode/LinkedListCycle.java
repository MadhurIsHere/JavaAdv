package Leetcode;

import java.util.HashMap;
import java.util.Map;

public class LinkedListCycle {
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
    public static boolean hasCycle(ListNode head) {
        Map<ListNode,Integer> map=new HashMap<ListNode,Integer>();
        ListNode temp=head;
        while (temp!=null)
        {
            if(map.containsKey(temp)) return false;
            map.put(temp,1);
            temp=temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode a=new ListNode(1);
        ListNode b=new ListNode(2);
        ListNode c=new ListNode(3);
        ListNode d=new ListNode(4);
        ListNode e=new ListNode(5);
        ListNode f=new ListNode(6);
        ListNode g=new ListNode(7);
        ListNode h=new ListNode(8);

        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        f.next=g;
        g.next=h;
//        h.next=c;

        System.out.println(hasCycle(a));
    }
}
