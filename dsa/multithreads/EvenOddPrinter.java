package multithreads;

public class EvenOddPrinter {

    private static int counter = 1;
    private static int MAX = 1000;
    private static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {

        Runnable oddPrinter = () -> {
            while (true) {
                synchronized (lock) {
                    if (counter > MAX) {
                        lock.notifyAll();
                        break;
                    }
                    while (counter % 2 == 0) {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                        }
                        if (counter > MAX) {
                            lock.notifyAll();
                            return;
                        }
                    }
                    System.out.println("Odd Printer : " + counter);
                    counter++;
                    lock.notifyAll();
                }
            }

        };

        Runnable evenPrinter = () -> {
            while (true) {
                synchronized (lock) {
                    if (counter > MAX) {
                        lock.notifyAll();
                        break;
                    }
                    while (counter % 2 != 0) {
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            Thread.currentThread().interrupt();
                        }
                        if (counter > MAX) {
                            lock.notifyAll();
                            return;
                        }
                    }
                    System.out.println("Even Printer : " + counter);
                    counter++;
                    lock.notifyAll();
                }
            }
        };

        Thread t1 = Thread.startVirtualThread(oddPrinter);
        Thread t2 = Thread.startVirtualThread(evenPrinter);

        t1.join();
        t2.join();
    }
}
