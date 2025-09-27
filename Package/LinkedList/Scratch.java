package LinkedList;

class Node{
    int data;
    Node next;
    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }
}
class MyLinkedList
{
    Node head;
    public void add(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
        }
        else {
            Node current = head;
            while(current.next!=null)
            {
                current=current.next;
            }
            current.next=newNode;
        }

    }

    public void printList() {
        Node current=head;
    System.out.println("Linked list ");
    while (current!=null)
    {
        System.out.print(current.data+" --> ");
        current=current.next;
    }
        System.out.println("null");
    }
}
public class Scratch {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.add(10);
        list.add(20);
        list.add(30);
        list.printList();
    }
}

