import java.util.*;

public class BFSGraph {
    ArrayList<List<Integer>> adjList;

    /**
     * Initializes the Graph to have adjacency lists for each node in the graph
     * @param numNodes
     */
    public Graph(int numNodes){
        adjList = new ArrayList<List<Integer>>(numNodes);
        for(int i = 0; i < numNodes; i++){
             adjList.add(new ArrayList<Integer>());
        }
    }

    /**
     * This method should add a new edge to the graph by getting the adjacency list for node1 and
     * adding the node2 to that list.
     *
     * It should also add the node1 to node2's adjacency list.
     *
     * If either node is not in the graph(if the given index is less than 0 or if it's out of bounds for the
     * list throw a NoSuchElementException
     *
     *
     * @param node1 - a node in the graph
     * @param node2 - a node in the graph
     * @throws java.util.NoSuchElementException if the node is not in the graph
     */
    public void addEdge(int node1, int node2){
        if (node1 < 0 || node2 < 0) throw new NoSuchElementException();

        try {
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }
    
    public void breadthFirst(int startNode){
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> visited = new ArrayList<>();
        int currNode;

        queue.add(startNode);
        visited.add(startNode);

        while (!queue.isEmpty()) {
            currNode = queue.poll();
            System.out.println("Visited Node " + currNode);

            for (int i: adjList.get(currNode)) {
                if (queue.contains(i)) continue;
                if (visited.contains(i)) continue;
                queue.add(i);
            }

            for (int j: queue) visited.add(j);
        }

    }
    @Override
    public String toString(){
        StringBuilder ret = new StringBuilder();
        int i = 1;
        for(List<Integer> l : adjList){
            String list = String.format("Node %d: %s\n", i, l);
            ret.append(list);
            i++;
        }
        return ret.toString();
    }
    public static int getRand(Random r, int numNodes, int i){
        int rand = r.nextInt(numNodes);
        while(rand == i){
            rand = r.nextInt(numNodes);
        }
        return rand;
    }
    public static void main(String[] args){
        /* Testing Graph */
        int numNodes = 10;
        Random r = new Random(2020);
        Graph g = new Graph(numNodes);
        for(int i = 0; i < numNodes; i++){
            g.addEdge(i, getRand(r, numNodes, i));
            g.addEdge(i, getRand(r, numNodes, i));
            g.addEdge(i, getRand(r, numNodes, i));
        }
        System.out.println(g);
        try{
            g.addEdge(-3, 20);
        }catch(NoSuchElementException e){
            System.out.println("You threw the exception. Yay!");
        }
       /* Testing BFS */
       System.out.println("\nBFS 1:");
       g.breadthFirst(0);
       System.out.println("\nBFS 2:");
       g.breadthFirst(6);
       System.out.println("\nBFS 3:");
       g.breadthFirst(4);
       /* Testing Exception on addEdge() */

    }
}
