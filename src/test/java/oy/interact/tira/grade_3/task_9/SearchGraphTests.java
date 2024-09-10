package oy.interact.tira.grade_3.task_9;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import oy.interact.tira.student.graph.Graph;
import oy.interact.tira.student.graph.Vertex;
import oy.interact.tira.IntegerTestGraph;
import oy.interact.tira.StringTestGraph;

class SearchGraphTests {

    private static List<Vertex<Integer>> bfsDirectedFrom1;
    private static List<Vertex<Integer>> dfsDirectedFrom1;
    private static List<Vertex<String>> bfsUndirectedFromOulu;
    private static List<Vertex<String>> dfsUndirectedFromOulu;
    
    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testBreadthFirstSearchUndirectedFrom1() {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleUndirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");

        List<Vertex<Integer>> bfsResult = testGraph.doBreadthFirstSearch(testGraph.getVertexFor(1));
        System.out.println("BFS undirected from 1:");
        for (Vertex<Integer> vertex : bfsResult) {
            System.out.format("Vertex: %s%n", vertex.getElement());
        }
        assertEquals(5, bfsResult.size(), () -> "BFS should find all vertices from the test graph");
        Set<Vertex<Integer>> allVertices = testGraph.getVertices();
        assertTrue(new HashSet<>(bfsResult).equals(new HashSet<>(allVertices)),
                () -> "BFS result set and all vertices should be equal with test graph");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testBreadthFirstSearchUndirectedFrom4() {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleUndirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");
        List<Vertex<Integer>> bfsResult = testGraph.doBreadthFirstSearch(testGraph.getVertexFor(4));
        System.out.println("BFS undirected from 4:");
        for (Vertex<Integer> vertex : bfsResult) {
            System.out.format("Vertex: %s%n", vertex.getElement());
        }
        assertEquals(5, bfsResult.size(), () -> "BFS should find all vertices from the test graph");
        Set<Vertex<Integer>> allVertices = testGraph.getVertices();
        assertTrue(new HashSet<>(bfsResult).equals(new HashSet<>(allVertices)),
                () -> "BFS result set and all vertices should be equal with test graph");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testDepthFirstSearchUndirectedFrom1() {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleUndirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");

        List<Vertex<Integer>> dfsResult = testGraph.doDepthFirstSearch(testGraph.getVertexFor(1));
        System.out.println("DFS undirected from 1:");
        for (Vertex<Integer> vertex : dfsResult) {
            System.out.format("Vertex: %s%n", vertex.getElement());
        }
        assertEquals(5, dfsResult.size(), () -> "DFS should find all vertices from the test graph");
        Set<Vertex<Integer>> allVertices = testGraph.getVertices();
        assertTrue(new HashSet<>(dfsResult).equals(new HashSet<>(allVertices)),
                () -> "DFS result set and all vertices should be equal with test graph");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testDepthFirstSearchUndirectedFrom4() {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleUndirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");

        List<Vertex<Integer>> dfsResult = testGraph.doDepthFirstSearch(testGraph.getVertexFor(4));
        System.out.println("DFS undirected from 4:");
        for (Vertex<Integer> vertex : dfsResult) {
            System.out.format("Vertex: %s%n", vertex.getElement());
        }
        assertEquals(5, dfsResult.size(), () -> "DFS should find all vertices from the test graph");
        Set<Vertex<Integer>> allVertices = testGraph.getVertices();
        assertTrue(new HashSet<>(dfsResult).equals(new HashSet<>(allVertices)),
                () -> "DFS result set and all vertices should be equal with test graph");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testBreadthFirstSearchDirectedFrom1() {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleDirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");

        List<Vertex<Integer>> bfsResult = testGraph.doBreadthFirstSearch(testGraph.getVertexFor(1));
        bfsDirectedFrom1 = bfsResult;

        Set<Vertex<Integer>> allVertices = testGraph.getVertices();
        System.out.println("BFS directed from 1:");
        for (Vertex<Integer> vertex : bfsResult) {
            System.out.format("Vertex: %s%n", vertex.getElement());
        }
        assertEquals(5, bfsResult.size(), () -> "BFS should find four vertices from the test graph");
        assertTrue(new HashSet<>(bfsResult).equals(new HashSet<>(allVertices)),
                () -> "BFS result set and all vertices but vertex 1 missing should be equal with test graph");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testBreadthFirstSearchDirectedFrom4() {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleDirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");

        List<Vertex<Integer>> bfsResult = testGraph.doBreadthFirstSearch(testGraph.getVertexFor(4));

        Set<Vertex<Integer>> allVertices = testGraph.getVertices();
        System.out.println("BFS directed from 4:");
        for (Vertex<Integer> vertex : bfsResult) {
            System.out.format("Vertex: %s%n", vertex.getElement());
        }
        assertEquals(4, bfsResult.size(), () -> "BFS should find four vertices from the test graph");
        Vertex<Integer> notFound = testGraph.getVertexFor(1);
        allVertices.remove(notFound);
        assertTrue(new HashSet<>(bfsResult).equals(new HashSet<>(allVertices)),
                () -> "BFS result set and all vertices but vertex 1 missing should be equal with test graph");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testDepthFirstSearchDirectedFrom1() {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleDirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");

        List<Vertex<Integer>> dfsResult = testGraph.doDepthFirstSearch(testGraph.getVertexFor(1));
        dfsDirectedFrom1 = dfsResult;

        Set<Vertex<Integer>> allVertices = testGraph.getVertices();
        System.out.println("DFS directed from 1:");
        for (Vertex<Integer> vertex : dfsResult) {
            System.out.format("Vertex: %s%n", vertex.getElement());
        }
        assertEquals(5, dfsResult.size(), () -> "DFS should find all vertices from the test graph");
        assertTrue(new HashSet<>(dfsResult).equals(new HashSet<>(allVertices)),
                () -> "DFS result set and all vertices but vertex 1 missing should be equal with test graph");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testDepthFirstSearchDirectedFrom4() {
        IntegerTestGraph testGraph = IntegerTestGraph.createSimpleDirectedGraph();
        assertNotNull(testGraph, () -> "Test graph not created");

        List<Vertex<Integer>> dfsResult = testGraph.doDepthFirstSearch(testGraph.getVertexFor(4));

        System.out.println("DFS directed from 4:");
        for (Vertex<Integer> vertex : dfsResult) {
            System.out.format("Vertex: %s%n", vertex.getElement());
        }
        assertEquals(4, dfsResult.size(), () -> "DFS should find all vertices from the test graph");
        Set<Vertex<Integer>> allVertices = testGraph.getVertices();
        Vertex<Integer> notFound = testGraph.getVertexFor(1);
        allVertices.remove(notFound);
        assertTrue(new HashSet<>(dfsResult).equals(new HashSet<>(allVertices)),
                () -> "DFS result set and all vertices but vertex 1 missing should be equal with test graph");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testTrainStationsBFS() {
        Graph<String> testGraph = StringTestGraph.createFinlandTrainNetworks();
        assertNotNull(testGraph, "Test graph not created");
        System.out.format("Stations in network: %d%n", testGraph.getVertices().size());
        List<Vertex<String>> bfsResult = testGraph.breadthFirstSearch(testGraph.getVertexFor("Oulu"), null);
        System.out.println("Order of stations as visited by BFS:");
        System.out.println(Arrays.toString(bfsResult.toArray()));
        bfsUndirectedFromOulu = bfsResult;
        assertEquals(10, bfsResult.size(), () -> "DFS should find all vertices from the test graph");

        Set<Vertex<String>> allVertices = testGraph.getVertices();
        assertTrue(new HashSet<>(bfsResult).equals(new HashSet<>(allVertices)),
                () -> "DFS result set and all vertices should be equal with test graph");
    }

    @Test
    // @Timeout(value = 60, threadMode = Timeout.ThreadMode.SEPARATE_THREAD)
    void testTrainStationsDFS() {
        Graph<String> testGraph = StringTestGraph.createFinlandTrainNetworks();
        assertNotNull(testGraph, "Test graph not created");
        System.out.format("Stations in network: %d%n", testGraph.getVertices().size());
        List<Vertex<String>> dfsResult = testGraph.depthFirstSearch(testGraph.getVertexFor("Oulu"), null);
        System.out.println("Order of stations as visited by DFS:");
        System.out.println(Arrays.toString(dfsResult.toArray()));
        dfsUndirectedFromOulu = dfsResult;
        assertEquals(10, dfsResult.size(), () -> "DFS should find all vertices from the test graph");

        Set<Vertex<String>> allVertices = testGraph.getVertices();
        assertTrue(new HashSet<>(dfsResult).equals(new HashSet<>(allVertices)),
                () -> "DFS result set and all vertices should be equal with test graph");
    }

    @AfterAll
    @Test
    static void testDFSBFSDiffer() {
        if (bfsDirectedFrom1 == null || dfsDirectedFrom1 == null ||
            bfsUndirectedFromOulu == null || dfsUndirectedFromOulu == null)
        {
            System.out.println("Can work out difference of DFS and BFS if all tests executed");
            return;
        }
        System.out.println("BFS and DFS paths should be different. Let's see (bfs, then dfs)...");
        System.out.println(Arrays.toString(bfsDirectedFrom1.toArray()));
        System.out.println(Arrays.toString(dfsDirectedFrom1.toArray()));
        System.out.println("BFS and DFS train paths should be different. Let's see (bfs, then dfs)...");
        System.out.println(Arrays.toString(bfsUndirectedFromOulu.toArray()));
        System.out.println(Arrays.toString(dfsUndirectedFromOulu.toArray()));
        assertTrue(!bfsDirectedFrom1.equals(dfsDirectedFrom1),
                "BFS and DFS produced the same path, so are basically the same search.");
        assertTrue(!bfsUndirectedFromOulu.equals(dfsUndirectedFromOulu),
                "BFS and DFS produced the same path, so are basically the same search.");
    }

}
