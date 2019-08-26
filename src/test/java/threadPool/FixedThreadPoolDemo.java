package threadPool;

public class FixedThreadPoolDemo {

    private int num = 1;

    public static void main(String[] args) {
        FixedThreadPoolDemo fixedThreadPoolDemo = new FixedThreadPoolDemo();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (fixedThreadPoolDemo.num <= 100) {
                    synchronized (this) {
                        notify();
                        System.out.println(Thread.currentThread().getName() + "=====>" + fixedThreadPoolDemo.num++);
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                if (fixedThreadPoolDemo.num > 100) {
                    System.out.println("good");
                    System.out.println(Thread.currentThread().getName());
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());


    }


}
