package org.sandbox.concurrency;

/**
 * Created by AIKuznetsov on 17.10.2016.
 */
class TestInterrupting {

    public static void main(String args[]) throws InterruptedException {
        Thread task = new Thread() {
            @Override
            public void run() {
                System.out.println("1: " + isInterrupted());
                Thread.currentThread().interrupt();
                System.out.println("I've interrupted it is " + isInterrupted());

                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Gotcha, interrupted myself.");
                }

                System.out.println("Working is done.");
            }
        };

        task.start();
        Thread.sleep(1000);
        try {
            System.out.println("Let's interrupt the motherfucker.");
            task.interrupt();
        } catch (Exception e) {
            System.out.println("Exception handled " + e);
        }
        task.join();

        System.out.println("Thread is interrupted: " + task.isInterrupted());

        System.out.println("I'm done with this shit.");

    }
}