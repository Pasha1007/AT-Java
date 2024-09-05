//V6.
//a)	Create a thread pool with a fixed number of threads using Executors and submit a task to the pool.
//b)	Create your own custom class with annotations, and make an object for it. Use getAnnotations() to print out all the annotations of the class.
//      Use getMethod() to get a specific method and print out all its annotations.
//c)	Create a generic class that can store a list of elements of any type, and add elements to it using List<T> and add().

package task4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Task4 {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (int i = 1; i <= 5; i++) {
            int taskNumber = i;
            executor.submit(() -> {
                System.out.println("Task " + taskNumber + " is running by " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Task " + taskNumber + " is completed by " + Thread.currentThread().getName());
            });
        }

        executor.shutdown();
    }
}

