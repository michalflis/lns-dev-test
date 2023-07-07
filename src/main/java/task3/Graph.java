package task3;

import java.util.Set;

public class Graph {
  private final Set<Integer> vertices;

  public Graph(Set<Integer> vertices) {
    this.vertices = vertices;
  }

  public Set<Integer> getVertices() {
    return vertices;
  }
}