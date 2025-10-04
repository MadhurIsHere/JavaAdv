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
                head.prev=node;
            }
            head=node;
        }
        public void insertEnd(int val)
        {
            Node node=new Node(val);
            // List is empty
            if(head==null) {
                head=node;
                node.prev=null;
                node.next=null;
                return;
            }
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=node;
            node.prev=temp;

        }
        public void display()
        {
            Node temp=head;
            while (temp!=null)
            {
                System.out.print(temp.val+" -> ");
                temp=temp.next;
            }
            System.out.println("END");
        }
        public void displayReverse()
        {
            Node node=head;
            Node last=null;
            while(node!=null)
            {
                last=node;
                node=node.next;
            }
            while(last!=null)
            {
                System.out.print(last.val+" -> ");
                last=last.prev;
            }
            System.out.println("Start");
        }

        public void addAtAny(int val,int pos)
        {
            Node node=new Node(val);
            // if List is empty
            if(head==null)
            {
                node.prev=null;
                node.next=null;
                head=node;
                return;
            }
            // if new node==head
            if(pos==0)
            {
                node.prev=null;
                node.next=head;
                head.prev=node;
                head=node;
                return;
            }
            int count=0;
            Node temp=head;
            while(count+1!=pos && temp.next!=null)
            {
                temp=temp.next;
                count++;
            }
            if(temp.next==null)
            {
                temp.next=node;
                node.prev=temp;
                node.next=null;
                return;
            }
            Node after=temp.next;
            temp.next=node;
            node.prev=temp;
            node.next=after;
            after.prev=node;
        }
        public void After(int val,int after)
        {
            Node node=new Node(val);
            Node temp=head;
            while(temp!=null)
            {
                if(temp.val==after)
                {
                    break;
                }
                temp=temp.next;
            }
            if(temp==null)
            {
                System.out.println("Node does not exist");
                return;
            }
            node.prev=temp;
            node.next=temp.next;
            if(node.next!=null) {
                temp.next.prev = node;
            }
            temp.next=node;
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
