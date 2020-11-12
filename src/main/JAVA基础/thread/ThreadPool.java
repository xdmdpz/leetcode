package main.JAVA基础.thread;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPool {
    public static void main(String[] args) {
        ScheduledExecutorServiceDemo(5);
    }

    public static void cache() {
        ExecutorService pool = Executors.newCachedThreadPool();
        long start = System.currentTimeMillis();
        pool.execute(() -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum = (int) Math.sqrt(i * i - 1 + i);
                System.out.println(sum);
            }
        });
        System.out.println("cache: " + (System.currentTimeMillis() - start));

    }

    public static void ScheduledExecutorServiceDemo(int corePoolSize) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(corePoolSize);

        for (int i = 0; i < 15; i = i + 5) {
            pool.schedule(() -> System.out.println("我被执行了，当前时间" + new Date()), i, TimeUnit.SECONDS);
        }
        pool.shutdown();
    }

}
