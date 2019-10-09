package graph.undirected;

import graph.BaseGraph;
import graph.MissingVertexException;
import graph.Path;
import graph.algo.GraphAlgorithm;
import graph.algo.path.FindPathRequest;
import graph.algo.path.SimpleFindPathAlgorithm;
import graph.algo.path.UnreachableDestinationException;

import java.util.concurrent.ConcurrentHashMap;

public class UndirectedGraph<V> extends BaseGraph<V> {

    public UndirectedGraph() {
        super(10);
    }

    public UndirectedGraph(int initialSize) {
        super(initialSize);
    }

    @Override
    public void addVertex(V vertex) {
        graphConnections.putIfAbsent(vertex, ConcurrentHashMap.newKeySet());
    }

    @Override
    public void addEdge(V first, V second) throws MissingVertexException {
        assertVertexExists(first);
        assertVertexExists(second);

        graphConnections.computeIfPresent(first, (v, e) -> {
            e.add(second);
            return e;
        });

        graphConnections.computeIfPresent(second, (v, e) -> {
            e.add(first);
            return e;
        });
    }

    @Override
    public Path<V> getPath(V source, V destination) throws UnreachableDestinationException, MissingVertexException {
        assertVertexExists(source);
        assertVertexExists(destination);

        GraphAlgorithm<V, FindPathRequest<V>, Path<V>> pathGraphAlgorithm = new SimpleFindPathAlgorithm<>();

        return pathGraphAlgorithm.apply(graphConnections::get, new FindPathRequest<>(source, destination));
    }
}
