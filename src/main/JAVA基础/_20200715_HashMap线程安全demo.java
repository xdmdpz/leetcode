package main.JAVA基础;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 */
public class _20200715_HashMap线程安全demo {
    private static final Map<String, Integer> map = new HashMap<>();
    private static final ConcurrentHashMap<String, Integer> map2 = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<String, Integer> map3 = new ConcurrentHashMap<>();

    public synchronized void add() {
        Integer value = map.get("count");
        if (value == null) {
            map.put("count", 1);
        } else {
            map.put("count", value + 1);
        }
    }

    public void add2() {
        Integer value = map2.get("count");
        if (value == null) {
            map2.put("count", 1);
        } else {
            map2.put("count", value + 1);
        }
    }

    public void add3() {
        Integer value = map3.get("count");
        if (value == null) {
            map3.put("count", 1);
        } else {
            map3.put("count", map3.get("count") + 1);
        }
    }

    /**
     * ConcurrentHashMap的线程安全是相对于HashMap来说的，
     * 它的每个方法单独调用(如put方法)是线程安全的(通过分段锁来保证原子操作)，
     * 但是使用ConcurrentHashMap的业务代码的线程安全性是需要开发者自己来保证的。
     * 而HashMap之所以线程不安全，是由于其方法单独调用也是不安全的，
     * 如put方法，底层包含了很多其他逻辑，在执行put的底层逻辑时，随时会被其他线程打断。
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        _20200715_HashMap线程安全demo test = new _20200715_HashMap线程安全demo();
        for (int i = 0; i < 200; i++) {
            new Thread(test::add).start();
        }
        Thread.sleep(2000);
        ///----
        System.out.println(map.get("count"));

        for (int i = 0; i < 200; i++) {
            new Thread(test::add2).start();
        }
        Thread.sleep(2000);
        System.out.println("map2:" + map2.get("count"));
        for (int i = 0; i < 200; i++) {
            new Thread(test::add3).start();
        }
        Thread.sleep(2000);
        System.out.println("map3:" + map3.get("count"));

    }
}
