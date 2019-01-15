package threadPool;

import java.util.concurrent.*;

public class FixedThreadPoolDemo {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(3);

        System.out.println(Thread.currentThread().getName()+"1");

        ExecutorService executorService = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 3; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        System.out.println(Thread.currentThread().getName()+"2");

    }

}
