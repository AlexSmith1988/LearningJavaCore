package org.sandbox.concurrency;

import java.util.concurrent.*;

/**
 * Created by AIKuznetsov on 21.03.2017.
 */
public class ExecutorServiceTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = new ThreadPoolExecutor(10, 15, 100, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(5));
        Future<?> ahha = service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("ahha");
            }
        });

        Future<String> submit = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "42";
            }
        });

        System.out.println(submit.get());

        Future<String> submitNew = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("submitNew interrupted");
                        return "42";
                    }
                }
            }
        });

        try {
            submitNew.get(1, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            System.out.println("done");
            submitNew.cancel(true);
        }

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("I'm interrupted");
                        return;
                    }
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.out.println("Sleep interrupted");
                        return;
                    }
                }
            }
        });

        thread.start();

        Thread.currentThread().sleep(300);

        thread.interrupt();

        System.out.println("Good");

        service.shutdown();

    }
}
