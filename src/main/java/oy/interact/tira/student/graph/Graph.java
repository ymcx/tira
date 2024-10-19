package oy.interact.tira.student.graph;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import oy.interact.tira.NotYetImplementedException;
import oy.interact.tira.student.graph.Edge.EdgeType;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

/**
 * Implementation of the graph data structure and associated algorithms.
 * <p>
 * This abstract class implements the graph data structure and various
 * algorithms like breadth-first search, depth-first search and the Dijkstra
 * path finding algorithm.
 * <p>
 * The class needs your attention, dear student. Implement the methods
 * marked TODO in the comments, based on what you have learned about
 * graphs.
 * <p>
 * The Graph as a generic (template) class can use any data types conforming to 
 * the Comparable interface.
 * <p>
 * This implementation uses edge lists to store the graph vertices
 * and edges.
 * 
 * @author Antti Juustila
 * @version 1.0
 */
public class Graph<T> {

   /** TODO: The edge list of the graph. Select and instantiate
    * a suitable type of Map, depending on application needs.
    */
   Map<Vertex<T>, List<Edge<T>>> edgeList;
   Map<Integer, List<Vertex<T>>> vertices;
   
   /**
    * Constructor instantiates a suitable Map data structure
    * depending on the application requirements.
    */
   public Graph() {
      edgeList = new HashMap<Vertex<T>, List<Edge<T>>>();
      vertices = new Hashtable<Integer, List<Vertex<T>>>();
   }

   /**
    * Creates a vertex holding the dataItem (node in a vertex) in the graph.
    * Use this method always to add vertices to the graph.
    *
    * Create the vertex object with the data item, then create an empty
    * list of edges, and put the vertex and the empty list to the Map.
    *
    * The newly created vertex must have an empty list of edges.
    * 
    * @param element The data item to put in the vertex of the graph.
    * @return Returns the created vertex, placed in the graph's edge list.
    */
   public Vertex<T> createVertexFor(T element) {
      Vertex<T> vertex = new Vertex<>(element);
      edgeList.put(vertex, new ArrayList<>());
      int hash = element.hashCode();
      if (vertices.get(hash) == null) {
        vertices.put(hash, new ArrayList<>());
      }
      vertices.get(hash).add(vertex);
      return vertex;
   }

   /**
    * Get all the vertices of the graph in a Set.

    * @return A Set with all the vertices of the graph.
    */
   public Set<Vertex<T>> getVertices() {
      return new HashSet<>(edgeList.keySet());
   }

   /**
    * Adds an edge to the graph. Note that the vertices MUST have been created 
    * earlier by calling {@code createVertexFor(T)} and are already in the graph.
    *
    * @param type The type of the edge, either directed or undirected.
    * @param source The source vertex of the edge.
    * @param destination The destination vertex of the edge.
    * @param weight The weight of the edge.
    */
   public void addEdge(Edge.EdgeType type, Vertex<T> source, Vertex<T> destination, double weight) {
     if (type == EdgeType.UNDIRECTED) {
       addDirectedEdge(destination, source, weight);
     }
     addDirectedEdge(source, destination, weight);
   }

   /**
    * Adds a directed edge to the graph. Note that the vertices MUST have been created 
    * earlier by calling  {@code createVertexFor(T)}.
    *
    * @param source The source vertex of the edge.
    * @param destination The destination vertex of the edge.
    * @param weight The weight of the edge.
    */
   public void addDirectedEdge(Vertex<T> source, Vertex<T> destination, double weight) {
     List<Edge<T>> list = edgeList.get(source);
     if (list == null) {
       source = createVertexFor(source.getElement());
       list = edgeList.get(source);
     }
     list.add(new Edge<>(source, destination, weight));
   }

   /**
    * Gets the edges of the specified vertex. The vertex must be
    * already in the graph.
    *
    * @param source The vertex edges of which we wish to get.
    * @return Returns the edges of the vertex or an empty list if no edges from the source.
    */
   public List<Edge<T>> getEdges(Vertex<T> source) {
      List<Edge<T>> list = edgeList.get(source);
      if (list == null) {
        list = new ArrayList<>();
      }
      return list;
   }

   /**
    * Gets a vertex for the specified node (contents) in a vertex, if found.
    * If the vertex with the node value is not found, returns null.
    * Use `equals` to search for the element from the vertices.
    *
    * @param element The value of T that is in some Vertex in the graph.
    * @return The vertex containing the node, or null if no vertex contains the element.
    */
   public Vertex<T> getVertexFor(T element) {
      List<Vertex<T>> potentialVertices = vertices.get(element.hashCode());
      // for (Vertex<T> v : edgeList.keySet()) {
      for (Vertex<T> v : potentialVertices) {
        if (v.getElement().equals(element)) {
          return v;
        }
      }
      return null;
   }

