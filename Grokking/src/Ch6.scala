import scala.collection.mutable
sealed trait GraphNode
case class Vertex(name: String) extends GraphNode
case class Graph(edges: Map[Vertex, Set[Vertex]] = Map()) {
  def addEdge(from: Vertex, to: Vertex): Graph = {
    val newEdges = edges.getOrElse(from, Set())
    Graph(edges + (from -> (newEdges + to)))
  }

  def dfs(start: Vertex) = {
    def loop(v: Vertex, visited: mutable.Set[Vertex]): Unit = {
      println(v)
      visited.add(v)
      for (i <- edges.getOrElse(v, Set()).toList) {
        if (!visited.contains(i))
          loop(
            i,
            visited
          )
      }
    }
    loop(start, mutable.Set())
  }

}

object Ch6 extends App {
  val g = Graph()
    .addEdge(Vertex("0"), Vertex("1"))
    .addEdge(Vertex("0"), Vertex("2"))
    .addEdge(Vertex("1"), Vertex("2"))
    .addEdge(Vertex("2"), Vertex("0"))
    .addEdge(Vertex("2"), Vertex("3"))
    .addEdge(Vertex("3"), Vertex("3"))
  g.dfs(Vertex("0"))
}
