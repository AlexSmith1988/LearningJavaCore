package org.sandbox.concurrency;

/**
 * Created by AIKuznetsov on 26.01.2017.
 */
public class LocalSynchTest {

    public static void main(String[] args) {
        doSome();

        new Runnable(){

            @Override
            public void run() {
                doSome();
            }
        };

    }
    
    static void doSome() {
        Object o = new Object(){};
        System.out.println(o.toString());

        synchronized (o) {
            StringBuilder sb = new StringBuilder("42");
            for (int i = 0; i < 1000; ++i) {
                sb.append(sb.toString());
            }
        }
    }
}
