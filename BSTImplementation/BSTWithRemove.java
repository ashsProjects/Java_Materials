import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BSTWithRemove {

    private TreeNode root;
    private int size;

    public class TreeNode {
        public Integer element;
        public Long time;
        public TreeNode rightChild;
        public TreeNode leftChild;
        public TreeNode parentNode;

        public TreeNode(Integer element, Long time) {
            this.element = element;
            this.time = time;
            this.rightChild = null;
            this.leftChild = null;
        }

        public TreeNode(Integer element, Long time, TreeNode parent) {
            this.element = element;
            this.time = time;
            this.rightChild = null;
            this.leftChild = null;
            this.parentNode = parent;
        }
    }

    public BinaryTree() {
        this.root = null;
        size = 0;
    }

    public BinaryTree(Integer item) {
        BinrayTree();
        insert(item);
    }

    public void insert(Integer num) {
        if (size == 0) {
            root = new TreeNode(num, System.nanoTime());
            size++;
        } else
            insert(num, root);
    }

    public void insert(Integer item, TreeNode root) {
        if (item == root.element)
            return;
        else if (item > root.element) {
            if (root.rightChild == null)
                root.rightChild = new TreeNode(item, System.nanoTime(), root);
            else
                insert(item, root.rightChild);
        } else {
            if (root.leftChild == null)
                root.leftChild = new TreeNode(item, System.nanoTime(), root);
            else
                insert(item, root.leftChild);
        }
        size++;
        return;
    }

    public Boolean remove(Integer num) {
        TreeNode nodeToRemove = getValue(num);
        if (nodeToRemove == null)
            return false;
        else {
            if (nodeToRemove.leftChild == null && nodeToRemove.rightChild == null) {
                if (nodeToRemove.element > nodeToRemove.parentNode.element)
                    nodeToRemove.parentNode.rightChild = null;
                else
                    nodeToRemove.parentNode.leftChild = null;
            } else if (nodeToRemove.leftChild != null && nodeToRemove.rightChild != null) {
                TreeNode successor = findSuccessor(nodeToRemove.rightChild);
                if (nodeToRemove.parentNode == null) {
                    nodeToRemove.rightChild.parentNode = successor;
                    return true;
                }
                if (nodeToRemove.element > nodeToRemove.parentNode.element)
                    nodeToRemove.parentNode.rightChild = successor;
                else
                    nodeToRemove.parentNode.leftChild = successor;
            } else if (nodeToRemove.leftChild == null) {
                if (nodeToRemove.element > nodeToRemove.parentNode.element)
                    nodeToRemove.parentNode.rightChild = nodeToRemove.rightChild;
                else
                    nodeToRemove.parentNode.leftChild = nodeToRemove.rightChild;
                nodeToRemove.rightChild = null;
            } else {
                if (nodeToRemove.element > nodeToRemove.parentNode.element)
                    nodeToRemove.parentNode.rightChild = nodeToRemove.leftChild;
                else
                    nodeToRemove.parentNode.leftChild = nodeToRemove.leftChild;
                nodeToRemove.leftChild = null;
            }
        }

        return true;
    }

    public TreeNode findSuccessor(TreeNode curr) {
        if (curr.leftChild == null)
            return curr;
        findSuccessor(curr.leftChild);
        return curr;
    }

    public Long get(Integer num) {
        if (num == root.element)
            return root.time;
        else {
            if (num > root.element)
                return get(num, root.rightChild);
            else
                return get(num, root.leftChild);
        }
    }

    public Long get(Integer item, TreeNode root) {
        if (root == null)
            return -1L;
        if (item == root.element)
            return root.time;
        else {
            if (item > root.element)
                return get(item, root.rightChild);
            else
                return get(item, root.leftChild);
        }
    }

    public TreeNode getValue(Integer num) {
        if (num == root.element)
            return root;
        else {
            if (num > root.element)
                return getValue(num, root.rightChild);
            else
                return getValue(num, root.leftChild);
        }
    }

    public TreeNode getValue(Integer item, TreeNode root) {
        if (root == null)
            return null;
        if (item == root.element)
            return root;
        else {
            if (item > root.element)
                return getValue(item, root.rightChild);
            else
                return getValue(item, root.leftChild);
        }
    }

    public Integer findMaxDepth() {
        ArrayList<Integer> DFSList = new ArrayList<>();
        DFS(root, 1, DFSList);
        Collections.sort(DFSList);
        return DFSList.get(DFSList.size() - 1);
    }

    public Integer findMinDepth() {
        ArrayList<Integer> DFSList = new ArrayList<>();
        DFS(root, 1, DFSList);
        Collections.sort(DFSList);
        return DFSList.get(0);
    }

    public void DFS(TreeNode root, Integer depth, ArrayList<Integer> list) {
        if (root == null)
            return;// not implemented
        if (root.rightChild == null && root.leftChild == null) {
            list.add(depth);
            return;
        }

        DFS(root.leftChild, depth + 1, list);
        DFS(root.rightChild, depth + 1, list);
        return;
    }

    // TEST
    // CODE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static void main(String[] args) throws FileNotFoundException, IOException {
        File file = new File("data.txt");
        FileReader fReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fReader);
        TreeStructure tree = new BinaryTree();
        Random rng = new Random(42);
        ArrayList<Integer> nodesToRemove = new ArrayList<>();
        ArrayList<Integer> nodesToGet = new ArrayList<>();
        String line = bufferedReader.readLine();

        while (line != null) {
            Integer lineInt = Integer.parseInt(line);
            tree.insert(lineInt);
            Integer rand = rng.nextInt(10);
            if (rand < 5)
                nodesToRemove.add(lineInt);
            else if (rand >= 5)
                nodesToGet.add(lineInt);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();

        for (int i = 0; i < 10; i++) {
            System.out.println(nodesToGet.get(i) + " inserted at " +
                    tree.get(nodesToGet.get(i)));
        }

        System.out.println("Max depth: " + tree.findMaxDepth());
        System.out.println("Min depth: " + tree.findMinDepth());

        for (Integer num : nodesToRemove) {
            tree.remove(num);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(nodesToGet.get(i) + " inserted at " +
                    tree.get(nodesToGet.get(i)));
        }

        System.out.println("Max depth: " + tree.findMaxDepth());
        System.out.println("Min depth: " + tree.findMinDepth());

    }

}