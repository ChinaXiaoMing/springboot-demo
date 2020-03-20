package observer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 阻塞队列模拟生产者
 * @Author xiaoming
 * @Date 2020-03-19 21:45:22
 * @Version 1.0
 **/
public class BlockingQueueProducer implements Runnable {
    private volatile boolean isRunning = true;
    private BlockingQueue<Integer> blockingQueue;
    private static AtomicInteger count = new AtomicInteger();
    private static final int SLEEP_TIME = 1000;

    public BlockingQueueProducer(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        int data;
        Random random = new Random();
        System.out.println("Start producer id: " + Thread.currentThread().getId());
        try {
            while (isRunning) {
                Thread.sleep(random.nextInt(SLEEP_TIME));
                data = count.incrementAndGet();
                System.out.println("producer " + Thread.currentThread().getId() + " create data: " + data + ",size: " + blockingQueue.size());
                if (blockingQueue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("failed to put data: " + data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public void stop() {
        isRunning = false;
    }
}
