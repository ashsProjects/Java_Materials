public class Consumer implements Runnable {
    Buffer boundedBuffer;
    int consumedCount = 0;
    double consumedTotal = 0d;

    public Consumer(Buffer buffer) {
        this.boundedBuffer = buffer;
    }

    @Override
    public void run() {
        while (consumedCount <= 1000000) {
            if (consumedCount % 100000 == 0 && consumedCount != 0) {
                System.out.println(String.format("Consumer: Consumed %,d items, Cumulative value of consumed items=%.3f", consumedCount, consumedTotal));
            }

            try {
                double bufferValue = boundedBuffer.consume();
                consumedCount++;
                consumedTotal += bufferValue;
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //after consumer reaches 1000000
        System.out.println("Consumer: Finished consuming 1,000,000 items");
    }
}
