package LinkedList.PracticeYT;
//import java.util.
public class DL {
    private Node head;
    private int size;
    DL()
    {
        size=0;
    }
    public void insertFirst(int val)
    {
        Node node=new Node(val);
        node.next=head;
        node.prev=null;
        if(head!=null)
        {
            head.prev=null;
        }
        head=node;
    }
    public void insertEnd(int val)
    {
        Node node=new Node(val);
        if(head==null) {
            head=node;
            node.prev=null;
            node.next=null;
        }
        Node temp=head;
        while(temp!=null)
        {
            temp=temp.next;
        }
        temp.next=node;
        node.prev=temp;
        node.next=null;
    }
    public void display()
    {
        Node temp=head;
        while (temp!=null)
        {
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    private class Node{
        int val;
        Node next;
        Node prev;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
