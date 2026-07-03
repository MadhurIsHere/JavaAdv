package Graphs;

public class Main {
    public static void main(String[] args) {

        Graph g = new Graph();

        g.addVertex(0);
        g.addVertex(1);
        g.addVertex(2);
        g.addVertex(3);
        g.addVertex(4);
        g.addVertex(5);
        g.addVertex(6);


//        g.addEdge(0, 1);
//        g.addEdge(0, 2);
//        g.addEdge(1, 3);
//        g.addEdge(2, 4);
//        g.addEdge(3, 4);


        g.addEdge(0, 1);
        g.addEdge(1, 2);
//        g.addEdge(1,3);
        g.addEdge(2, 3);


        Vertex source = g.vertices.get(0);
        System.out.println(Cycle.isCycle(source, g));
    }
}