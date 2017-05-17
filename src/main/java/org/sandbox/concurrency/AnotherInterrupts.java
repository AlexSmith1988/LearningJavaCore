package org.sandbox.concurrency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by AIKuznetsov on 17.05.2017.
 */
public class AnotherInterrupts {
    public static void main(String[] args) throws InterruptedException {
        String nameMeProperly = "NameMeProperly";
        new Thread(nameMeProperly) {
            @Override
            public void run() {
                while (true) {
                    if (interrupted()) {
                        break;
                    }
                }
                System.out.println("Someone interrupted me!");
            }
        }.start();

        int size = 1;
        Thread[] threads;
        do {
            System.out.println("Size: " + size);
            threads = new Thread[size <<= 1];
        } while (size == Thread.enumerate(threads));

        Thread.sleep(500);

       List<Thread> named = new ArrayList<>();
        Arrays.stream(threads)
                .filter(thread -> nameMeProperly.equalsIgnoreCase(thread != null ? thread.getName() : ""))
                .forEach(named::add);
        named.forEach(Thread::interrupt);
        named.forEach((thread) -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Something wrong");
            }
        });


    }
}
