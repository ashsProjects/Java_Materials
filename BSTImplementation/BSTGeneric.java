public class BSTGeneric<E extends Comparable<E>> implements Tree<E> {

    private TreeNode<E> root;
    private int size;

    public class TreeNode<E> {
        public E element;
        public TreeNode<E> rightChild;
        public TreeNode<E> leftChild;

        public TreeNode(E element) {
            this.element = element;
            this.rightChild = null;
            this.leftChild = null;
        }
    }

    public BSTGeneric() {
        this.root = null;
        size = 0;
    }

    public BSTGeneric(E item) {
        this();
        insert(item);
    }

    public BSTGeneric(E[] items) {
        for (E i: items) {
            insert(i);
        }
    }

    @Override
    public boolean search(E e) {
        if (e.equals(root.element)) return true;
        else {
            if (e.compareTo(root.element) > 0) return search(e, root.rightChild);
            else return search(e, root.leftChild);
        }
    }
    public boolean search(E item, TreeNode<E> root) {
        if (root == null) return false;
        if (item.equals(root.element)) return true;
        else {
            if (item.compareTo(root.element) > 0) return search(item, root.rightChild);
            else return search(item, root.leftChild);
        }
    }

    @Override
    public boolean insert(E e) {
        if (size() == 0) {
            root = new TreeNode<E>(e);
            size++;
            return true;
        }
        return insert(e, root);
    }
    public boolean insert(E item, TreeNode<E> root) {
        if (item == root.element) return false;
        else if ((item.compareTo(root.element) > 0)) {
            if (root.rightChild == null) root.rightChild = new TreeNode<E>(item);
            else{
                insert(item, root.rightChild);
                return true;
            }
        }
        else {
            if (root.leftChild == null) root.leftChild = new TreeNode<E>(item);
            else {
                insert(item, root.leftChild);
                return true;
            }
        }
        size++;
        return true;
    }

    @Override
    public boolean remove(E e) {
        remove(root, e);
        size--;
        return true;
    }
    public TreeNode<E> remove(TreeNode<E> root, E e) {
        if (root == null)
            return root;

        if (e.compareTo(root.element) < 0) root.leftChild = remove(root.leftChild, e);
        else if (e.compareTo(root.element) > 0) root.rightChild = remove(root.rightChild, e);
        else {
            if (root.leftChild == null) return root.rightChild;
            else if (root.rightChild == null) return root.leftChild;

            root.element = inorderSucc(root.rightChild);
            root.rightChild = remove(root.rightChild, root.element);
        }
        return root;
    }
    public E inorderSucc(TreeNode<E> root) {
        if (root.leftChild == null) {
            return root.element;
        }
        else inorderSucc(root.leftChild);
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void inorder() {
        System.out.print(inorder(root));
    }
    public String inorder(TreeNode<E> root) {
        if (root == null) return "";
        return inorder(root.leftChild) + root.element + " " + inorder(root.rightChild);
    }

    @Override
    public void postorder() {
        System.out.print(postOrder(root));
    }
    public String postOrder(TreeNode<E> root) {
        if (root == null) return "";
        return postOrder(root.leftChild) + postOrder(root.rightChild) + root.element + " ";
    }

    @Override
    public void preorder() {
        System.out.print(preorder(root));
    }
    public String preorder(TreeNode<E> root) {
        if (root == null) return "";
        return root.element + " " + preorder(root.leftChild) + preorder(root.rightChild);
    }

    @Override
    public boolean isEmpty() {
        return size < 0;
    }

    public TreeNode<E> getRoot() {
        return root;
    }
}
