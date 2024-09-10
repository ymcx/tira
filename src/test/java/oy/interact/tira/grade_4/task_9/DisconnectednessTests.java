package oy.interact.tira.grade_4.task_9;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.student.graph.Graph;
import oy.interact.tira.student.graph.Vertex;

import oy.interact.tira.IntegerTestGraph;
import oy.interact.tira.StringTestGraph;

/**
 * Basic unit tests for the Graph class.
 * Tests if the graph has the vertices and edges it should have.
 */
public class DisconnectednessTests {

    static List<?> notVisited;

    @Test 
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testConnectedUndirectedGraph()
    {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleUndirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created though it should have");
        assertDoesNotThrow(() -> notVisited = testGraph.disconnectedVertices(null));
        assertTrue(notVisited.isEmpty(), () -> "This graph should be connected and not visited list should be then empty");
    }

    @Test 
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testConnectedDirectedGraph()
    {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleDirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");
        // We know the graph structure and know that from vertex 1 you can get to all places in this directed graph.
        Vertex<Integer> startVertex = testGraph.getVertexFor(1);
        assertNotNull(startVertex, "Turku should be in the train network as a vertex");
        assertDoesNotThrow(() -> notVisited = testGraph.disconnectedVertices(startVertex));
        assertTrue(notVisited.isEmpty(), () -> "This graph should be connected and not visited list should be then empty");
    }

    @Test 
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testDisconnectedUndirectedGraph()
    {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleUndirectedDisconnectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");
        assertDoesNotThrow(() -> notVisited = testGraph.disconnectedVertices(null));
        assertFalse(notVisited.isEmpty(), () -> "This graph should be disconnected");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testFinnishTrainStationsGraph() {
        Graph<String> testGraph = StringTestGraph.createFinlandTrainNetworks();
        assertNotNull(testGraph, "Test graph not created");
        assertDoesNotThrow(() -> notVisited = testGraph.disconnectedVertices(null));
        assertTrue(notVisited.isEmpty(), () -> "This graph should NOT be disconnected");
    }

}
