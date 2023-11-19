public class Buffer {
    double boundedBuffer[];
    int size;
    int producerIndex;
    int consumerIndex;

    public Buffer(int capacity) {
        this.boundedBuffer = new double[capacity];
        this.size = 0;
        this.producerIndex = 0;
        this.consumerIndex = 0;
    }

    public void produce(double value) throws InterruptedException {
        synchronized(this) {
            while (size == 1000) {
                wait();
            }

            boundedBuffer[producerIndex] = value;
            producerIndex = (producerIndex + 1) % 1000;
            size++;
            notify();
        }
    }

    public double consume() throws InterruptedException {
        synchronized(this) {
            while (size == 0) {
                wait();
            }

            double value = boundedBuffer[consumerIndex];
            consumerIndex = (consumerIndex + 1) % 1000;
            size--;
            notify();
            return value;
        }
    }

}
