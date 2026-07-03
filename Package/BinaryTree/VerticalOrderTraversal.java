package BinaryTree;

import java.util.*;

class Ds {
    TreeNode node;
    int x;
    int y;

    Ds(TreeNode node, int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }

}

public class VerticalOrderTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Ds> q = new LinkedList<Ds>();
        q.offer(new Ds(root, 0, 0));
        while (!q.isEmpty()) {
            Ds ds = q.poll();
            TreeNode node = ds.node;
            int x = ds.x;
            int y = ds.y;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }

            map.get(x).get(y).offer(node.val);
            if (node.left != null) {
                q.offer(new Ds(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Ds(node.right, x + 1, y + 1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> entry : map.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> node : entry.values()) {
                while (!node.isEmpty()) {
                    res.get(res.size() - 1).add(node.poll());
                }
            }
        }
        return res;
    }
}
