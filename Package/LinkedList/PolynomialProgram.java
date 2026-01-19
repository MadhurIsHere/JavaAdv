package LinkedList;

import java.sql.PreparedStatement;

public class PolynomialProgram {
    static class Node {
        int coeff;
        int pow;
        Node next;

        Node () {}
        Node(int c, int p) {
            coeff = c;
            pow = p;
            next = null;
        }
    }
    static Node addTerms(Node head,int coeff,int pow)
    {
        Node node=new Node(coeff,pow);
        if(head==null)
        {
            head=node;
            return head;
        }
        if(pow>head.pow)
        {
            node.next=head;
            head=node;
            return head;
        }
        Node temp=head;
        Node prev=null;
        while(temp!=null && temp.pow>=pow)
        {
            prev=temp;
            temp=temp.next;
        }
        node.next=prev.next;
        prev.next=node;
        return head;
    }
    static Node add(Node p1,Node p2){
        Node dummy=new Node();
        Node a=p1;
        Node b=p2;
        while (a!=null && b!=null)
        {
            if(a.pow==b.pow)
            {
                dummy=addTerms(dummy,a.coeff+b.coeff,a.pow);
                a=a.next;
                b=b.next;
            }
            else if(a.pow>b.pow)
            {
                dummy=addTerms(dummy,a.coeff,a.pow);
                a=a.next;
            }
            else
            {
                dummy=addTerms(dummy,b.coeff,b.pow);
                b=b.next;
            }
        }
        while (a!=null)
        {
            dummy=addTerms(dummy,a.coeff,a.pow);
            a=a.next;
        }
        while(b!=null)
        {
            dummy=addTerms(dummy,b.coeff,b.pow);
            b=b.next;
        }
        return dummy;
    }
    static void display(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.coeff+"x^"+temp.pow+" ");
            temp=temp.next;
        }
        System.out.println("End");
    }
    public static void main(String[] args) {
        Node p1 = new Node(5, 3);
        p1.next = new Node(4, 2);
        p1.next.next = new Node(0, 1);
        p1.next.next.next = new Node(2, 0);

        // -------- Polynomial 2 : 3x^3 + x^1 + 7 --------
        Node p2 = new Node(3, 3);
        p2.next = new Node(0, 2);
        p2.next.next = new Node(1, 1);
        p2.next.next.next = new Node(7, 0);

        System.out.println("Polynomial 1:");
        display(p1);

        System.out.println("Polynomial 2:");
        display(p2);

        // Add both polynomials
        Node sum = add(p1, p2);

        System.out.println("Sum:");
        display(sum);
    }
}
