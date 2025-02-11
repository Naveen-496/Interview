package multithreads;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableExample implements Callable<String> {

    @Override
    public String call(){
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Result from callable and future.";

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> integerCallable = () -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 2;
        };
        FutureTask<String> futureTask = new FutureTask<>(new CallableExample());
        FutureTask<Integer> integerFutureTask = new FutureTask<>(integerCallable);
        Thread anotherTask = new Thread(futureTask);
        Thread intTask = new Thread(integerFutureTask);
        anotherTask.start();
        intTask.start();

        long start = System.currentTimeMillis();
        String result = futureTask.get();
        System.out.printf("[%dms] %s%n", System.currentTimeMillis() - start, result);

        Integer integer = integerFutureTask.get();
        System.out.printf("[%dms] %s%n", System.currentTimeMillis() - start, integer);

        anotherTask.join();
        intTask.join();

    }
}
