package Graphs;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    public Map<Integer,Vertex> vertices;

    public Graph(){
        this.vertices=new HashMap<>();
    }

    public void addVertex(int label){
        vertices.putIfAbsent(label,new Vertex(label));
    }

    public void addEdge(int u,int v)
    {
        Vertex from=vertices.get(u);
        Vertex to= vertices.get(v);

        from.adj.add(to);
    }
}