   /**
    * If target is null, search is done for the whole graph. Otherwise,
    * search MUST be stopped when the target vertex is found.
    *
    * Returns a list of vertices in the order they were met in the graph.
    * If graph is empty, returns an empty list.
    *
    * @param from The vertex where the search is started from.
    * @param target An optional ending vertex, null if not given.
    * @return Returns all the visited vertices traversed while doing BFS, in order they were found.
    */
   public List<Vertex<T>> breadthFirstSearch(Vertex<T> from, Vertex<T> target) {
      Queue<Vertex<T>> queue = new LinkedList<>();
      Set<Vertex<T>> enqueued = new HashSet<>();
      List<Vertex<T>> visited = new ArrayList<>();
      Vertex<T> vertex;
      Vertex<T> destination;
      queue.add(from);
      enqueued.add(from);
      while (!queue.isEmpty()) {
        vertex = queue.poll();
        visited.add(vertex);
        for (Edge<T> e : getEdges(vertex)) {
          destination = e.getDestination();
          if (!enqueued.contains(destination)) {
            queue.add(destination);
            enqueued.add(destination);
          }
        }
        if (target != null && vertex.equals(target)) {
          break;
        }
      }
      return visited;
   }

   /**
    * Does depth first search (DFS) of the graph starting from a vertex.
    * 
    * If target is null, search is done for the whole graph. Otherwise,
    * search MUST be stopped when the target vertex is found.
    * 
    *
    * @param from The vertex where the search is started from.
    * @param target An optional ending vertex, null if not given.
    * @return Returns all the visited vertices traversed while doing DFS, or empty list.
    */
   public List<Vertex<T>> depthFirstSearch(Vertex<T> from, Vertex<T> target) {
      Stack<Vertex<T>> stack = new Stack<>();
      Set<Vertex<T>> pushed = new HashSet<>();
      List<Vertex<T>> visited = new ArrayList<>();
      Vertex<T> vertex;
      Vertex<T> destination;
      List<Edge<T>> neighbours;
      stack.add(from);
      pushed.add(from);
      visited.add(from);
      boolean doPop;
      while (!stack.isEmpty()) {
        vertex = stack.peek();
        neighbours = getEdges(vertex);
        if (neighbours.isEmpty()) {
          stack.pop();
          continue;
        }
        doPop = true;
        for (Edge<T> e : neighbours) {
          destination = e.getDestination();
          if (!pushed.contains(destination)) {
            doPop = false;
            stack.add(destination);
            pushed.add(destination);
            visited.add(destination);
            break;
          }
        }
        if (doPop) {
          stack.pop();
        }
        if (target != null && vertex.equals(target)) {
          break;
        }
      }
      return visited;
   }
   
   /**
    * Returns a non-empty list if the graph is disconnected. A disconnected graph is a
    * graph that has separate areas without any connecting edges between them.
    * 
    * If the graph is disconnected, the list contains all the elements _not_ visited, 
    * doing a breadth first search from the vertex provided as the parameter.
    * If the parameter is null, starts from the first vertice of the graph.
    * 
    * @Param toStartFrom Vertex to start investigating from. If null, start from the first vertex.
    * @return Returns non-empty list if the graph is disconnected, otherwise list is empty.
    */
   public List<T> disconnectedVertices(Vertex<T> toStartFrom) {
     Set<Vertex<T>> vertices = getVertices();
     if (toStartFrom == null) {
       toStartFrom = vertices.iterator().next();
     }
     List<Vertex<T>> visited = breadthFirstSearch(toStartFrom, null); 
     List<T> returning = new ArrayList<>();
     for (Vertex<T> e : vertices) {
       if (!visited.contains(e)) {
         vertices.removeAll(visited);
         for (Vertex<T> v : vertices) {
           returning.add(v.getElement());
         }
         break;
       }
     }
     return returning;
   }

   /**
    * Returns true if the graph is disconnected. That means, the graph 
    * has areas that can not be reached from the starting vertex.
    *
    * @param toStartFrom The vertex to start the analysis from. Can be null, then starts from first vertex.
    * @return True if the graph is disconnected.
    */
   public boolean isDisconnected(Vertex<T> toStartFrom) {
     return !disconnectedVertices(toStartFrom).isEmpty();
   }

