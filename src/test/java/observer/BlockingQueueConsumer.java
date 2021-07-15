package observer;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 阻塞队列的消费者
 *
 * @author fu.yuanming
 * @date 2021-07-15
 */
@Slf4j
public class BlockingQueueConsumer implements Runnable {

    private final BlockingQueue<Integer> queue;

    private static final int SLEEP_TIME = 1;

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
                TimeUnit.SECONDS.sleep(random.nextInt(SLEEP_TIME));
                if (!queue.isEmpty()) {
                    data = queue.take();
                    log.info("consumer " + Thread.currentThread().getId() + " consume data: " + data + ",size: " + queue.size());
                } else {
                    log.info("Queue is empty, consumer " + Thread.currentThread().getId() + " is waiting,size: " + 0);
                }
            }
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}
