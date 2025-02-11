package multithreads;

//Basics of Concurrency and Why It Matters
//Creating Threads in Java (Thread, Runnable, Callable)
//Java Memory Model (JMM) – Understanding Visibility & Reordering
//Volatile, Synchronized, and Atomic Variables in Java
//ThreadLocal and InheritableThreadLocal – When to Use?
//Java Executor Service & Different Thread Pools
//ThreadPoolExecutor Deep Dive – Internal Working & Tuning
//Producer-Consumer Problem & How to Solve It
//Exploring Virtual Threads (Lightweight Threads in Java) 🚀
//Important Interview Questions – Daemon Threads, Deadlocks, Livelocks, Starvation & Fork/Join Framework

/*
* what is Concurrency and Why It Matters?
*    Concurrency is the ability of a program to manage and execute multiple tasks simultaneously,
*    or at least in overlapping time periods, rather than processing them sequentially.
*    This doesn't always mean that tasks are literally running at the exact same time—as would be the case with parallelism—but
*    rather that the program can handle multiple operations without having to complete one before starting another.
*
*    There are several key reasons why concurrency is critical:

Improved Responsiveness: In applications such as user interfaces or network servers,
*                        concurrency allows a system to remain responsive. For example,
*                        a user interface can continue to accept input while performing background tasks,
*                        like loading data from a network.

Efficient Resource Utilization: Modern hardware often includes multiple CPU cores.
*                               Concurrency enables programs to leverage these cores effectively,
*                               distributing tasks across them to improve overall performance and throughput.

Better Scalability: By structuring an application to perform tasks concurrently,
*                   it becomes easier to scale the system as the workload increases.
*                   This is particularly important in server-side applications or microservices
*                   architectures where handling many simultaneous requests is essential.

Separation of Concerns: Concurrency can also help in organizing code by separating independent
*                       concerns into different threads or processes.
*                       This modular approach can simplify maintenance and improve the reliability of the system.

For example, consider a web server that handles hundreds of client requests. Without concurrency,
* each request would be processed one after the other, causing delays.
* With concurrency, the server can handle multiple requests at once,
*  ensuring that even if one request takes longer due to heavy computation or waiting for a database query,
*  other requests can still be processed concurrently.
*
*
*
*
*
*
* */

public class InterviewQues {
}
