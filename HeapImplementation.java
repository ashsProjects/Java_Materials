import java.util.Arrays;

public class Heap<T extends Comparable<T>> implements PriorityQueue<T> {

    private T[] heap;
    private int size;

    public Heap(int capacity) {
        heap = (T[]) new Comparable[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int rchild(int index) {
        return 2 * (index + 1);
    }

    private int lchild(int index) {
        return 2 * index + 1;
    }

    private boolean hasLeftChild(int index) {
        if (index >= size || index >= heap.length) return false;
        else if (lchild(index) >= size) return false;
        else return true;
    }

    private boolean hasRightChild(int index) {
        if (index >= size || index >= heap.length) return false;
        else if (rchild(index) >= size) return false;
        else return true;
    }

    private void swap(int index1, int index2) {
        T temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    /* Perform a heapify starting at the given index.
     * Check the index's two children to see if you should swap the node
     * with either of these children. If you should, do the swap, and call
     * another bubbleDown on the index you swapped to.
     */
    private void bubbleDown(int index) {
        T val = heap[index];
        int rchild;
        int lchild;

        if (hasRightChild(index)) {
            rchild = rchild(index);
            lchild = lchild(index);
            T highP;
            int highPInt;

            if (heap[rchild].compareTo(heap[lchild]) >= 0) {
                highP = heap[rchild];
                highPInt = rchild;
            }
            else {
                highP = heap[lchild];
                highPInt = lchild;
            }

            if (val.compareTo(highP) >= 1) return;
            else {
                swap(highPInt, index);
                bubbleDown(highPInt);
            }
        }
        else if (hasLeftChild(index)) {
            lchild = lchild(index);
            if (val.compareTo(heap[lchild]) >= 1) return;
            else {
                swap(lchild, index);
            }
        }

    }

    /* Perform a "reverse-heapify" starting at the current index.
     * Check the index's parent to see if you should swap the two; If you
     * should, do a swap and call another bubbleUp on the index you swapped to.
     *
     * This should be a significantly simpler method than bubbleDown.
     */
    private void bubbleUp(int index) {
        T val = heap[index];
        int parentIndex = parent(index);
        T parent = heap[parentIndex];

        if (val.compareTo(parent) >= 1) {
            swap(index, parentIndex);
            bubbleUp(parentIndex);
        }


    }

    /* Add an item to the queue.
     * Add the item at the end of the array, then bubble it up.
     * Assume that the heap will have space.
     */
    public void push(T item) {
        if (size == 0) {
            heap[size] = item;
            size++;
            return;
        }
        heap[size] = item;
        bubbleUp(size);
        size++;
    }

    /* Remove the highest priority item from the queue.
     * Replace the item at the root (index 0) with the last item
     * in the array, then bubble it down.
     * Assume that the heap won't be empty.
     */
    public T pop() {
        T highest = heap[0];
        
        if (size == 0) throw new NullPointerException();
        else if (size == 1) {
            heap[0] = null;
            size--;
            return highest;
        }
        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;
        bubbleDown(0);
        return highest;
    }

    /* Return the highest priority item from the queue. 
     */
    public T peek() {
        if (size == 0) throw new NullPointerException();
        return heap[0];
    }

    public String toString() {
        return Arrays.toString(heap);
    }

    public static void main(String[] args) {
        Heap<String> colors = new Heap<String>(10);

        colors.push("lime");
        System.out.println("push lime       -> " + colors);
        colors.push("fuchsia");
        System.out.println("push fuchsia    -> " + colors);
        colors.push("cyan");
        System.out.println("push cyan       -> " + colors);
        colors.push("yellow");
        System.out.println("push yellow     -> " + colors);
        colors.push("maroon");
        System.out.println("push maroon     -> " + colors);

        System.out.println();
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());

        System.out.println();
        System.out.printf( "peek %-11s<- " + colors + "\n", colors.peek());
        System.out.printf( "peek %-11s<- " + colors + "\n", colors.peek());

        System.out.println();
        colors.push("olive");
        System.out.println("push olive      -> " + colors);
        colors.push("icterine");
        System.out.println("push icterine   -> " + colors);
        colors.push("sienna");
        System.out.println("push sienna     -> " + colors);
        colors.push("silver");
        System.out.println("push silver     -> " + colors);
        colors.push("teal");
        System.out.println("push teal       -> " + colors);
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        colors.push("slate");
        System.out.println("push slate      -> " + colors);
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf( "peek %-11s<- " + colors + "\n", colors.peek());
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf( "peek %-11s<- " + colors + "\n", colors.peek());
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf( "pop %-12s<- " + colors + "\n", colors.pop());
        System.out.printf( "peek %-11s<- " + colors + "\n", colors.peek());
    }

}

