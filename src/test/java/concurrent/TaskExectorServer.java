package concurrent;

import java.io.IOException;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskExectorServer extends TimerTask {

    private static int THREAD_NUM = 100;

    private static ExecutorService executorService = Executors.newFixedThreadPool(THREAD_NUM);

    public static void main(String[] args) throws IOException {

       Object o = new Object();
        System.out.println(o.hashCode());
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
