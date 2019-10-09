package graph

import graph.undirected.UndirectedGraph
import spock.lang.Specification

class UndirectedGraphSpecification extends Specification {

    def "Graph should return a path between two nodes"() {
        setup:
        def graph = new UndirectedGraph()

        def one = new SimpleVertex(1)
        def two = new SimpleVertex(2)
        def three = new SimpleVertex(3)
        def four = new SimpleVertex(4)

        graph.addVertex(one)
        graph.addVertex(two)
        graph.addVertex(three)
        graph.addVertex(four)

        graph.addEdge(one, two)
        graph.addEdge(two, four)
        graph.addEdge(four, three)
        graph.addEdge(three, one)

        when:
        def result = graph.getPath(one, four)

        then:
        result.getPath() == [one, two, four]
    }
}
