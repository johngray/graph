package graph

import graph.directed.DirectedGraph
import spock.lang.Specification

class DirectGraphSpecification extends Specification {

    def "Graph should return a path between two nodes"() {
        setup:
        def graph = new DirectedGraph()

        def one = new SimpleVertex(1)
        def two = new SimpleVertex(2)
        def three = new SimpleVertex(3)
        def four = new SimpleVertex(4)

        graph.addVertex(one)
        graph.addVertex(two)
        graph.addVertex(three)
        graph.addVertex(four)

        graph.addEdge(one, two)
        graph.addEdge(one, four)
        graph.addEdge(two, three)
        graph.addEdge(three, one)

        when:
        def result = graph.getPath(one, three)

        then:
        result.getPath() == [one, two, three]
    }
}
