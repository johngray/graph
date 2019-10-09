package graph.algo.path;

import graph.Path;
import graph.algo.GraphAlgorithm;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SimpleFindPathAlgorithm<V> implements GraphAlgorithm<V, FindPathRequest<V>, Path<V>> {

    @Override
    public Path<V> apply(Function<V, Set<V>> edgesSupplier, FindPathRequest<V> request) {
        V source = request.getSource();
        V destination = request.getDestination();

        if (source.equals(destination)) {
            Path<V> path = new Path<>();
            path.addNext(source);
            path.addNext(destination);
            return path;
        }

        Deque<V> searchStack = new LinkedList<>();
        searchStack.push(source);
        Set<V> visited = new HashSet<>();
        visited.add(source);

        while(!searchStack.isEmpty()) {
            V node = searchStack.getFirst();
            Set<V> edges = edgesSupplier.apply(node);
            Set<V> nonVisitedChildren = getNonVisitedChildren(visited, edges);

            if (nonVisitedChildren.contains(destination)) {
                searchStack.push(destination);
                return extractPath(searchStack);
            }

            nonVisitedChildren.forEach((child) -> {
                assertNoCyclesDetected(source, child);
                visited.add(child);
                searchStack.push(child);
            });

            searchStack.pop();
        }

        throw new UnreachableDestinationException();
    }

    private void assertNoCyclesDetected(V source, V nonVisitedChild) {
        if (nonVisitedChild.equals(source)) {
            throw new RuntimeException("A cycle detected");
        }
    }

    private Path<V> extractPath(Deque<V> searchStack) {
        Path<V> path = new Path<>();

        Iterator<V> stackDescendingIterator = searchStack.descendingIterator();
        while(stackDescendingIterator.hasNext()) {

            path.addNext(stackDescendingIterator.next());
        }
        return path;
    }

    private Set<V> getNonVisitedChildren(Set<V> visited, Set<V> edges) {
        return edges.stream().filter(e -> !visited.contains(e)).collect(Collectors.toSet());
    }
}
