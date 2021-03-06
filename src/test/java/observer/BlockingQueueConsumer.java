package observer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

/**
 * @Description 阻塞队列模拟消费者
 * @Author xiaoming
 * @Date 2020-03-19 21:03:35
 * @Version 1.0
 **/
public class BlockingQueueConsumer implements Runnable {
    private BlockingQueue<Integer> queue;
    private static final int SLEEPTIME = 1000;

    public BlockingQueueConsumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        int data;
        Random random = new Random();
        System.out.println("Start consumer id: " + Thread.currentThread().getId());
        try {
            while (true) {
                Thread.sleep(random.nextInt(SLEEPTIME));
                if (!queue.isEmpty()) {
                    data = queue.take();
                    System.out.println("consumer " + Thread.currentThread().getId() + " consume data: " + data + ",size: " + queue.size());
                } else {
                    System.out.println("Queue is empty, consumer " + Thread.currentThread().getId() + " is waiting,size: " + queue.size());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
