package org.sandbox.concurrency;

import jdk.nashorn.internal.objects.annotations.Function;

import java.util.function.Consumer;

/**
 * Created by AIKuznetsov on 17.10.2016.
 */
public class SynchronizedTest {

    static String s;

    synchronized public String test1() {
        s = "test1";
        return s;
    }

    synchronized public String test2() {
        s = "test2";
        return s;
    }

    synchronized void test() {
//        test1();
        System.out.println(Thread.currentThread().getId());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId());
//        test1();
    }

    synchronized void testt() {
//        test2();
        System.out.println(Thread.currentThread().getId());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getId());
//        test2();
    }

    synchronized public void some() {
        System.out.println("Some");
    }

    public static void main(String[] args) throws InterruptedException {
        final SynchronizedTest test = new SynchronizedTest();
        class TestThread extends Thread {
            public TestThread(Consumer<SynchronizedTest> consumer) {
                super(new Runnable() {
                    public void run() {
                        consumer.accept(test);
                    }
                });
            }
        }
        TestThread testThread = new TestThread(SynchronizedTest::test);
        TestThread testThread1 = new TestThread(SynchronizedTest::testt);

        testThread.start();
        testThread1.start();

        Thread.currentThread().sleep(200);
        new TestThread(SynchronizedTest::some).start();

        testThread.join();
        testThread1.join();

        System.out.println(s);

    }

}
