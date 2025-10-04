package LinkedList.PracticeYT;

public class Main {
    public static void main(String[] args) {
//        LL list=new LL();
//        list.insertEnd(1);
//        list.insertEnd(2);
//        list.insertEnd(3);
//        list.insertEnd(4);
//        list.insertEnd(5);
//        list.addAtAny(100,2);
//        list.display();
//        System.out.println(list.getsize());
//        list.deletelast();
//        list.deletefirst();
//        int node=  list.getValueAt(0);
//        System.out.println(node);
//        list.display();
//        System.out.println(list.getsize());
//        System.out.println(list.deleteAtAny(2));
//        list.display();
//        System.out.println(list.getsize());
//        System.out.println(list.deleteAtAny(4));
//        list.display();
        DL list=new DL();
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertFirst(4);
        list.insertFirst(5);
        list.display();
        list.insertEnd(100);
        list.displayReverse();
        list.addAtAny(20,0);
        list.display();
        list.addAtAny(30,7);
        list.addAtAny(20,21312);
        list.display();
        list.After(120,100);
        list.display();
//        DL neww=new DL();
//        neww.insertEnd(23);
//        neww.addAtAny(20,0);
//        neww.display();
//
    }
}
