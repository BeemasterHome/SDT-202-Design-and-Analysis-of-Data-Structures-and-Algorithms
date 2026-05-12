package edu.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Directed graph represented with adjacency lists.
 * Vertices are integers from 0 to V - 1.
 */
public class Digraph {
    private final int vertices;
    private int edges;
    private final List<List<Integer>> adj;

    public Digraph(int vertices) {
        if (vertices < 0) {
            throw new IllegalArgumentException("Number of vertices cannot be negative.");
        }
        this.vertices = vertices;
        this.edges = 0;
        this.adj = new ArrayList<>();
        for (int v = 0; v < vertices; v++) {
            adj.add(new ArrayList<>());
        }
    }

    public int V() {
        return vertices;
    }

    public int E() {
        return edges;
    }

    public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        adj.get(v).add(w);
        edges++;
    }

    public Iterable<Integer> adj(int v) {
        validateVertex(v);
        return Collections.unmodifiableList(adj.get(v));
    }

    public Digraph reverse() {
        Digraph reversed = new Digraph(vertices);
        for (int v = 0; v < vertices; v++) {
            for (int w : adj(v)) {
                reversed.addEdge(w, v);
            }
        }
        return reversed;
    }

    private void validateVertex(int v) {
        if (v < 0 || v >= vertices) {
            throw new IllegalArgumentException("Vertex " + v + " is outside range 0.." + (vertices - 1));
        }
    }
}
