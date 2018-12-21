package observer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<Integer>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        BlockingQueueProducer producer1 = new BlockingQueueProducer(blockingQueue);
        BlockingQueueProducer producer2 = new BlockingQueueProducer(blockingQueue);
        BlockingQueueProducer producer3 = new BlockingQueueProducer(blockingQueue);
        BlockingQueueConsumer consumer1 = new BlockingQueueConsumer(blockingQueue);
        BlockingQueueConsumer consumer2 = new BlockingQueueConsumer(blockingQueue);
        BlockingQueueConsumer consumer3 = new BlockingQueueConsumer(blockingQueue);
        executorService.execute(producer1);
        executorService.execute(producer2);
        executorService.execute(producer3);
        executorService.execute(consumer1);
        executorService.execute(consumer2);
        executorService.execute(consumer3);
        Thread.sleep(10 * 1000);
        producer1.stop();
        producer1.stop();
        producer3.stop();
        Thread.sleep(3 * 1000);
        executorService.shutdown();
    }
}
