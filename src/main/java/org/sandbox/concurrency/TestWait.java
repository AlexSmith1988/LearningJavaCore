package org.sandbox.concurrency;

/**
 * Created by AIKuznetsov on 03.04.2017.
 */
public class TestWait {

    public static void main(String[] args) throws InterruptedException {
        new TestWait().doSome();
    }

    void doSome() throws InterruptedException {

        Object o = new Object();
        synchronized (o) {
//            o.wnew OBject()ait();
        }

        O.doSome();
        A.doSome();
        B.doSome();


    }
}

interface O {
    static void doSome() {
        System.out.println("O");
    }

    static void doSome1() {
        System.out.println("O");
    }
}

class A implements O {
    static void doSome() {
        System.out.println("A");
    }
}

class B extends A {
    static void doSome() {
        System.out.println("B");
    }

}
