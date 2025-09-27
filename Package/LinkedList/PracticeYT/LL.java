package LinkedList.PracticeYT;

public class LL {
    // head,tail,size can be used in this class showing encapsulization
    private Node head;
    private Node tail;
    private int size;

    LL()
    {
        this.size=0;
    }
    // operation 1
    public void inserFirst(int val)
    {
        Node node=new Node(val);  // create a new node
        node.next=head;           // for next element the next should have the value of prev
        head=node;                // head updated to node
        if(tail==null)
        {
            tail=head;
        }
        size++;
    }
    // operation 2
    public void insertEnd(int val)
    {
        if(tail==null)
        {
            inserFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }
    // operation 3
    public void addAtAny(int val,int size)
    {
        if(size==0){
            inserFirst(val);
            return;
        }
        int count=0;
        Node temp=head;
        while(count+1!=size)
        {
            temp=temp.next;
            count++;
        }
        Node node =new Node(val);
        node.next=temp.next;
        temp.next=node;
        this.size++;
    }
    // operation 4
    public int deletefirst()
    {
        int val=head.val;
        head=head.next;
        if(head==null)
        {
            tail=null;
        }
        size--;
        return val;
    }
    // operation 5
    public int deletelast()
    {
        if(size<2){
            return deletefirst();
        }
        Node node=get(size-2);
        int val=node.next.val;
        tail=node;
        tail.next=null;
        size--;
        return val;
    }
    // operation 6 helping in operation 5 and 7
    public Node get(int index)
    {
        Node node =head;
        int i=0;
        while(i<index)
        {
            node=node.next;
            i++;
        }
        return node;
    }
    // operation 7
    public int deleteAtAny(int index)
    {
        if(size==0) return deletefirst();
        if(index==size-1 ) return deletelast();
        if(index>size-1) return -1;
        Node node =get(index-1);
        int val=node.next.val;
        node.next=node.next.next;
        size--;
        return val;
    }
    // operation 8
    public Node find(int val)
    {
        Node node =head;
        while(node!=null)
        {
            if(node.val==val)
                return node;
            node=node.next;
        }
        return null;
    }
    // operation last
    public void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("null");
    }
    // Node class with its constructors
    private static class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val,Node next) {
            this.val=val;
            this.next = next;
        }
    }
    // methods to get the values of all private binding/variables

    public int getValueAt(int index) {
        Node node = get(index);  // private Node is still accessible here
        return node.val;         // allowed inside LL
    }

    public int getHeadValue() {
        if (head == null) throw new IllegalStateException("List is empty");
        return head.val;
    }

    public int getTailValue() {
        if (tail == null) throw new IllegalStateException("List is empty");
        return tail.val;
    }
    public int getsize()
    {
        return size;
    }
}
