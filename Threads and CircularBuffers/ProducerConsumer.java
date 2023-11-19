public class ProducerConsumer {

    public static void main(String[] args) throws InterruptedException {
        Buffer boundedBuffer = new Buffer(1000);

        Producer producer = new Producer(boundedBuffer);
        Consumer consumer = new Consumer(boundedBuffer);
        
        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Exiting!");
    }
}