package org.sandbox.concurrency;

import java.lang.reflect.Proxy;

/**
 * Created by AIKuznetsov on 22.03.2017.
 */
public class TestThreadException {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.currentThread().sleep(10000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted: " + Thread.currentThread().isInterrupted());
                }


            }
        });
        thread.start();


        thread.interrupt();
        while (true) {

        }
    }
}
