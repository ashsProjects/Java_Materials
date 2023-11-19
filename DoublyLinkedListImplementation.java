public class DoublyLinkedListImplementation<E> {
    /*
     * Private member variables that you need to declare:
     ** The head pointer
     ** The tail pointer
     */
    private Node head;
    private Node tail;

    public class Node {
        // declare member variables (data, prev and next)
        E data;
        Node prev;
        Node next;

        // finish these constructors
        public Node(E data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        public Node(E data) {
            this.data = data;
            this.prev = this.next = null;
        } // HINT: use this() with next = prev = null
    }

    // Initialize the head and tail pointer
    public MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public boolean add(E item) {
        Node prev = head;
        int size = size();

        if (head == null) {
            head = new Node(item, null, tail);
            return true;
        } else {
            for (int i = 0; i < size - 1; i++) {
                prev = prev.next;
            }
            prev.next = new Node(item, prev, prev.next);
            return true;
        }
    }

    public void add(int index, E element) {
        Node prev = head;

        for (int i = 0; i < index - 1; i++) {
            prev = prev.next;
        }

        prev.next = new Node(element, prev, prev.next);
    }

    public E remove() {
        E curr = head.data;

        head.next.prev = null;
        head = head.next;

        return curr;
    }

    public E remove(int index) {
        Node curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.prev.next = curr.next;
        if (curr.next != null)
            curr.next.prev = curr.prev;

        return curr.data;
    }

    public boolean remove(E item) {
        int size = size();
        Node curr = head;

        if (contains(item)) {
            for (int i = 0; i < size; i++) {
                if (curr.data.equals(item))
                    break;
                curr = curr.next;
            }
        } else
            return false;

        curr.prev.next = curr.next;
        if (curr.next != null)
            curr.next.prev = curr.prev;

        return true;
    }

    public void clear() {
        head = tail = null;
    }

    public boolean contains(E item) {
        int size = size();
        Node curr = head;
        boolean bool = true;

        for (int i = 0; i < size; i++) {
            if (curr.data.equals(item)) {
                bool = true;
                break;
            } else if (i == size - 1 && !curr.data.equals(item))
                bool = false;
            curr = curr.next;
        }

        return bool;
    }

    public E get(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x.data;
    }

    public int indexOf(E item) {
        int size = size();
        int index = -1;
        Node curr = head;

        for (int i = 0; i < size; i++) {
            if (curr.data.equals(item)) {
                index = i;
                break;
            }
            curr = curr.next;
        }

        return index;
    }

    public boolean isEmpty() {
        if (head == tail) {
            return true;
        }
        return false;
    }

    public int size() {
        int count = 0;
        Node curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }

        return count;
    }

    public String toString() {
        String ret = "";
        Node curr = head;
        while (curr != null) {
            ret += curr.data + " ";
            curr = curr.next;
        }
        return ret;
    }

}