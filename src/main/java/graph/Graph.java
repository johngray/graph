package graph;

import graph.algo.path.UnreachableDestinationException;

public interface Graph<V> {

    void addVertex(V vertex);

    void addEdge(V first, V second) throws MissingVertexException;

    Path<V> getPath(V source, V destination) throws UnreachableDestinationException, MissingVertexException;
}
