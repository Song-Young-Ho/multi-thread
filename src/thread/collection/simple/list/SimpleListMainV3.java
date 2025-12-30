package thread.collection.simple.list;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

import static util.MyLogger.log;

public class SimpleListMainV3 {
    private Queue<String> queue = new ArrayDeque<>();

    public static void main(String[] args) throws InterruptedException {
        test(new SyncProxyList(new BasicList()));
    }

    private static void test(SimpleList list) throws InterruptedException {
        log(list.getClass().getSimpleName());

        Runnable addA = new Runnable() {
            @Override
            public void run() {
                list.add("A");
                log("Thread-1: list.add(A)");
            }
        };

        Runnable addB = new Runnable() {
            @Override
            public void run() {
                list.add("B");
                log("Thread-2: list.add(B)");
            }
        };

        Thread thread1 = new Thread(addA);
        Thread thread2 = new Thread(addB);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        log(list);
    }
}
