import java.util.ArrayList;

public abstract class GraphAbstractDFS<E extends Comparable<E>> {

    /* GraphNode subclass
    * A node in the graph which has an ArrayList of all it's neighbors
    * i.e. the nodes it points to.
    */
    public class GraphNode {
        public E data;
        public ArrayList<GraphNode> neighbors;

        public GraphNode(E data) {
            this.data = data;
            neighbors = new ArrayList<>();
        }

        public boolean equals(Object o) {
            if (o instanceof GraphAbstract<?>.GraphNode) {
            	GraphAbstract<?>.GraphNode otherNode = (GraphAbstract<?>.GraphNode) o;
            	return this.data.equals(otherNode.data);
            }
            return false;
        }
      public int hashCode() {
        return super.hashCode();
      }
    }

    // stores all of the nodes in the graph
    public ArrayList<GraphNode> nodes;

    public abstract void addEdge(E data1, E data2);

    // print graph in depth first order beginning at startNode
    public abstract void depthFirst(E startNode);
}
