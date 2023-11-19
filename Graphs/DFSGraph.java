import java.util.ArrayList;

public class DFSGraph<E extends Comparable<E>> extends GraphAbstractDFS<E> {
    public Graph() {
        nodes = new ArrayList<GraphNode>();
    }

    /* addEdge
    * Params: data1 & data2, both data items to be added and connected
    * If the either of the data items are not in the nodes ArrayList,
    * add them as new nodes. Otherwise, find the nodes in the ArrayList so
    * you can make them point to each other. Implement so there are no duplicates
    * added to either of the nodes neighbors ArrayList.
    * */
    @Override
    public void addEdge(E data1, E data2) {
        GraphNode node1 = null;
        GraphNode node2 = null;
                
        if (nodes.isEmpty()) {
            nodes.add(new GraphNode(data1));
            nodes.add(new GraphNode(data2));
        }

        for (GraphNode g: nodes) {
            if (g.data.equals(data1)) node1 = g;
            if (g.data.equals(data2)) node2 = g;
        }

        if (node1 == null) nodes.add(new GraphNode(data1));
        if (node2 == null) nodes.add(new GraphNode(data2));

        for (GraphNode g: nodes) {
            if (g.data.equals(data1)) node1 = g;
            if (g.data.equals(data2)) node2 = g;
        }

        if (!node1.neighbors.contains(node2)) node1.neighbors.add(node2);
        if (!node2.neighbors.contains(node1)) node2.neighbors.add(node1);

    }
    
    /* depthFirst
     * Param: startNode, the node to start the traversal at
     *
     * First, find the startNode based off of startItem (hint: indexOf())
     * I recommend having an ArrayList of GraphNodes called visisted to keep
     * track of the nodes you've visited.
     *
     * Prints all of the nodes in the graph in depth first order (with a space between nodes)
     * */
    @Override
    public void depthFirst(E startItem) {
    	int start = nodes.indexOf(new GraphNode(startItem));
        ArrayList<GraphNode> visited = new ArrayList<>();

        depthFirst(nodes.get(start), visited);
    }

    // Recursive helper method for depthFirst
    private void depthFirst(GraphNode curr, ArrayList<GraphNode> visited) {
    	System.out.print(curr.data + " ");
        visited.add(curr);

        for (GraphNode g: curr.neighbors) {
            if (visited.contains(g)) continue;
            depthFirst(g, visited);
        }
    }
}
