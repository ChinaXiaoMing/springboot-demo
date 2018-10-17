package threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class FixedThreadPoolDemo {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 50; i++ ) {
           ((ScheduledExecutorService) executorService).schedule(new Runnable() {
               @Override
               public void run() {
                   System.out.println(Thread.currentThread().getName());
               }
           }, 2000L, TimeUnit.MILLISECONDS);
        }

    }

}
