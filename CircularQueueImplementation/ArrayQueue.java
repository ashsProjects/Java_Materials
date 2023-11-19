import java.util.Arrays;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * ArrayQueue is a FIFO (First In First Out) data structure that stores its elements
 * in an array (or something like it, like an {@link java.util.ArrayList}).
 * <p>
 * Can we use an {@link java.util.ArrayList} to directly represent a queue? A FIFO needs to push on one end,
 * and pop from the other. The tail of an {@link java.util.ArrayList} can support pop and push efficiently,
 * but the front supports neither efficiently.
 * <p>
 * Instead, we use an array for storage, and we represent the head and tail of the queue
 * with indices into that array. When one of the indices would fall off the end of the array,
 * it just goes back to the start of the array. That is why this pattern is called a "circular"
 * array. Read more about that <a href=../queue.html>here</a>.
 * <p>
 * We can think of the head and tail indices "chasing" each other around the circular
 * storage. When you add an item, the tail moves. When you take an item, the head moves.
 * If the head catches the tail, the queue is empty. If the tail catches the head, the queue is full.
 * <p>
 * That's a lot to take in, but it's easier to code than it sounds. Notice that the member variables
 * "removed" and "added" are counters recording the <i>total</i> operation count. To see where the head and
 * tail of the queue are, just compute:
 * {@code (removed % elements.length)} or {@code (added % elements.length)}
 * <p>
 * @param <E> the type of elements held in this collection
 */
public class ArrayQueue<E> extends AQueue<E> implements IQueue<E>{
    protected E[] elements;
    protected int added = 0;
    protected int removed = 0;

    public ArrayQueue(int maxSize) {
      this.elements = (E[]) new Object[maxSize];
    }

    protected E[] newArray(int size) {
       return null;
    }

    @Override
    public boolean offer(E e) {
      if (size() == elements.length) return false;
      elements[added % elements.length] = e;
      added++;
      return true;
    }

    @Override
    public E poll() {
      if (size() == 0) return null;
      E removedObj = elements[removed % elements.length];
      elements[removed % elements.length] = null;
      removed++;
      return removedObj;
    }

    @Override
    public E peek() {
    	if (size() == 0) return null;
      return elements[removed % elements.length];
    }

    @Override
    public int size() {
        return added - removed;
    }

    @Override
    public void clear() {
      E[] tempArr = (E[]) new Object[elements.length];
      elements = tempArr;
      this.added = 0;
      this.removed = 0;
    }

    @Override
    public boolean contains(Object o) {
      if (size() == 0) return false;
      for (Object obj: elements) {
        if (obj != null && obj.equals(o)) return true;
      }
      return false;
    }
    

    public static void main(String[] args) {
        IQueue<Integer> q = new ArrayQueue<>(10);
        
        System.out.println("Offering to Queue:");
        System.out.println("     Offer(1) -> " + q.offer(1));
        System.out.println("     Offer(2) -> " + q.offer(2));
        System.out.println("     Offer(3) -> " + q.offer(3));
        System.out.println("     size() should be 3 -> " + q.size());
        System.out.println("     contains(2) should be true -> " + q.contains(2));

        System.out.println("Adding more elements using add():");
        System.out.println("     add(4);  add(5); add(6); add(7); add(8); add(9); add(10);");
        q.add(4);  q.add(5); q.add(6); q.add(7); q.add(8); q.add(9); q.add(10);
        System.out.println("     size() should be 10 -> " + q.size());
        
        System.out.println("Trying to offer to a full queue:");
        System.out.println("     offer(11) should return false -> " + q.offer(11));
        System.out.println("     size() should still be 10 -> " + q.size());
        
        
        System.out.println("Polling and removing some elements:");
        System.out.println("     poll() should be 1 -> " + q.poll());
        System.out.println("     remove() should be 2 -> " + q.remove());
        System.out.println("Testing clear:");
        q.clear();
        System.out.println("     size() should be 0 -> " + q.size());
        
        System.out.println("Trying to poll from an empty queue:");
        System.out.println("     poll() should return null -> " + q.poll());
        System.out.println("     size() should still be 0 -> " + q.size());
        
        System.out.println("Testing contains() with TrainCar objects:");
        ArrayQueue<TrainCar> qCar = new ArrayQueue<>(10);
        qCar.offer(new TrainCar("Engine", "orange", 80523));
        qCar.offer(new TrainCar("Passenger", "blue", 24601));
        qCar.offer(new TrainCar("Caboose", "red", 12345));
        TrainCar toTest = new TrainCar("Caboose", "red", 12345);
        System.out.println("     contains(" + toTest + ") should be true -> " + qCar.contains(toTest));
        System.out.println();

        // final testing uncomment the following line to get comprehensive testing.
        //Note: zyBooks is not able to run 100000 tests or more.
        final int hundred_thousand = 100000;
        final int million = 1000000;
        QueueTestProgram.printFailedTests(million, ArrayBlockingQueue::new, ArrayQueue::new);
       
    }
}
