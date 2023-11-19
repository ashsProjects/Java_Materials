public class Threads {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("How many threads are Running: " + Thread.activeCount());

        System.out.println("Name of the running thread(before change): " + Thread.currentThread().getName());
        Thread.currentThread().setName("Main_Thread");// change thread name
        System.out.println("Name of the running thread(after change): " + Thread.currentThread().getName());

        System.out.println("Priority of a thread(before change): " + Thread.currentThread().getPriority());
        Thread.currentThread().setPriority(3);// sets the priority; 10 is highest
        System.out.println("Priority of a thread(after change): " + Thread.currentThread().getPriority());

        System.out.println("Is alive? " + Thread.currentThread().isAlive());

        /*
         * thread sleeps for 1 second before the next statement
         * for (int i = 3; i > 0; i--) {
         * System.out.println(i);
         * Thread.sleep(1000);
         * }
         * System.out.println("You are done!");
         */

        System.out.println("-----------------------------------------------------------------");
        MyThread thread2 = new MyThread();
        //thread2.run();
        System.out.println("Is alive? " + thread2.isAlive());
        //thread2.start();//starts the threat
        System.out.println("Is alive? " + thread2.isAlive());

        System.out.println("Name of thread2(before change): " + thread2.getName());
        thread2.setName("2nd Thread");
        System.out.println("Name of thread2(after change): " + thread2.getName());
        thread2.setPriority(2);
        System.out.println("Priority of a thread2: " + thread2.getPriority());
        System.out.println("How many threads are Running: " + Thread.activeCount());

        System.out.println("-----------------------------------------------------------------");
        System.out.println("Is Daemon? : " + thread2.isDaemon());
        thread2.run();
        thread2.setDaemon(true);
        System.out.println("Is Daemon? : " + thread2.isDaemon());
        thread2.run();

    }
}
