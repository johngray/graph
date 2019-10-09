package graph.algo;

import graph.Graph;

import java.util.Set;
import java.util.function.Function;

public interface GraphAlgorithm<V, Request, Response> {
    Response apply(Function<V, Set<V>> edgesSupplier, Request request);
}
