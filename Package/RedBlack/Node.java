package RedBlack;

enum Color{Red,Black}
public class Node {
    int val;
    Color color;
    Node left,right,parent;

    public Node(int val) {
        this.val = val;
        color=Color.Red;
    }
}
