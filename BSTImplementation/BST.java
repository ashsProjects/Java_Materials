import java.util.LinkedList;
import java.util.Queue;

public class BST implements Tree<Integer> {

    private TreeNode<Integer> root;
    private int size;

    public class TreeNode<Integer> {
        public Integer element;
        public TreeNode<Integer> rightChild;
        public TreeNode<Integer> leftChild;

        public TreeNode(Integer element) {
            this.element = element;
            this.rightChild = null;
            this.leftChild = null;
        }
    }

    public BST() {
        this.root = null;
        size = 0;
    }

    public BST(Integer item) {
        super();
        insert(item);
    }

    public BST(Integer[] items) {
        for (Integer i: items) {
            insert(i);
        }
    }

    @Override
    public boolean search(Integer item) {
        if (item == root.element) return true;
        else {
            if (item > root.element) return search(item, root.rightChild);
            else return search(item, root.leftChild);
        }
    }
    public boolean search(Integer item, TreeNode<Integer> root) {
        if (root == null) return false;
        if (item == root.element) return true;
        else {
            if (item > root.element) return search(item, root.rightChild);
            else return search(item, root.leftChild);
        }
    }

    @Override
    public boolean insert(Integer item) {
        if (size() == 0) {
            root = new TreeNode<Integer>(item);
            size++;
            return true;
        }
        return insert(item, root);
    }
    
    public boolean insert(Integer item, TreeNode<Integer> root) {
        if (item == root.element) return false;
        else if (item > root.element) {
            if (root.rightChild == null) root.rightChild = new TreeNode<Integer>(item);
            else{
                insert(item, root.rightChild);
                return true;
            }
        }
        else {
            if (root.leftChild == null) root.leftChild = new TreeNode<Integer>(item);
            else {
                insert(item, root.leftChild);
                return true;
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(Integer item) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void inorder() {
        System.out.println(inorder(root));
        Queue<Integer> list = new LinkedList<>();
        inorderLL(root, list);
        System.out.print(list);
    }
    public String inorder(TreeNode<Integer> root) {
        if (root == null) return "";
        return inorder(root.leftChild) + root.element + " " + inorder(root.rightChild);
    }
    public String inorderLL(TreeNode<Integer> root, Queue<Integer> list) {
        if (root == null) return "";
        return inorderLL(root.leftChild, list) + list.add(root.element) + inorderLL(root.rightChild, list);
    }

    @Override
    public void postorder() {
        System.out.print(postOrder(root));
    }
    public String postOrder(TreeNode<Integer> root) {
        if (root == null) return "";
        return postOrder(root.leftChild) + postOrder(root.rightChild) + root.element + " ";
    }

    @Override
    public void preorder() {
        System.out.print(preorder(root));
    }
    public String preorder(TreeNode<Integer> root) {
        if (root == null) return "";
        return root.element + " " + preorder(root.leftChild) + preorder(root.rightChild);
    }

    @Override
    public boolean isEmpty() {
        return size < 0;
    }

    public TreeNode<Integer> getRoot() {
        return root;
    }
}
