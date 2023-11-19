public class MultiThreading{
     public static void main(String[] args) throws InterruptedException {
        MyMultiThread thread = new MyMultiThread();
        MyRunnable runnable = new MyRunnable();
        Thread thread2 = new Thread(runnable);
        Thread daemonThread = new Thread(runnable);

        thread.start();
        //thread.join(3000);//thread will finish then run thread2
        thread2.start();

        daemonThread.setDaemon(true);
        thread.join(3000);
        daemonThread.start();

  

     }   
}
