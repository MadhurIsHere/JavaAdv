package Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class Cycle {
    static boolean isCycle(Vertex s, Graph g) {
        for (Vertex v : g.vertices.values()) {
            v.color = Color.WHITE;
            v.d = Integer.MAX_VALUE;
            v.pi = null;
        }

        s.color = Color.GRAY;
        s.d = 0;

        Queue<Vertex> q = new LinkedList<>();
        q.offer(s);
        while (!q.isEmpty()) {
            Vertex u = q.poll();

            for (Vertex v : u.adj) {
                if (v.color == Color.WHITE) {
                    v.color = Color.GRAY;
                    v.d = u.d + 1;
                    v.pi = u;
                    q.add(v);
                } else if (v != u.pi) {
                    return true;
                }
            }

            u.color = Color.BLACK;
        }
        return false;
    }
}