   /**
    * Checks if the graph has cycles.
    * 
    * If the graph is directed, provide true as the parameter, false for 
    * undirected graphs. 
    * 
    * <p>NB: For this course project it is enough that this method works for
    * connected graphs. It does not need to work on disconnected graphs when starting
    * from the given vertex.
    *
    * @param isDirected If true graph is directed.
    * @param fromVertex Start looking from this vertex. If null, starts from first vertex in adjacency list.
    * @return Returns true if the graph has cycles.
    */
   public boolean hasCycles(EdgeType edgeType, Vertex<T> fromVertex) {
     Set<Vertex<T>> pushed = new HashSet<>();
     if (fromVertex == null) {
       fromVertex = getVertices().iterator().next();
     }
     return hasCycles(fromVertex, pushed, null);
   }

   private boolean hasCycles(Vertex<T> fromVertex, Set<Vertex<T>> pushed, Vertex<T> parent) {
     pushed.add(fromVertex);
     Vertex<T> destination;
     for (Edge<T> e : getEdges(fromVertex)) {
       destination = e.getDestination();
       if (!destination.equals(parent) && (pushed.contains(destination) || hasCycles(destination, pushed, fromVertex))) {
         return true;
       }
     }
     pushed.remove(fromVertex);
     return false;
   }

   // =====================
   // Dijkstra starts here.
   // =====================

   /**
    * The result of the Dijkstra's search.
    */
   public class DijkstraResult<E> {
      public boolean pathFound = false;
      public List<E> path;
      public int steps = 0;
      public double totalWeigth = 0.0;

      @Override
      public String toString() {
         StringBuilder builder = new StringBuilder();
         builder.append(String.format("Dikstra result:\n- Path found: %s%n", (pathFound ? "yes" : "no")));
         if (pathFound) {
            builder.append(String.format("- steps: %d%n", steps));
            builder.append(String.format("- total edge weights: %.2f%n", totalWeigth));
            if (null != path) {
               builder.append(String.format("- path: %s", path.toString()));
            } else {
               builder.append("Path not found\n");
            }
         }
         return builder.toString();
      }
   }

   /**
    * Finds the shortest path from start to end using Dijkstra's algorithm.
    * 
    * The return value contains information about the result.
    * @param start The vertex to start from.
    * @param end The vertex to search the shortest path to.
    * @return An object containing information about the result of the search.
    */
   public DijkstraResult<T> shortestPathDijkstra(Vertex<T> start, Vertex<T> end) {
      DijkstraResult<T> result = new DijkstraResult<>();
      result.pathFound = false;
      result.path = null;
      result.steps = 0;
      result.totalWeigth = 0.0;
      Edge<T> edge;
      List<Edge<T>> route = route(end, shortestPathsFrom(start));
      ListIterator<Edge<T>> i = route.listIterator(route.size());
      while (i.hasPrevious()) {
        edge = i.previous();
        if (result.path == null) {
          result.path = new ArrayList<>();
          result.pathFound = true;
          result.path.add(edge.getSource().getElement());
        }
        result.path.add(edge.getDestination().getElement());
        result.totalWeigth += edge.getWeigth();
        ++result.steps;
      }
      return result;
   }

   private double distance(Vertex<T> toDestination, Map<Vertex<T>, Visit<T>> paths) {
      double distance = 0.0;
      for (Edge<T> e : route(toDestination, paths)) {
        distance += e.getWeigth();
      }
      return distance;
   }

