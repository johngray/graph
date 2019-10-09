package graph;

import java.util.*;

public class Path<V> {

    private final Set<V> path = new LinkedHashSet<>();

    public void addNext(V vertex) {
        path.add(vertex);
    }

    public List<V> getPath() {
        //A shallow copy of path
        return new LinkedList<>(path);
    }

    public boolean contains(V vertex) {
        return path.contains(vertex);
    }
}
