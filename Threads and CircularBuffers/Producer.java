import java.util.Random;

public class Producer implements Runnable {
    Buffer boundedBuffer;
    int producedCount = 0;
    double producedTotal = 0d;

    public Producer(Buffer buffer) {
        this.boundedBuffer = buffer;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (producedCount <= 1000000) {
            if (producedCount % 100000 == 0 && producedCount != 0) {
                System.out.println(String.format("Producer: Generated %,d items, Cumulative value of generated items=%.3f", producedCount, producedTotal));
            }

            double bufferElement = random.nextDouble() * 100.0;
            try {
                boundedBuffer.produce(bufferElement);
                producedCount++;
                producedTotal += bufferElement;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//end while
        
        //after producer produces 1000000 items
        System.out.println("Producer: Finished generating 1,000,000 items");
        
    }
    
}
