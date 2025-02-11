package multithreads;


/*
* What are Reentrant Locks?
*  A reentrant lock is a synchronization mechanism that allows a thread to acquire the same
*  lock multiple times, without blocking itself.
*  This means that a thread can re-enter a lock it already holds, avoiding deadlock situations.
*  Reentrant locks are a part of the java.util.concurrent.
* locks package and are represented by the ReentrantLock class.

    The term “reentrant” in reentrant locks signifies that a thread can re-enter the lock it already owns,
*  making the code more flexible and less prone to deadlock issues.
*
* Why Use Reentrant Locks?

Nested Locking: Reentrant locks allow you to write methods that call other methods, each of which acquires and releases the lock. This nested locking can provide fine-grained control over thread synchronization.
Avoiding Deadlocks: Since a thread can re-enter a reentrant lock, it’s less likely to encounter deadlock situations where threads are waiting indefinitely for a lock they already own.
Interruptible Locking: Unlike traditional locks, reentrant locks support interruptible locking. This means that a thread can be interrupted while waiting to acquire a lock, making it more responsive to external signals.
Fairness: Reentrant locks can be configured to operate in a fair manner, ensuring that threads are granted access to the lock in the order they requested it. This can help prevent thread starvation.
*
*
*
* import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final ReentrantLock lock = new ReentrantLock();

    public void doSomething() {
        lock.lock();
        try {
            // Access shared resource
            System.out.println("Inside doSomething()");
            anotherMethod(); // Reentrant call
        } finally {
            lock.unlock();
        }
    }

    private void anotherMethod() {
        lock.lock();
        try {
            // Access shared resource
            System.out.println("Inside anotherMethod()");
        } finally {
            lock.unlock();
        }
    }
}
*
*
* */

public class DiningPhilosopher {
}