   /**
    * Finds a route to a destination using paths already constructed.
    * Before calling this method, cal {@link shortestPathsFrom} to construct
    * the paths from the staring vertex of Dijkstra algorithm.
    *
    * A helper method for implementing the Dijkstra algorithm.
    * 
    * @param toDestination The destination vertex to find the route to.
    * @param paths The paths to search the destination.
    * @return Returns the vertices forming the route to the destination.
    */
   private List<Edge<T>> route(Vertex<T> toDestination, Map<Vertex<T>, Visit<T>> paths) {
     List<Edge<T>> path = new ArrayList<>();
     if (paths.isEmpty()) {
        return path;
     }
     Visit<T> visit = paths.get(toDestination);
     while (visit.type != Visit.Type.START) {
        path.add(visit.edge);
        visit = paths.get(visit.edge.getSource());
     }
     return path;
   }

   
   /**
    * Finds the shortest paths in the graph from the starting vertex.
    *
    * In doing Dijkstra, first call this method, then call {@link route}
    * with the paths collected using this method, to get the shortest path to the destination.
    *
    * @param start The starting vertex for the path searching.
    * @return Returns the visits from the starting vertex.
    * @see oy.tol.tira.graph.Graph#route(Vertex, Map)
    */
   private Map<Vertex<T>, Visit<T>> shortestPathsFrom(Vertex<T> start) {
      Visit<T> visit = new Visit<>();
      Map<Vertex<T>, Visit<T>> paths = new HashMap<>();
      Comparator<Vertex<T>> comparator = new Comparator<>() {
    		@Override
    		public int compare(Vertex<T> arg0, Vertex<T> arg1) {
    		  if (distance(arg0, paths) < distance(arg1, paths)) {
    		    return 1; 
    		  }
    		  return -1;
    		}
      };
      PriorityQueue<Vertex<T>> queue = new PriorityQueue<>(comparator);
      Vertex<T> destination;
      paths.put(start, visit);
      queue.add(start);
      while (!queue.isEmpty()) {
        start = queue.poll();
        for (Edge<T> e : getEdges(start)) {
          destination = e.getDestination();
          if (
            !paths.containsKey(destination) ||
            distance(start,paths)+e.getWeigth() < distance(destination,paths)
          ) {
            visit = new Visit<>();
            visit.type = Visit.Type.EDGE;
            visit.edge = e;
            paths.put(destination, visit);
            queue.add(destination);
          }
        }
      }
      return paths;
   }

   // OPTIONAL task in the course!
   /**
    * Do a breadth-first-search on the graph and export vertices and edges to a dot file
    *
    * Note that if the graph is disconnected, you must check if some vertices
    * were not visited and continue the BFS until _all_ vertices have been visited.
    * Otherwise, part of the graph is missing from the output file.
    *
    * The simplest way to do this is to first start from the given vertex, do 
    * the BFS saving data to dot file. Then, after this loop, get the disconnected vertices starting from
    * the starting vertex by calling disconnectedVertices(from). If there are not visited vertices, 
    * then pick one of the non visited vertices to be the new starting vertex (from).
    * Repeat this until all vertices have been visited. Basically you need an outer loop repeating
    * the BFS in the inner loop, and the outer loop stops when all vertices have been visited.
    *
    * @param from Start the BFS from this vertex.
    * @param outputFileName Write the dot to this text file.
    * @throws IOException If something goes wrong with file operations.
    */
   public void toDotBFS(Vertex<T> from, String outputFileName) throws IOException {
      // TEACHER: remove this implementation before giving code to students.
      BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName, StandardCharsets.UTF_8));
      writer.write("digraph \"CoderFriends\" {\n");
		writer.write("   node [shape=circle, style=\"rounded,filled\"]\n");
      writer.write("   beautify=true\n");
      writer.write("   overlap=\"scale\"\n");

      // TODO OPTIONAL!!!

		writer.write("\n}\n");
		writer.flush();
		writer.close();
   }

   // STUDENTS: TODO: Uncomment the code below and use it as a sample on how
   // to interate over vertices and edges in one situation.
   // If you use some other name for your edge list than edgeList, then
   // rename that in the code below! Otherwise you will have compiler errors.
   /**
    * Provides a string representation of the graph, printing  out the vertices and edges.
    * <p>
    * Quite useful if you need to debug issues with algorithms. You can see is the graph
    * what it is supposed to be like.
    * <p>
    * Simple graph as a string would look like this:<br/>
    * <pre>
    * Created simple undirected graph where integers are vertice values:
    * [1] -> [ 2 ]
    * [2] -> [ 1, 3, 4, 5 ]
    * [3] -> [ 2, 4, 5 ]
    * [4] -> [ 2, 3, 5 ]
    * [5] -> [ 2, 3, 4 ]
    * </pre> 
    * @return The graph as a string.
    */
   @Override
   public String toString() {
      StringBuilder output = new StringBuilder();
      for (Map.Entry<Vertex<T>, List<Edge<T>>> entry : edgeList.entrySet()) {
         output.append("[");
         output.append(entry.getKey().toString());
         output.append("] -> [ ");
         int counter = 0;
         int count = entry.getValue().size();
         for (Edge<T> edge : entry.getValue()) {
            output.append(edge.getDestination().toString());
            if (counter < count - 1) {
               output.append(", ");
            }
            counter++;
         }
         output.append(" ]\n");
      }
      return output.toString();
   }
}
