package multithreads;

import java.util.LinkedList;
import java.util.Queue;

class SharedBuffer {

    private final Queue<Integer> buffer = new LinkedList<>();
    private final int capacity;

    public SharedBuffer(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void produce(int item) throws InterruptedException {
        while (buffer.size() == capacity) {
            wait();
        }
        buffer.add(item);
        System.out.println("Produced: " + item);
        notify();
    }

    public synchronized int consume() throws InterruptedException {
        while (buffer.isEmpty()) {
            wait();
        }
        int item = buffer.poll();
        System.out.println("Consumer: " + item);
        notify();
        return item;
    }
}

public class ProducerConsumer {

    public static void main(String[] args) {
        var sharedBuffer = new SharedBuffer(5);
        Thread producer = new Thread(() -> {
            int item = 1;
            try {
                while (true) {
                    sharedBuffer.produce(item++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    sharedBuffer.consume();
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        producer.start();
        consumer.start();
    }
}
