import java.io.File;
import java.io.IOException;
import java.util.*;

public class GraphImplementation extends GraphAbstract {

    // Main entry point
    public static void main(String[] args) {

        // Instantiate code
        GraphImplementation impl = new GraphImplementation();
        Scanner input = new Scanner(System.in);
        String fileName = "MileagesLarge.csv";
        String startCity = "Fort Collins";
        // Read distances chart
        System.out.println("Reading Chart: " + fileName);
        impl.readGraph(fileName);
        System.out.println();

        // Print depth first search
        System.out.println("Depth First Search:");
        impl.depthFirst(startCity);
        System.out.println();

        System.out.println("Breadth First Search:");
        impl.breadthFirst(startCity);
        System.out.println();

        input.close();

    }

    /**
     * Reads mileage chart from CSV file and builds lists of nodes (cities) and
     * edges (distances).
     * <p>
     * The first line contains all the cities which should be represented as
     * {@link GraphNode}s <br>
     * The successive lines start with a city, followed by a list of mileages to
     * other cities.
     * <p>
     * To avoid redundancy, not all the values are filled in, ignore empty entries.
     * <br>
     * When you read a mileage, for example from Fort Collins to Denver, create only
     * one
     * entry in the mileages array, but add the edge to both cities.
     * <p>
     * First extract all the edges, then sort the edges by mileage, then add the
     * edges
     * associated with each node.
     * 
     * @param filename the CSV file
     */
    public void readGraph(String filename) {
        ArrayList<String> contents = readFile(filename);
        String[] citiesArr = contents.get(0).split(",");

        for (int i = 0; i < citiesArr.length; i++) {
            if (citiesArr[i].equals(""))
                continue;
            cities.add(new GraphNode(citiesArr[i]));
        }

        for (int i = 1; i < contents.size() - 1; i++) {
            String[] city = contents.get(i).split(",");
            for (int j = 1; j < city.length; j++) {
                if (!city[j].equals("")) {
                    cities.get(i - 1).edges.add(new GraphEdge(i - 1, j - 1, Integer.parseInt(city[j])));
                    cities.get(j - 1).edges.add(new GraphEdge(i - 1, j - 1, Integer.parseInt(city[j])));
                    mileages.add(new GraphEdge(i - 1, j - 1, Integer.parseInt(city[j])));
                }
            }
        }
        Collections.sort(mileages);
    }

    public void depthFirst(String startCity) {
        int start = cities.indexOf(new GraphNode(startCity));
        ArrayList<Integer> visited = new ArrayList<>();

        depthFirst(start, visited);
    }

    // Recursive helper method
    public void depthFirst(int index, ArrayList<Integer> visited) {
        System.out.println("Visited " + cities.get(index).name);

        visited.add(index);

        int smallestIndex = search(index, visited);
        if (smallestIndex == -1)
            return;
        depthFirst(smallestIndex, visited);

        smallestIndex = search(index, visited);
        if (smallestIndex == -1)
            return;
        depthFirst(smallestIndex, visited);
    }

    private int search(int index, ArrayList<Integer> visited) {
        int smallest = 500;
        int smallestIndex = -1;

        for (GraphEdge e : cities.get(index).edges) {
            // remove
            if (e.fromIndex == index && !visited.contains(e.toIndex)) {
                if (e.mileage < smallest) {
                    smallest = e.mileage;
                    smallestIndex = e.toIndex;
                }
            } else if (e.toIndex == index && !visited.contains(e.fromIndex)) {
                if (e.mileage < smallest) {
                    smallest = e.mileage;
                    smallestIndex = e.fromIndex;
                }
            }
        } // end for loop

        return smallestIndex;
    }

    public void breadthFirst(String startCity) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> visited = new ArrayList<>();
        //sort(mileages);

        int start = cities.indexOf(new GraphNode(startCity));
        int curr;

        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            curr = queue.poll();
            System.out.println("Visited " + cities.get(curr).name);

            for (GraphEdge e: mileages) {
                if (e.fromIndex == curr && !visited.contains(e.toIndex) && !queue.contains(e.toIndex))
                    queue.add(e.toIndex);
                 else if (e.toIndex == curr && ! visited.contains(e.fromIndex) && !queue.contains(e.fromIndex))
                    queue.add(e.fromIndex);         
            }

            for (Integer i: queue) visited.add(i);

        }

    }

    private void sort(ArrayList<GraphEdge> mileages) {
        for (int i = 0; i < mileages.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < mileages.size(); j++) {
                if (mileages.get(j).mileage < mileages.get(minIndex).mileage) {
                    minIndex = j;
                }
            }
            GraphEdge temp = mileages.get(minIndex);
            mileages.set(minIndex, mileages.get(i));
            mileages.set(i, temp);
        }
    }

    /**
     * Reads the contents of file to {@code ArrayList}
     * 
     * @param filename the file to read from
     * @return an ArrayList of the contents
     */
    static ArrayList<String> readFile(String filename) {
        ArrayList<String> contents = new ArrayList<>();
        try (Scanner reader = new Scanner(new File(filename))) {
            while (reader.hasNextLine()) {
                String line = reader.nextLine().trim();
                if (!line.isEmpty())
                    contents.add(line);
            }
        } catch (IOException e) {
            System.err.println("Cannot read chart: " + filename);
        }
        return contents;
    }

}
