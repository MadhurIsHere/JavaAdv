package Leetcode;

public class SwappingNodesinaLinkedList1721 {
    static class ListNode {
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

    public static ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) return head;
        ListNode dummy = head;
        int size = 0;
        while (dummy != null) {
            size++;
            dummy = dummy.next;
        }
        int[] arr = new int[size];
        int i = 0;
        dummy = head;
        while (dummy != null) {
            arr[i++] = dummy.val;
            dummy = dummy.next;
        }
        int temp = arr[k - 1];
        arr[k - 1] = arr[size - k];
        arr[size - k] = temp;
        head = new ListNode(arr[0]);
        dummy = head;
        for (i = 1; i < size; i++) {
            ListNode curr = new ListNode(arr[i]);
            dummy.next = curr;
            dummy = dummy.next;
        }
        return head;
    }

    static void display(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        display(a);
        a = swapNodes(a, 2);
        display(a);
    }
}
