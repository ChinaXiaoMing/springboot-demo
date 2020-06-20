package utils;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Author xiaoming
 * @Date 2020/6/6 16:07
 * @Version 1.0
 **/
public class DemoTest {

    @Test
    public void demoTest() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 20,
                3, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        CountDownLatch countDownLatch = new CountDownLatch(30);
        for (int i = 0; i < 30; i++) {
            threadPoolExecutor.execute(() -> {
                countDownLatch.countDown();
                System.out.println(Thread.currentThread().getName());
            });
        }
        try {
            countDownLatch.await();
            System.out.println("结束！");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPoolExecutor.shutdown();
    }

}
