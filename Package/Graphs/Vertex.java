package Graphs;

import java.util.ArrayList;
import java.util.List;

enum Color {WHITE, GRAY, BLACK}

public class Vertex {
    int label;
    Color color;
    int d;
    Vertex pi;
    List<Vertex> adj;

    public Vertex(int label) {
        this.label = label;
        this.color = Color.WHITE;
        this.d = Integer.MAX_VALUE;
        this.pi = null;
        this.adj = new ArrayList<>();
    }
}
