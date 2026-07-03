package RedBlack;

public class Insertion {
    void inertion(Node root, int key) {
        Node temp = root;
        Node parent = null;
        Node node = new Node(key);
        while (temp != null) {
            parent = temp;
            if (temp.val < key) {
                temp = temp.right;
            } else {
                temp = temp.left;
            }
        }
        node.parent = parent;
        if (parent == null) {
            root = node;
        } else if (key < parent.val) {
            parent.left = node;
        } else {
            parent.right = node;
        }


    }
}



