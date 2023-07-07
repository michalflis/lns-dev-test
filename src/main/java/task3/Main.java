package task3;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import static common.ScannerUtils.scanSetOfPairs;

public class Main {

  public static void main(String[] args) {
    Stack<List<Integer>> pairsOfVertices = scanSetOfPairs();
    if (pairsOfVertices.isEmpty())
      System.out.println(0);

    Set<Graph> allGraphs = new HashSet<>();
    addFirstGraph(pairsOfVertices, allGraphs);
    Stack<List<Integer>> queueOfPairs = new Stack<>();
    queueOfPairs.addAll(pairsOfVertices);
    for (List<Integer> pairOfVertices : queueOfPairs) {
      Set<Graph> visitedGraphs = new HashSet<>();
      for (Graph graph : allGraphs)
        if (graph.getVertices().contains(pairOfVertices.get(0))
            || graph.getVertices().contains(pairOfVertices.get(1)))
          visitedGraphs.add(graph);

      if (visitedGraphs.isEmpty())
        addGraph(pairOfVertices, allGraphs);
      else
        mergeGraphs(pairOfVertices, allGraphs, visitedGraphs);

    }
    System.out.println("Number of separated graphs: " + allGraphs.size());
  }

  private static void addFirstGraph(Stack<List<Integer>> pairs, Set<Graph> graphs) {
    Set<Integer> firstPair = new HashSet<>(pairs.pop());
    graphs.add(new Graph(firstPair));
  }

  private static void addGraph(List<Integer> pair, Set<Graph> graphs) {
    Set<Integer> firstPair = new HashSet<>(pair);
    graphs.add(new Graph(firstPair));
  }

  private static void mergeGraphs(List<Integer> pair, Set<Graph> graphs, Set<Graph> visited) {
    graphs.removeAll(visited);
    Set<Integer> newGraphVertices = visited
        .stream()
        .flatMap(g -> g.getVertices().stream())
        .collect(Collectors.toSet());
    newGraphVertices.addAll(pair);
    Graph newGraph = new Graph(newGraphVertices);
    graphs.add(newGraph);
  }
}