package edu.algorithms;

import edu.graph.Digraph;

/**
 * Topological sorting for a directed acyclic graph.
 */
public class Topological {
    private Iterable<Integer> order;

    public Topological(Digraph graph) {
        DirectedCycle cycleFinder = new DirectedCycle(graph);
        if (!cycleFinder.hasCycle()) {
            DepthFirstOrder dfs = new DepthFirstOrder(graph);
            order = dfs.reversePost();
        }
    }

    public Iterable<Integer> order() {
        return order;
    }

    public boolean isDAG() {
        return order != null;
    }
}
