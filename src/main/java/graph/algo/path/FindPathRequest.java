package graph.algo.path;

public class FindPathRequest<V> {

    private final V source;

    private final V destination;

    public FindPathRequest(V source, V destination) {
        this.source = source;
        this.destination = destination;
    }

    public V getSource() {
        return source;
    }

    public V getDestination() {
        return destination;
    }
}
