public class MyThread extends Thread {
    @Override
    public void run() {
        if (this.isDaemon()) {
            System.out.println("This thread is running as a Daemon thread");
        }
        else System.out.println("This thread is a regular thread");
    }
}
