package graph;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class BaseGraph<V> implements Graph<V> {

    protected final Map<V, Set<V>> graphConnections;

    protected BaseGraph() {
        this(10);
    }

    protected BaseGraph(int initialSize) {
        graphConnections = new ConcurrentHashMap<>(initialSize);
    }

    protected void assertVertexExists(V vertex) throws MissingVertexException {
        if (vertex == null) {
            throw new NullPointerException();
        }

        if (!graphConnections.containsKey(vertex)) {
            throw new MissingVertexException();
        }
    }
}
