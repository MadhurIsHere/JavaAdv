package LinkedList;

public class ReverseList {
    static class Node{
        int val;
        Node next;
        Node() {}
        Node(int val) {this.val=val;}
        Node(int val,Node next) {
            this.val = val;
            this.next = next;
        }
    }
    static Node ReverseList(Node head)
    {
        Node curr=head;
        Node prev=null;

        while(curr!=null)
        {
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    static void print(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.val+"->");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    public static void main(String[] args) {
        Node first=new Node(100);
        Node second=new Node(200);
        Node third=new Node(300);
        Node fourth=new Node(400);

        // join them
        first.next=second;
        second.next=third;
        third.next=fourth;

        print(first);

        Node newHead=ReverseList(first);
        print(newHead);
    }
}
