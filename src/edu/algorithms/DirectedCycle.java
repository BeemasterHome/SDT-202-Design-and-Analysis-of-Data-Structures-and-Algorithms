package edu.algorithms;

import edu.graph.Digraph;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Detects directed cycles using DFS and an onStack array.
 */
public class DirectedCycle {
    private final boolean[] marked;
    private final boolean[] onStack;
    private final int[] edgeTo;
    private Deque<Integer> cycle;

    public DirectedCycle(Digraph graph) {
        marked = new boolean[graph.V()];
        onStack = new boolean[graph.V()];
        edgeTo = new int[graph.V()];

        for (int v = 0; v < graph.V(); v++) {
            if (!marked[v] && !hasCycle()) {
                dfs(graph, v);
            }
        }
    }

    private void dfs(Digraph graph, int v) {
        onStack[v] = true;
        marked[v] = true;

        for (int w : graph.adj(v)) {
            if (hasCycle()) {
                return;
            }
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(graph, w);
            } else if (onStack[w]) {
                cycle = new ArrayDeque<>();
                for (int x = v; x != w; x = edgeTo[x]) {
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;
    }

    public boolean hasCycle() {
        return cycle != null;
    }

    public Iterable<Integer> cycle() {
        return cycle;
    }
}
