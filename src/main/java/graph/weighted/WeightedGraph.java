package graph.weighted;

import graph.Graph;
import graph.MissingVertexException;

public interface WeightedGraph<V> extends Graph<V> {

    void addEdge(V first, V second, double weight) throws MissingVertexException;
}
