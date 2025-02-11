package multithreads;

/*
 * what is a ThreadPool?
 *   A ThreadPool is a collection of threads aka ( workers ) which are available to perform submitted
 *   tasks.
 *   Once a task has been completed by a worker thread goes back to thread pool and wait for a new task to get
 *   assigned.
 *   Threads can be reused.
 *
 *
 *
 *
 *
 *
 *
 * */

class RaceConditionDemo {
    private int count = 0;

    public synchronized void incrementCounter() {
        count++;
    }

    public int getCount() {
        return count;
    }
}

public class ThreadPools {

    public static void main(String[] args) throws InterruptedException {
        var rc = new RaceConditionDemo();
        int noOfThreads = 100;
        int incrementPerThread = 10000;
        Thread[] threads = new Thread[noOfThreads];
        for (int i = 0; i < noOfThreads; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < incrementPerThread; j++) {
                    rc.incrementCounter();
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println("Counter: " + rc.getCount());
    }
}
