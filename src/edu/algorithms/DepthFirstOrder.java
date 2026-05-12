package edu.algorithms;

import edu.graph.Digraph;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Computes reverse postorder of a directed graph.
 */
public class DepthFirstOrder {
    private final boolean[] marked;
    private final Deque<Integer> reversePost;

    public DepthFirstOrder(Digraph graph) {
        marked = new boolean[graph.V()];
        reversePost = new ArrayDeque<>();

        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        marked[v] = true;
        for (int w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }
        reversePost.push(v);
    }

    public Iterable<Integer> reversePost() {
        return reversePost;
    }
}
